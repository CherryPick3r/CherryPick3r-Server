package com.cherrypicker.cherrypick3r.preference.service;

import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.preference.domain.PreferenceGame;
import com.cherrypicker.cherrypick3r.preference.domain.PreferenceGameRepository;
import com.cherrypicker.cherrypick3r.preference.dto.CheckPreferenceGameResponse;
import com.cherrypicker.cherrypick3r.preference.dto.PreferenceCard;
import com.cherrypicker.cherrypick3r.preference.dto.UserPreferenceResponse;
import com.cherrypicker.cherrypick3r.preference.dto.UserPreferenceStartResponse;
import com.cherrypicker.cherrypick3r.preferenceShop.domain.PreferenceShop;
import com.cherrypicker.cherrypick3r.preferenceShop.domain.PreferenceShopRepository;
import com.cherrypicker.cherrypick3r.shop.service.ShopService;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.tag.service.TagService;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceGameService {

    private final PreferenceGameRepository preferenceGameRepository;

    private final TagRepository tagRepository;

    private final UserRepository userRepository;

    private final ShopRepository shopRepository;

    private final PreferenceShopRepository preferenceShopRepository;

    private final ShopService shopService;

    private final TagService tagService;

    private final GameCalc gameCalc;

    @Transactional
    public UserPreferenceStartResponse remakeGame(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();

        if (user == null) {
            return null; // UserNotFound 에러 핸들링으로 바꿔야함
        }

        // 유저 초기 취향 게임 기존 정보 삭제
        List<PreferenceGame> preferenceGames =  preferenceGameRepository.findAllByUser(user);
        for (PreferenceGame preferenceGame : preferenceGames) {
            preferenceGameRepository.delete(preferenceGame);
        }

        // 유저 초기 취향 초기화
        List<Double> settingValues = new ArrayList<>();
        for (int i=0;i<28;i++) {
            settingValues.add(0D);
        }
        user.getTag().setTagsByList(settingValues);

        // 초기취향 게임 생성
        PreferenceGame preferenceGame = PreferenceGame.builder()
                .totalRound(5L) // 임의의 라운드 5라운드로 설정
                .curRound(0L) // 0라운드부터 시작
                .status(0L) // 게임은 시작하지 않은 상태
                .user(user) // 유저가 존재한다면 초기취향 게임을 시작시킨 유저를 설정
                .build();

        // 초기취향 게임 시작
        preferenceGame.setStatusStart();

//        // TODO: 일단 랜덤하게 가게를 뽑아서 주지만 정형화한 가게 5개를 만들어서 줄 필요성이 있음
//        // 초기 취향 게임 가게 5개 생성, 일단 랜덤한 5개의 가게를 뽑아서 줌
//        List<Shop> shops = shopRepository.findRandomShops();
//        List<PreferenceCard> preferenceCards = new ArrayList<>();
//        for (Shop shop : shops) {
//            preferenceGame.getRecommendedShopIds().add(shop.getId());
//            preferenceCards.add(new PreferenceCard(tagService.getTop5TagPairDtoByShop(shop)));
//        }

        // 정형화한 가게 5개를 만들어서 줌
        List<PreferenceShop> preferenceShops = preferenceShopRepository.findRandomPreferenceShops();
        List<PreferenceCard> preferenceCards = new ArrayList<>();
        for (PreferenceShop preferenceShop : preferenceShops) {
            preferenceGame.getRecommendedShopIds().add(preferenceShop.getId());
            preferenceCards.add(new PreferenceCard(tagService.getTop5TagPairDtoByPreferenceShop(preferenceShop)));
        }

        // 생성한 초기취향 게임 저장
        preferenceGameRepository.save(preferenceGame);

        // 결과 생성
        UserPreferenceStartResponse userPreferenceStartResponse = new UserPreferenceStartResponse(preferenceGame, preferenceCards);

        return userPreferenceStartResponse;
    }

    @Transactional
    public UserPreferenceStartResponse makeGame(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();

        if (user == null) {
            return null; // UserNotFound 에러 핸들링으로 바꿔야함
        }

        // 유저 초기 취향 초기화
        List<Double> settingValues = new ArrayList<>();
        for (int i=0;i<28;i++) {
            settingValues.add(0D);
        }
        user.getTag().setTagsByList(settingValues);

        // 초기취향 게임 생성
        PreferenceGame preferenceGame = PreferenceGame.builder()
                .totalRound(5L) // 임의의 라운드 5라운드로 설정
                .curRound(0L) // 0라운드부터 시작
                .status(0L) // 게임은 시작하지 않은 상태
                .user(user) // 유저가 존재한다면 초기취향 게임을 시작시킨 유저를 설정
                .build();

        // 초기취향 게임 시작
        preferenceGame.setStatusStart();

//        // TODO: 일단 랜덤하게 가게를 뽑아서 주지만 정형화한 가게 5개를 만들어서 줄 필요성이 있음
//        // 초기 취향 게임 가게 5개 생성, 일단 랜덤한 5개의 가게를 뽑아서 줌
//        List<Shop> shops = shopRepository.findRandomShops();
//        List<PreferenceCard> preferenceCards = new ArrayList<>();
//        for (Shop shop : shops) {
//            preferenceGame.getRecommendedShopIds().add(shop.getId());
//            preferenceCards.add(new PreferenceCard(tagService.getTop5TagPairDtoByShop(shop)));
//        }

        // 정형화한 가게 5개를 만들어서 줌
        List<PreferenceShop> preferenceShops = preferenceShopRepository.findRandomPreferenceShops();
        List<PreferenceCard> preferenceCards = new ArrayList<>();
        for (PreferenceShop preferenceShop : preferenceShops) {
            preferenceGame.getRecommendedShopIds().add(preferenceShop.getId());
            preferenceCards.add(new PreferenceCard(tagService.getTop5TagPairDtoByPreferenceShop(preferenceShop)));
        }

        // 생성한 초기취향 게임 저장
        preferenceGameRepository.save(preferenceGame);

        // 결과 생성
        UserPreferenceStartResponse userPreferenceStartResponse = new UserPreferenceStartResponse(preferenceGame, preferenceCards);

        return userPreferenceStartResponse;
    }

    // TODO: 초기취향 게임의 정제화된 가게 태그로 설정 가능하게 갈아끼기
    // 일단 랜덤하게 뽑은 5개의 가게를 기준으로 초기취향 게임을 진행하게 로직 작성
    @Transactional
    public UserPreferenceResponse swipeLeft(String userEmail, Long preferenceGameId) {
        PreferenceGame preferenceGame = preferenceGameRepository.getReferenceById(preferenceGameId);
        User user = preferenceGame.getUser();
        Tag userTag = user.getTag();
        Tag cardTag = shopRepository.findById(preferenceGame.getRecommendedShopIds().get(preferenceGame.getCurRound().intValue())).get().getTag();

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다. (비율 : 1/7)
        userTag.setTagsByList(gameCalc.makeUnsimilarly(userTag.getTagsByList(), cardTag.getTagsByList(), 7L));

        // 게임의 진행을 반영한다.
        preferenceGame.increaseCurRound();

        // 게임 종료
        if (preferenceGame.getCurRound() == 5) {
            preferenceGame.setStatusEnd();
        }

        // 저장
        tagRepository.save(userTag);
        userRepository.save(user);
        preferenceGameRepository.save(preferenceGame);

        // 결과 생성
        UserPreferenceResponse userPreferenceResponse = new UserPreferenceResponse(preferenceGame);

        return userPreferenceResponse;
    }

    @Transactional
    public UserPreferenceResponse swipeRight(String userEmail, Long preferenceGameId) {
        PreferenceGame preferenceGame = preferenceGameRepository.getReferenceById(preferenceGameId);
        User user = preferenceGame.getUser();
        Tag userTag = user.getTag();
        Tag cardTag = shopRepository.findById(preferenceGame.getRecommendedShopIds().get(preferenceGame.getCurRound().intValue())).get().getTag();

        // 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다. (비율 : 1/7)
        userTag.setTagsByList(gameCalc.makeSimilarly(userTag.getTagsByList(), cardTag.getTagsByList(), 7L));

        // 게임의 진행을 반영한다.
        preferenceGame.increaseCurRound();

        // 게임 종료
        if (preferenceGame.getCurRound() == 5) {
            preferenceGame.setStatusEnd();
        }

        // 저장
        tagRepository.save(userTag);
        userRepository.save(user);
        preferenceGameRepository.save(preferenceGame);

        // 결과 생성
        UserPreferenceResponse userPreferenceResponse = new UserPreferenceResponse(preferenceGame);

        return userPreferenceResponse;
    }

    @Transactional
    public CheckPreferenceGameResponse findPlayRecode(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        List<PreferenceGame> preferenceGames = preferenceGameRepository.findAllByUser(user);

        for (PreferenceGame preferenceGame : preferenceGames) {
            if (preferenceGame.getTotalRound() == preferenceGame.getCurRound()) {
                return CheckPreferenceGameResponse.builder().isPlayed(1L).build();
            }
        }
        return CheckPreferenceGameResponse.builder().isPlayed(0L).build();
    }

}
