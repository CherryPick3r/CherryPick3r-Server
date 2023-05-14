package com.cherrypicker.cherrypick3r.game.service;

import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GameServiceTest {

    private UserRepository userRepository;

    private GameRepository gameRepository;

    private GameService gameService;

    private TagRepository tagRepository;

    private ShopRepository shopRepository;

    private ResultRepository resultRepository;

    private GameCalc gameCalc;

    @Autowired
    public GameServiceTest(UserRepository userRepository, GameRepository gameRepository, GameService gameService, TagRepository tagRepository, ShopRepository shopRepository, ResultRepository resultRepository, GameCalc gameCalc) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.gameService = gameService;
        this.tagRepository = tagRepository;
        this.shopRepository = shopRepository;
        this.resultRepository = resultRepository;
        this.gameCalc = gameCalc;
    }

    @BeforeEach
    public void beforeEach() {
        // 데이터 삭제 순서 중요 : 무결성에 위배되지 않게 하기위해서 중요함
        resultRepository.deleteAll();
        gameRepository.deleteAll();
        shopRepository.deleteAll();
        userRepository.deleteAll();
        tagRepository.deleteAll();
    }

    @Test
    public void MakeGameTest() {
        // 유저 생성
        String email = "test@naver.com";
        String nickname = "테스트계정";
        String auth = "ROLE_ADMIN";

        Tag tag = new Tag();

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth(auth)
                .tag(tag)
                .build();

        List<Double> userTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                userTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                userTagValues.add((i * 0.01D));
            }
        }

        tag.setTagsByList(userTagValues);

        tagRepository.save(tag);
        userRepository.save(user);

        // 음식점 생성
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag2 = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag2)
                .build();

        tagRepository.save(tag2);
        shopRepository.save(shop);

        // 게임 생성
        gameService.makeGame(user.getEmail());

        Game game = gameRepository.findAll().get(0);

        // 결과
        Tag tag1 = game.getTag();
        List<Double> tagValues = tag1.getTagsByList();
        System.out.println("*********************************************************");
        System.out.println("*--------------------🔥MakeGameTest🔥--------------------*");
        System.out.println("*---------------------🚀TEST START🚀---------------------*");
        System.out.println("*********************************************************");
        Assertions.assertEquals(game.getUser().getEmail(), user.getEmail());
        Assertions.assertEquals(game.getTotalRound(), 12L);
        Assertions.assertEquals(game.getCurRound(), 0L);
        Assertions.assertEquals(game.getStatus(), 2L);
        for (int i=0;i<28;i++) {
            System.out.println("---------------------------------------------------------");
            System.out.println("gameValue" + i + " : " + 0.5D);
            System.out.println("userValue" + i + " : " + userTagValues.get(i));
            System.out.println("gameValue" + i + " : " + tagValues.get(i));
        }
        System.out.println("*********************************************************");
        System.out.println("*-------------------🥳MakeGameTest🥳---------------------*");
        System.out.println("*------------------🎉TEST SUCCESSFUL🎉-------------------*");
        System.out.println("*********************************************************");
    }

    @Test
    public void SwipeLeftTest() {
        // 유저 생성
        String email = "test@naver.com";
        String nickname = "테스트계정";
        String auth = "ROLE_ADMIN";

        Tag tag = new Tag();

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth(auth)
                .tag(tag)
                .build();

        List<Double> userTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                userTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                userTagValues.add((i * 0.01D));
            }
        }

        tag.setTagsByList(userTagValues);

        tagRepository.save(tag);
        userRepository.save(user);

        // 음식점 생성
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag2 = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag2)
                .build();

        List<Double> shopTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                shopTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                shopTagValues.add((i * 0.01D));
            }
        }

        tag2.setTagsByList(shopTagValues);

        tagRepository.save(tag2);
        shopRepository.save(shop);

        // 게임 생성
        gameService.makeGame(user.getEmail());

        Game game = gameRepository.findAll().get(0);

        // 원래 값 저장
        List<Double> originValues = game.getTag().getTagsByList();

        // 왼쪽으로 스와이프
        gameService.swipeLeft(game, shop);

        // 결과를 출력
        Tag tag1 = game.getTag();
        List<Double> tagValues = tag1.getTagsByList();
        System.out.println("*********************************************************");
        System.out.println("*-------------------🔥SwipeLeftTest🔥--------------------*");
        System.out.println("*---------------------🚀TEST START🚀---------------------*");
        System.out.println("*********************************************************");
        for (int i=0;i<28;i++) {
            System.out.println("---------------------------------------------------------");
            System.out.println("gameValue" + i + " : " + originValues.get(i));
            System.out.println("shopValue" + i + " : " + userTagValues.get(i));
            System.out.println("gameValue" + i + " : " + tagValues.get(i));
            if ((originValues.get(i) < userTagValues.get(i) && originValues.get(i) < tagValues.get(i)) || (originValues.get(i) > userTagValues.get(i) && originValues.get(i) > tagValues.get(i))) {
                System.out.println("*********************************************************");
                System.out.println("*---------------------SwipeLeftTest---------------------*");
                System.out.println("*-------------------TEST UNSUCCESSFUL-------------------*");
                System.out.println("*********************************************************");
                return ;
            }
        }
        System.out.println("*********************************************************");
        System.out.println("*--------------------🥳SwipeLeftTest🥳-------------------*");
        System.out.println("*-------------------🎉TEST SUCCESSFUL🎉------------------*");
        System.out.println("*********************************************************");
    }

    @Test
    public void SwipeRightTest() {
        // 유저 생성
        String email = "test@naver.com";
        String nickname = "테스트계정";
        String auth = "ROLE_ADMIN";

        Tag tag = new Tag();

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth(auth)
                .tag(tag)
                .build();

        List<Double> userTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                userTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                userTagValues.add((i * 0.01D));
            }
        }

        tag.setTagsByList(userTagValues);

        tagRepository.save(tag);
        userRepository.save(user);

        // 음식점 생성
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag2 = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag2)
                .build();

        List<Double> shopTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                shopTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                shopTagValues.add((i * 0.01D));
            }
        }

        tag2.setTagsByList(shopTagValues);

        tagRepository.save(tag2);
        shopRepository.save(shop);

        // 게임 생성
        gameService.makeGame(user.getEmail());

        Game game = gameRepository.findAll().get(0);

        // 원래 값 저장
        List<Double> originValues = game.getTag().getTagsByList();

        // 왼쪽으로 스와이프
        gameService.swipeRight(game, shop);

        // 결과를 출력
        Tag tag1 = game.getTag();
        List<Double> tagValues = tag1.getTagsByList();
        System.out.println("*********************************************************");
        System.out.println("*-------------------🔥SwipeRightTest🔥-------------------*");
        System.out.println("*---------------------🚀TEST START🚀---------------------*");
        System.out.println("*********************************************************");
        for (int i=0;i<28;i++) {
            System.out.println("---------------------------------------------------------");
            System.out.println("gameValue" + i + " : " + originValues.get(i));
            System.out.println("shopValue" + i + " : " + userTagValues.get(i));
            System.out.println("gameValue" + i + " : " + tagValues.get(i));
            if ((originValues.get(i) < userTagValues.get(i) && originValues.get(i) > tagValues.get(i)) || (originValues.get(i) > userTagValues.get(i) && originValues.get(i) < tagValues.get(i))) {
                System.out.println("*********************************************************");
                System.out.println("*--------------------SwipeRightTest---------------------*");
                System.out.println("*-------------------TEST UNSUCCESSFUL-------------------*");
                System.out.println("*********************************************************");
                return ;
            }
        }
        System.out.println("*********************************************************");
        System.out.println("*------------------🥳SwipeRightTest🥳--------------------*");
        System.out.println("*------------------🎉TEST SUCCESSFUL🎉-------------------*");
        System.out.println("*********************************************************");
    }

    @Test
    public void EndGameTest() {
        // 유저 생성
        String email = "test@naver.com";
        String nickname = "테스트계정";
        String auth = "ROLE_ADMIN";

        Tag tag = new Tag();

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth(auth)
                .tag(tag)
                .build();

        List<Double> userTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                userTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                userTagValues.add((i * 0.01D));
            }
        }

        tag.setTagsByList(userTagValues);

        tagRepository.save(tag);
        userRepository.save(user);

        // 음식점 생성
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag2 = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag2)
                .build();

        List<Double> shopTagValues = new ArrayList<>();

        // 임의의 유저 테그 값 부여
        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                shopTagValues.add(0.5D + (i * 0.01D));
            }
            else {
                shopTagValues.add((i * 0.01D));
            }
        }

        tag2.setTagsByList(shopTagValues);

        tagRepository.save(tag2);
        shopRepository.save(shop);

        // 게임 생성
        gameService.makeGame(user.getEmail());

        Game game = gameRepository.findAll().get(0);

        // 게임 종료
        gameService.endGame(game, shop);
        gameRepository.save(game);

        Result result = resultRepository.findByGameAndShop(game, shop);
        resultRepository.save(result);

        // 결과를 출력
        System.out.println("*********************************************************");
        System.out.println("*--------------------🔥EndGameTest🔥---------------------*");
        System.out.println("*---------------------🚀TEST START🚀---------------------*");
        System.out.println("*********************************************************");
        Assertions.assertEquals(game.getId(), result.getGame().getId());
        Assertions.assertEquals(game.getUser().getEmail(), result.getGame().getUser().getEmail());
        Assertions.assertEquals(game.getTotalRound(), result.getGame().getTotalRound());
        Assertions.assertEquals(game.getCurRound(), result.getGame().getCurRound());
        Assertions.assertEquals(game.getStatus(), result.getGame().getStatus());
        Assertions.assertEquals(shop.getId(), result.getShop().getId());

        System.out.println("*********************************************************");
        System.out.println("*--------------------🥳EndGameTest🥳---------------------*");
        System.out.println("*------------------🎉TEST SUCCESSFUL🎉-------------------*");
        System.out.println("*********************************************************");
    }
}
