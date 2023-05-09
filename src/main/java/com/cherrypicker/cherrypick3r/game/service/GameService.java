package com.cherrypicker.cherrypick3r.game.service;

import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {

    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    private final TagRepository tagRepository;

    private final ShopRepository shopRepository;

    private final ResultRepository resultRepository;

    private final GameCalc gameCalc;

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
        tag.setTagsByList(gameCalc.makeSimilarly(gameTagValues, userTagValues, 4L));

        Game game = Game.builder()
                .totalRound(12L) // 임의의 라운드 12라운드로 설정, 3라운드씩 추천 (4번 후 종료)
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

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다. (비율 : 1/10)
        gameTag.setTagsByList(gameCalc.makeUnsimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 10L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        // 만약 게임이 끝에 도달했다면 결과를 도출한다. (다른 함수로 뺼 것)
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

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 일부 유사하게 만든다. (비율 : 1/10)
        gameTag.setTagsByList(gameCalc.makeSimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 10L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        // 만약 게임이 끝에 도달했다면 결과를 도출한다. (다른 함수로 뺼 것)
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

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다. (비율 : 1/10)
        gameTag.setTagsByList(gameCalc.makeUnsimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 10L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        // 만약 게임이 끝에 도달했다면 결과를 도출한다. (다른 함수로 뺼 것)
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

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 일부 유사하게 만든다. (비율 : 1/10)
        gameTag.setTagsByList(gameCalc.makeSimilarly(gameTag.getTagsByList(), shopTag.getTagsByList(), 10L));

        // 게임의 진행을 반영한다.
        game.increaseCurRound();

        // 만약 게임이 끝에 도달했다면 결과를 도출한다. (다른 함수로 뺼 것)
        gameRepository.save(game);
        return game;
    }

    @Transactional
    public ShopDto endGame(GameDto gameDto, ShopDto shopDto) {
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

        // 결과(체리픽)를 만든다.
        result = Result.builder()
                .shop(shop)
                .game(game)
                .build();
        resultRepository.save(result);

        // 가게의 picked_count를 1늘린다.
        shop.increasePickedCount();
        shopRepository.save(shop);

        // 결과 가게의 DTO를 반환
        return shop.toDto();
    }

    @Transactional
    public Shop endGame(Game game, Shop shop) {
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

        // 결과(체리픽)를 만든다.
        result = Result.builder()
                .shop(shop)
                .game(game)
                .build();
        resultRepository.save(result);

        // 가게의 picked_count를 1늘린다.
        shop.increasePickedCount();
        shopRepository.save(shop);

        // 결과 가게의 DTO를 반환
        return shop;
    }

    /*
    // TODO: 다음 추천 가게를 뽑는 함수
    @Transactional
    public List<ShopDto> makeRecommendations(GameDto gameDto) {

        // TODO: 만약 게임이 방금 시작됐다면 (curstage == 0 이라면) 랜덤하게 가게 3개를 뽑아서 반환

        // TODO: 게임의 태그와 가장 유사한 가게 2개를 뽑음

        // TODO: 랜덤하게 가게 1개를 뽑음

    }

    // TODO: 다음 추천 가게를 유저가 선택한 태그를 하나도 가지지 않는 애들을 제외하고 진행
    @Transactional
    public List<ShopDto> makeConditionalRecommendations(GameDto gameDto, Tag tag) {
        // TODO: 모든 과정중에서 유저가 고른 태그가 일정 개수 이상 없는 가게는 제외함

        // TODO: 만약 게임이 방금 시작됐다면 (curstage == 0 이라면) 랜덤하게 가게 3개를 뽑아서 반환

        // TODO: 게임의 태그와 가장 유사한 가게 2개를 뽑음

        // TODO: 랜덤하게 가게 1개를 뽑음
    }

    // TODO: 게임의 태그와 가장 유사한 가게 검색 로직
    */
}
