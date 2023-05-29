package com.cherrypicker.cherrypick3r.game.service;

import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopScoreDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopSimilarityDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service
public class GameService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final TagRepository tagRepository;
    private final ShopRepository shopRepository;
    private final ResultRepository resultRepository;
    private final GameCalc gameCalc;
    private final ShopClassifyService shopClassifyService;

    @Transactional
    public GameDto makeGame(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        Tag tag;

        if (user == null) {
            return null; // UserNotFound 에러 핸들링으로 바꿔야함
        }

        // 새로운 게임 태그 생성 및 영속성 등록
        tag = new Tag();
        tagRepository.save(tag);

        // TODO: 모든 가게 태그의 평균치를 구해서 초기값을 설정해야 함 (임시값 : 0.5)
        // 유저의 기본 태그를 반영하기 위해서 유저의 기본 태그와 높은 가중치로 한 번 닮음 연산을 해야 함.
        List<Double> gameTagValues = tag.getTagsByList();
        List<Double> userTagValues = user.getTag().getTagsByList();
        for (int i=0;i<28;i++) { // 임시 값 주입
            gameTagValues.set(i, 0.5D);
        }
        tag.setTagsByList(gameCalc.makeSimilarly(gameTagValues, userTagValues, 3L));

        Game game = Game.builder()
                .totalRound(3L) // 임의의 라운드 12라운드로 설정, 3라운드씩 추천 (4번 후 종료)
                .curRound(0L) // 0라운드부터 시작
                .status(0L) // 게임은 시작하지 않은 상태
                .user(user) // 유저가 존재한다면 게임을 시작시킨 유저를 설정
                .tag(tag) // 새로운 게임 태그 외래키 연결
                .build();
        gameRepository.save(game);

        // 게임 시작
        game.setStatusStart();

        return (game.toDto());
    }

    @Transactional
    public GameDto swipeLeft(GameDto gameDto, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        Game game = gameRepository.findById(gameDto.getId()).get();
        Tag shopTag = shop.getTag();
        Tag gameTag = game.getTag();

        if (shop == null) {
            return null; // TODO: ShopNotFoundException
        }
        if (game == null) {
            return null; // TODO: GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // TODO: EndedGameException
        }

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다. (비율 : 1/5)
        gameTag.setTagsByList(gameCalc.makeUnsimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 5L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        gameRepository.save(game);
        return game.toDto();
    }

    @Transactional
    public GameDto swipeRight(GameDto gameDto, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        Game game = gameRepository.findById(gameDto.getId()).get();
        Tag shopTag = shop.getTag();
        Tag gameTag = game.getTag();

        if (shop == null) {
            return null; // TODO: ShopNotFoundException
        }
        if (game == null) {
            return null; // TODO: GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // TODO: EndedGameException
        }

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 일부 유사하게 만든다. (비율 : 1/5)
        gameTag.setTagsByList(gameCalc.makeSimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 5L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        gameRepository.save(game);
        return game.toDto();
    }

    @Transactional
    public Game swipeLeft(Game game, Shop shop) {
        Tag shopTag = shop.getTag();
        Tag gameTag = game.getTag();

        if (shop == null) {
            return null; // TODO: ShopNotFoundException
        }
        if (game == null) {
            return null; // TODO: GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // TODO: EndedGameException
        }

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다. (비율 : 1/5)
        gameTag.setTagsByList(gameCalc.makeUnsimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 5L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        gameRepository.save(game);
        return game;
    }

    @Transactional
    public Game swipeRight(Game game, Shop shop) {
        Tag shopTag = shop.getTag();
        Tag gameTag = game.getTag();

        if (shop == null) {
            return null; // TODO: ShopNotFoundException
        }
        if (game == null) {
            return null; // TODO: GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // TODO: EndedGameException
        }

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 일부 유사하게 만든다. (비율 : 1/5)
        gameTag.setTagsByList(gameCalc.makeSimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 5L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        gameRepository.save(game);
        return game;
    }

    @Transactional
    public ResultDto endGame(GameDto gameDto, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        Game game = gameRepository.findById(gameDto.getId()).get();
        Result result;

        if (shop == null) {
            return null; // TODO: ShopNotFoundException
        }
        if (game == null) {
            return null; // TODO: GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // TODO: EndedGameException
        }

        // 게임의 상태를 종료로 만든다.
        game.setStatusEnd();

        // 가게의 picked_count를 1늘린다.
        shop.increasePickedCount();
        shopRepository.save(shop);

        //TODO: 정확도가 음수로 나오는 문제 해결할 것
        // 결과(체리픽)를 만든다.
        result = Result.builder()
                .similarity(gameCalc.euclideanSimilarity(game.getTag().getTagsByList(), shop.getTag().getTagsByList()))
                .score(gameCalc.calculateScore(game.getTag().getTagsByList(), shop.getTag().getTagsByList()))
                .shop(shop)
                .game(game)
                .build();
        resultRepository.save(result);

        // 결과 가게의 DTO를 반환
        return result.toDto();
    }

    @Transactional
    public Result endGame(Game game, Shop shop) {
        Result result;

        if (shop == null) {
            return null; // TODO: ShopNotFoundException
        }
        if (game == null) {
            return null; // TODO: GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // TODO: EndedGameException
        }

        // 게임의 상태를 종료로 만든다.
        game.setStatusEnd();

        // 가게의 picked_count를 1늘린다.
        shop.increasePickedCount();
        shopRepository.save(shop);

        // 결과(체리픽)를 만든다.
        result = Result.builder()
                .similarity(gameCalc.euclideanSimilarity(game.getTag().getTagsByList(), shop.getTag().getTagsByList()))
                .score(gameCalc.calculateScore(game.getTag().getTagsByList(), shop.getTag().getTagsByList()))
                .shop(shop)
                .game(game)
                .build();
        resultRepository.save(result);

        // 결과 가게를 반환
        return result;
    }

    // 특정 태그에 따라 모든 가게를 조회하는 함수
    @Transactional
    public List<ShopDto> findShopsByTags(List<Long> tags) {
        List<ShopDto> shopDtos = new ArrayList<>();

        // 태그에 해당하는 가게들 조회
        List<Shop> shops = shopClassifyService.findAllShopByClassifyTags(tags);

        // Dto로 변환
        for (Shop shop : shops) {
            shopDtos.add(shop.toDto());
        }

        // 모든 가게를 반환
        return shopDtos;
    }

    // 다음 추천 가게를 뽑는 함수
    @Transactional
    public List<ShopDto> makeRecommendations(GameDto gameDto, List<ShopDto> shopDtos) {
        List<ShopDto> recommends = new ArrayList<>();

        // 랜덤 셔플
        Collections.shuffle(shopDtos);

        // 1: 만약 게임이 방금 시작됐다면 (curRound == 0 이라면) 랜덤하게 가게 3개를 뽑아서 반환
        if (gameDto.getCurRound() == 0L) {
            for (int i = 0; i < 3; i++) {
                recommends.add(shopDtos.get(i));
                // 여기서 뽑은 가게를 지울지 말지 고민 (일단 안 지움)
            }
            return recommends;
        }

        // 2-1: 게임의 태그와 가장 유사한 가게 2개를 뽑음
        List<ShopDto> similarShops =  findShopsBySimilarity(gameDto, shopDtos, 2L);
        recommends.add(similarShops.get(0));
        recommends.add(similarShops.get(1));

        // 2-2: 랜덤하게 가게 1개를 뽑음
        recommends.add(shopDtos.get(0));

        return recommends;
    }

    // 게임의 태그와 가장 유사한 가게 1개 검색 로직
    @Transactional
    public ShopDto findShopBySimilarity(GameDto gameDto, List<ShopDto> shopDtos) {
        List<Double> gameTagValues = gameDto.getTag().getTagsByList();
        Double similarity = Double.MAX_VALUE;
        ShopDto resultDto = null;

        for (ShopDto shopDto : shopDtos) {
            List<Double> shopTagValues = shopDto.getTag().getTagsByList();

            Double curSimilarity = gameCalc.euclideanSimilarity(gameTagValues, shopTagValues);
            if (similarity > curSimilarity) {
                similarity = curSimilarity;
                resultDto = shopDto;
            }
        }

        if (resultDto == null) {
            return null; // TODO: ShopNotFoundException
        }

        return resultDto;
    }

    // 유사도를 기반으로 게임의 태그와 가장 유사한 가게 (n - 1)개 + 랜덤 1개 검색 로직
    @Transactional
    public List<ShopDto> findShopsBySimilarity(GameDto gameDto, List<ShopDto> shopDtos, Long n) {
        Random random = new Random();
        Game game = gameRepository.findById(gameDto.getId()).get();
        List<Double> gameTagValues = game.getTag().getTagsByList();
        List<ShopDto> resultDtos = new ArrayList<>();
        List<ShopSimilarityDto> shopSimilarityDtos = new ArrayList<>();

        // 처음 3개의 음식점은 랜덤으로 추천해준다.
        if (game.getCurRound() == 0) {
            resultDtos.add(shopDtos.get(random.nextInt(shopDtos.size())));
            resultDtos.add(shopDtos.get(random.nextInt(shopDtos.size())));
            resultDtos.add(shopDtos.get(random.nextInt(shopDtos.size())));
            return resultDtos;
        }

        // n개의 {음식점, 유사도} 값을 가진 리스트를 만든다.
        for (ShopDto shopDto : shopDtos) {
            List<Double> shopTagValues = shopDto.getTag().getTagsByList();

            ShopSimilarityDto shopSimilarityDto = new ShopSimilarityDto(shopDto, gameCalc.euclideanSimilarity(gameTagValues, shopTagValues));
            shopSimilarityDtos.add(shopSimilarityDto);
        }

        // similarity 값을 기준으로 오름차순으로 정렬
        Collections.sort(shopSimilarityDtos, Comparator.comparingDouble(ShopSimilarityDto::getSimilarity));

        // 1개의 가게를 랜덤하게 하나 뽑는다.
        resultDtos.add(shopSimilarityDtos.get(random.nextInt(shopSimilarityDtos.size())).getShopDto());

        // 2개의 가게를 유사도 가까운 순서대로 뽑는다.
        for (ShopSimilarityDto shopSimilarityDto : shopSimilarityDtos) {
            if ((game.findRecommendedShopIdIndexByShopId(shopSimilarityDto.getShopDto().getId()) == -1) && (!shopSimilarityDto.getShopDto().getId().equals(resultDtos.get(0).getId()))) {
                // 이미 추천하지 않았다면 중복이 아니므로 뽑는다. && 랜덤으로 뽑은 것과 겹치지 않는다면.
                resultDtos.add(shopSimilarityDto.getShopDto());
                if (resultDtos.size() == n) {
                    // n개를 다 뽑았다면 종료
                    break ;
                }
            }
        }

        return resultDtos;
    }

    // 스코어가 가장 높은 가게 1개 검색 로직
    @Transactional
    public ShopDto findShopByScore(GameDto gameDto, List<ShopDto> shopDtos) {
        List<Double> gameTagValues = gameDto.getTag().getTagsByList();
        Double score = 0D;
        ShopDto resultDto = null;

        for (ShopDto shopDto : shopDtos) {
            List<Double> shopTagValues = shopDto.getTag().getTagsByList();

            Double curScore = gameCalc.calculateScore(gameTagValues, shopTagValues);
            if (resultDto == null) {
                score = curScore;
                resultDto = shopDto;
            }
            else if (score <= curScore) {
                score = curScore;
                resultDto = shopDto;
            }
        }

        if (resultDto == null) {
            return null; // TODO: ShopNotFoundException
        }

        return resultDto;
    }

    // 스코어를 기반으로 게임의 태그와 가장 유사한 가게 (n - 1)개 + 랜덤 1개 검색 로직
    @Transactional
    public List<ShopDto> findShopsByScore(GameDto gameDto, List<ShopDto> shopDtos, Long n) {
        Random random = new Random();
        Game game = gameRepository.findById(gameDto.getId()).get();
        List<Double> gameTagValues = game.getTag().getTagsByList();
        List<ShopDto> resultDtos = new ArrayList<>();
        List<ShopScoreDto> shopScoreDtos = new ArrayList<>();

        // 처음 3개의 음식점은 랜덤으로 추천해준다.
        if (game.getCurRound() == 0) {
            resultDtos.add(shopDtos.get(random.nextInt(shopDtos.size())));
            resultDtos.add(shopDtos.get(random.nextInt(shopDtos.size())));
            resultDtos.add(shopDtos.get(random.nextInt(shopDtos.size())));
            return resultDtos;
        }

        // n개의 {음식점, 스코어} 값을 가진 리스트를 만든다.
        for (ShopDto shopDto : shopDtos) {
            List<Double> shopTagValues = shopDto.getTag().getTagsByList();

            ShopScoreDto shopScoreDto = new ShopScoreDto(shopDto, gameCalc.calculateScore(gameTagValues, shopTagValues));
            shopScoreDtos.add(shopScoreDto);
        }

        // score 값을 기준으로 내림차순으로 정렬
        Collections.sort(shopScoreDtos, Comparator.comparingDouble(ShopScoreDto::getScore).reversed());

        // 1개의 가게를 랜덤하게 하나 뽑는다.
        resultDtos.add(shopScoreDtos.get(random.nextInt(shopScoreDtos.size())).getShopDto());

        // 2개의 가게를 유사도 가까운 순서대로 뽑는다.
        for (ShopScoreDto shopScoreDto : shopScoreDtos) {
            if ((game.findRecommendedShopIdIndexByShopId(shopScoreDto.getShopDto().getId()) == -1) && (!shopScoreDto.getShopDto().getId().equals(resultDtos.get(0).getId()))) {
                // 이미 추천하지 않았다면 중복이 아니므로 뽑는다. && 랜덤으로 뽑은 것과 겹치지 않는다면.
                resultDtos.add(shopScoreDto.getShopDto());
                if (resultDtos.size() == n) {
                    // n개를 다 뽑았다면 종료
                    break ;
                }
            }
        }

        return resultDtos;
    }

    @Transactional
    public List<ShopDto> find3ShopByRandom(GameDto gameDto) {
        Game game = gameRepository.findById(gameDto.getId()).get();
        List<Long> recommendedShopIDs = game.getRecommendedShopIds();
        List<ShopDto> shopDtos = new ArrayList<>();
        int len = recommendedShopIDs.size(), cnt = 0, i, j;

        // 3개의 랜덤한 가게를 겹치지 않게 뽑는다.
        while (cnt < 3) {
            Shop shop = shopRepository.findRandomShop().get();
            for (i=0;i<len;i++) {
                if (shop.getId() == recommendedShopIDs.get(i)) {
                    break ;
                }
            }
            for (j=0;j<cnt;j++) {
                if (shop.getId() == shopDtos.get(j).getId()) {
                    break ;
                }
            }
            if (i == len && j == cnt) {
                shopDtos.add(shop.toDto());
                cnt++;
            }
        }

        return shopDtos;
    }

    // Shop리스트로 게임에서 추천한 가게들을 저장해주는 함수
    @Transactional
    public void saveRecommendedShopsByList(Game game, List<Shop> shops) {
        for (Shop shop : shops) {
            game.addRecommendedShopId(shop.getId());
        }
    }

    // ShopDto리스트로 게임에서 추천한 가게들을 저장해주는 함수
    @Transactional
    public void saveRecommendedShopsByList(GameDto gameDto, List<ShopDto> shopDtos) {
        Game game = gameRepository.findById(gameDto.getId()).get();

        for (ShopDto shopDto : shopDtos) {
            game.addRecommendedShopId(shopDto.getId());
        }
        gameRepository.save(game);
    }


    // gameId로 게임 객체를 찾아서 반환하는 함수
    @Transactional
    public GameDto findGameDtoById(Long gameId) {
        return gameRepository.findById(gameId).get().toDto();
    }
}
