package com.cherrypicker.cherrypick3r.component;

import com.cherrypicker.cherrypick3r.menu.domain.Menu;
import com.cherrypicker.cherrypick3r.menu.domain.MenuRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.shopPhoto.domain.ShopPhoto;
import com.cherrypicker.cherrypick3r.shopPhoto.domain.ShopPhotoRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class TestComponent {

    private final ShopRepository shopRepository;
    private final ShopClassifyRepository shopClassifyRepository;
    private final ShopClassifyService shopClassifyService;
    private final TagRepository tagRepository;
    private final MenuRepository menuRepository;
    private final ShopPhotoRepository shopPhotoRepository;
    private final UserRepository userRepository;

    // 랜덤한 태그 값 생성
    public List<Double> makeRandomTagValueList() {
        List<Double> values = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 28; i++) {
            double value = random.nextDouble();
            values.add(value);
        }

        return values;
    }

    public void makeShopTestData() {
        // 테스트 가게 400개 생성
        for (Long i=10L;i<410L;i++) {
            String phone = "010-1234-12" + i.toString();
            String name = "깍뚝" + i.toString();
            String address = "경기도 시흥시 수인로3325번길 12-" + i.toString();
            Double addressPointY = 1.1234D;
            Double addressPointX = -1.1234D;
            Long clippingCount = 0L;
            Long pickedCount = 0L;
            String operatingHours = "하루종일";
            String onelineReview = "너무 맛있어요~";
            String mainPhotoUrl1 = "https://testlink1" + i.toString();
            String mainPhotoUrl2 = "https://testlink2" + i.toString();
            Tag tag = new Tag();
            tag.setTagsByList(makeRandomTagValueList());

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
                    .tag(tag)
                    .build();

            tagRepository.save(tag);
            shopRepository.save(shop);
        }
        shopClassifyService.makeAllShopClassifyUsingTagValues(0.5D);
    }

    public void makeShopData() {
        String phone;
        String name;
        String address;
        Double addressPointY;
        Double addressPointX;
        Long clippingCount;
        Long pickedCount;
        String operatingHours;
        String onelineReview;
        String mainPhotoUrl1;
        String mainPhotoUrl2;
        Long naverId;
        Long kakaoId = 0L;
        List<Double> tagValues = new ArrayList<>();

//        // testuser
//
//        Tag tagUser = new Tag();
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagUser.setTagsByList(tagValues);
//
//        tagRepository.save(tagUser);
//
//        User user = User.builder()
//                .email("kakao_test@naver.com")
//                .auth("User")
//                .nickname("맛집탐방자")
//                .tag(tagUser)
//                .build();
//
//        userRepository.save(user);

//        // Testcase1
//        phone = "02-457-8319";
//        name = "서북면옥";
//        address = "서울 광진구 자양로 199-1 서북면옥";
//        addressPointY = 207471.153472131D;
//        addressPointX = 449242.931984079D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "화\n" +
//                "11:00 - 19:30\n" +
//                "19:00 라스트오더/수\n" +
//                "11:00 - 19:30\n" +
//                "19:00 라스트오더/목\n" +
//                "11:00 - 19:30\n" +
//                "19:00 라스트오더/금\n" +
//                "11:00 - 19:30\n" +
//                "19:00 라스트오더/토\n" +
//                "11:00 - 19:30\n" +
//                "19:00 라스트오더/일\n" +
//                "정기휴무 (매주 일요일)/월\n" +
//                "11:00 - 19:30\n" +
//                "19:00 라스트오더";
//        onelineReview = "중소벤처기업부 인증 백년가게";
//        mainPhotoUrl1 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_137%2F1441030738247q5Ht8_JPEG%2F11727906_0.jpg";
//        mainPhotoUrl2 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_244%2F1441030738444nvPM1_JPEG%2F11727906_1.jpg";
//        naverId = 11727906L;
//        Tag tag = new Tag();
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0.113636364D);
//        tagValues.add(0.113636364D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(3.295454545D);
//        tagValues.add(6.477272727D);
//        tagValues.add(0D);
//        tagValues.add(0.568181818D);
//        tagValues.add(1.363636364D);
//        tagValues.add(12.5D);
//        tagValues.add(11.02272727D);
//        tagValues.add(5.340909091D);
//        tagValues.add(6.477272727D);
//        tagValues.add(18.97727273D);
//        tagValues.add(1.818181818D);
//        tagValues.add(14.54545455D);
//        tagValues.add(2.5D);
//        tagValues.add(0D);
//        tagValues.add(14.88636364D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag.setTagsByList(tagValues);
//
//        tagRepository.save(tag);
//
//        Shop shop = Shop.builder()
//                .phone(phone)
//                .name(name)
//                .address(address)
//                .addressPointY(addressPointY)
//                .addressPointX(addressPointX)
//                .clippingCount(clippingCount)
//                .pickedCount(pickedCount)
//                .operatingHours(operatingHours)
//                .onelineReview(onelineReview)
//                .mainPhotoUrl1(mainPhotoUrl1)
//                .mainPhotoUrl2(mainPhotoUrl2)
//                .naverId(naverId)
//                .kakaoId(kakaoId)
//                .tag(tag)
//                .build();
//
//        shopRepository.save(shop);
//
//        List<Menu> menus = new ArrayList<>();
//        menus.add(Menu.builder()
//                .name("물냉면")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("비빔냉면")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("온면")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("만둣국")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("수육(소고기)")
//                .price(15000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("편육(돼지고기)")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("떡만두")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("접시만두")
//                .price(10000L)
//                .shop(shop).build());
//        menus.add(Menu.builder()
//                .name("냉동만두 포장 5인분")
//                .price(25000L)
//                .shop(shop).build());
//
//        menuRepository.saveAll(menus);
//
//
//        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_137%2F1441030738247q5Ht8_JPEG%2F11727906_0.jpg").build();
//        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_244%2F1441030738444nvPM1_JPEG%2F11727906_1.jpg").build();
//
//        shopPhotoRepository.save(shopPhoto1);
//        shopPhotoRepository.save(shopPhoto2);
//
//        // Testcase2
//        phone = "02-444-9009";
//        name = "가람성";
//        address = "서울 광진구 광나루로24길 22";
//        addressPointY = 206685.852736958D;
//        addressPointX = 449228.796631785D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "매일\n" +
//                "00:00 - 24:00";
//        onelineReview = "맛있는 짜장면 집!";
//        mainPhotoUrl1 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20160427_95%2F1461748880413puPwv_JPEG%2F176377585139428_0.jpeg";
//        mainPhotoUrl2 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMjEyMjlfNTEg%2FMDAxNjcyMzA5Njk1OTAx.6WO75tYLunRH_7hL5VJPt1hQqj_ADZ9jMmcY4dLVJLcg.k5-fXopjfoMAlCvGa2o6mBZ9vNmYxVYAs5L34Io8xXYg.JPEG%2F68F00654-113B-4B7D-B4D2-3E1C3E14415D.jpeg";
//        naverId = 18002798L;
//        Tag tag2 = new Tag();
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(14.28571429D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(4.761904762D);
//        tagValues.add(9.523809524D);
//        tagValues.add(11.9047619D);
//        tagValues.add(14.28571429D);
//        tagValues.add(0D);
//        tagValues.add(4.761904762D);
//        tagValues.add(11.9047619D);
//        tagValues.add(9.523809524D);
//        tagValues.add(0D);
//        tagValues.add(19.04761905D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag2.setTagsByList(tagValues);
//
//        tagRepository.save(tag2);
//
//        Shop shop2 = Shop.builder()
//                .phone(phone)
//                .name(name)
//                .address(address)
//                .addressPointY(addressPointY)
//                .addressPointX(addressPointX)
//                .clippingCount(clippingCount)
//                .pickedCount(pickedCount)
//                .operatingHours(operatingHours)
//                .onelineReview(onelineReview)
//                .mainPhotoUrl1(mainPhotoUrl1)
//                .mainPhotoUrl2(mainPhotoUrl2)
//                .naverId(naverId)
//                .kakaoId(kakaoId)
//                .tag(tag2)
//                .build();
//
//        shopRepository.save(shop2);
//
//        List<Menu> menus2 = new ArrayList<>();
//        menus2.add(Menu.builder()
//                .name("해물쟁반짜장")
//                .price(9000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("해물볶음짬")
//                .price(10000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("제육덮밥")
//                .price(10000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("잡탕밥")
//                .price(16000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("사천탕수육(小)")
//                .price(23000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("사천탕수육(中)")
//                .price(27000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("사천탕수육(大)")
//                .price(32000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("깐풍새우(中)")
//                .price(36000L)
//                .shop(shop2).build());
//        menus2.add(Menu.builder()
//                .name("깐풍새우(大)")
//                .price(46000L)
//                .shop(shop2).build());
//
//        menuRepository.saveAll(menus2);
//
//        ShopPhoto shopPhoto3 = ShopPhoto.builder().shop(shop2).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20160427_95%2F1461748880413puPwv_JPEG%2F176377585139428_0.jpeg").build();
//        ShopPhoto shopPhoto4 = ShopPhoto.builder().shop(shop2).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMjEyMjlfNTEg%2FMDAxNjcyMzA5Njk1OTAx.6WO75tYLunRH_7hL5VJPt1hQqj_ADZ9jMmcY4dLVJLcg.k5-fXopjfoMAlCvGa2o6mBZ9vNmYxVYAs5L34Io8xXYg.JPEG%2F68F00654-113B-4B7D-B4D2-3E1C3E14415D.jpeg").build();
//
//        shopPhotoRepository.save(shopPhoto3);
//        shopPhotoRepository.save(shopPhoto4);
//
//        // Testcase3
//        phone = "010-9444-0969";
//        name = "샤브삘";
//        address = "서울 광진구 자양로18길 15 1층 샤브삘";
//        addressPointY = 207380.463780592D;
//        addressPointX = 448387.748170675D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "화\n" +
//                "11:00 - 22:00\n" +
//                "21:30 라스트오더/수\n" +
//                "11:00 - 22:00\n" +
//                "21:30 라스트오더/목\n" +
//                "11:00 - 22:00\n" +
//                "21:30 라스트오더/금\n" +
//                "11:00 - 22:00\n" +
//                "21:30 라스트오더/토\n" +
//                "정기휴무 (매주 토요일)/일\n" +
//                "11:00 - 22:00\n" +
//                "21:30 라스트오더/월\n" +
//                "11:00 - 22:00\n" +
//                "21:30 라스트오더";
//        onelineReview = "동네 주민들은 다 아는 샤브샤브 맛집";
//        mainPhotoUrl1 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230217_279%2F1676608690615rBeRn_JPEG%2F20230209_201042.jpg";
//        mainPhotoUrl2 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230323_141%2F1679573785448siNlR_JPEG%2FCYMERA_20230323_211542.jpg";
//        naverId = 1183950262L;
//        Tag tag3 = new Tag();
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0.588235294D);
//        tagValues.add(8.235294118D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(13.52941176D);
//        tagValues.add(18.82352941D);
//        tagValues.add(7.647058824D);
//        tagValues.add(8.235294118D);
//        tagValues.add(2.941176471D);
//        tagValues.add(1.176470588D);
//        tagValues.add(12.94117647D);
//        tagValues.add(5.294117647D);
//        tagValues.add(0D);
//        tagValues.add(20.58823529D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag3.setTagsByList(tagValues);
//
//        tagRepository.save(tag3);
//
//        Shop shop3 = Shop.builder()
//                .phone(phone)
//                .name(name)
//                .address(address)
//                .addressPointY(addressPointY)
//                .addressPointX(addressPointX)
//                .clippingCount(clippingCount)
//                .pickedCount(pickedCount)
//                .operatingHours(operatingHours)
//                .onelineReview(onelineReview)
//                .mainPhotoUrl1(mainPhotoUrl1)
//                .mainPhotoUrl2(mainPhotoUrl2)
//                .naverId(naverId)
//                .kakaoId(kakaoId)
//                .tag(tag3)
//                .build();
//
//        shopRepository.save(shop3);
//
//        List<Menu> menus3 = new ArrayList<>();
//        menus3.add(Menu.builder()
//                .name("검은콩국수")
//                .price(9000L)
//                .shop(shop3).build());
//        menus3.add(Menu.builder()
//                .name("굴림만두샤브")
//                .price(12000L)
//                .shop(shop3).build());
//        menus3.add(Menu.builder()
//                .name("소고기샤브")
//                .price(10000L)
//                .shop(shop3).build());
//        menus3.add(Menu.builder()
//                .name("해물샤브")
//                .price(12000L)
//                .shop(shop3).build());
//
//        menuRepository.saveAll(menus3);
//
//        ShopPhoto shopPhoto5 = ShopPhoto.builder().shop(shop3).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230217_279%2F1676608690615rBeRn_JPEG%2F20230209_201042.jpg").build();
//        ShopPhoto shopPhoto6 = ShopPhoto.builder().shop(shop3).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230323_141%2F1679573785448siNlR_JPEG%2FCYMERA_20230323_211542.jpg").build();
//
//        shopPhotoRepository.save(shopPhoto5);
//        shopPhotoRepository.save(shopPhoto6);

        // Testcase4
        phone = "02-462-7826";
        name = "송화양꼬치";
        address = "서울 광진구 동일로18길 70";
        addressPointY = 37.5389D;
        addressPointX = 127.0666D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "11:00 - 24:00\n" +
                "화\n" +
                "정기휴무 (매주 화요일)\n" +
                "수\n" +
                "11:00 - 24:00\n" +
                "목\n" +
                "11:00 - 24:00\n" +
                "금\n" +
                "11:00 - 24:00\n" +
                "토\n" +
                "11:00 - 24:00\n" +
                "일\n" +
                "11:00 - 24:00";
        onelineReview = "칠리새우와 맛있는 오리지널양꼬치";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/2025425_1670417642516181.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/73743/2627_1634469629406_6731";
        naverId = 12966607L;
        kakaoId = 14822911L;
        Tag tag4 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(46.1273666092943D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(1.63511187607573D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(6.19621342512909D);
        tagValues.add(5.85197934595525D);
        tagValues.add(9.03614457831325D);
        tagValues.add(0D);
        tagValues.add(5.76592082616179D);
        tagValues.add(15.4044750430293D);
        tagValues.add(0D);
        tagValues.add(0.0998278829604131D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag4.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop4 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .naverId(naverId)
                .kakaoId(kakaoId)
                .tag(tag4) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus4 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("오리지널 양꼬치")
                .price(18000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("고급양갈비")
                .price(35000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("송화양꼬치(10꼬치)")
                .price(16000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("양갈비살")
                .price(25000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("소꼬치")
                .price(22000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("꿔보로우")
                .price(18000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("가지튀김")
                .price(15000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("닭똥집")
                .price(13000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우")
                .price(13000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("돼지심장")
                .price(13000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("소떡심")
                .price(13000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("닭날개")
                .price(13000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("어향육슬")
                .price(15000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("향라육슬")
                .price(15000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("경장육슬")
                .price(15000L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto7 = ShopPhoto.builder().shop(shop4).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2025425_1670417642516181.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto8 = ShopPhoto.builder().shop(shop4).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/73743/2627_1634469629406_6731").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        // Testcase5
        phone = "02-455-4769";
        name = "역전할머니맥주서울구의점";
        address = "서울 광진구 아차산로51길 36";
        addressPointY = 37.538652D;
        addressPointX = 127.085122D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "16:00 ~ 03:00 \n" +
                "화\n" +
                "16:00 ~ 03:00 \n" +
                "수\n" +
                "16:00 ~ 03:00\n" +
                "목\n" +
                "16:00 ~ 03:00 \n" +
                "금\n" +
                "16:00 ~ 03:00 \n" +
                "토\n" +
                "16:00 ~ 03:00 \n" +
                "일\n" +
                "16:00~ 03:00";
        onelineReview = "역전할머니맥주 구의점에서 먹는 시원한 얼음맥주";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/2091186_1671943165220234.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/2038726_1641895779640502.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80";
        naverId = 1208854457L;
        kakaoId = 884648433L;
        Tag tag5 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(15.0390625D);
        tagValues.add(2.5390625D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(1.5625D);
        tagValues.add(2.5390625D);
        tagValues.add(0.1953125D);
        tagValues.add(0D);
        tagValues.add(25.9765625D);
        tagValues.add(0.1953125D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(3.3203125D);
        tagValues.add(6.8359375D);
        tagValues.add(0.78125D);
        tagValues.add(23.046875D);
        tagValues.add(9.1796875D);
        tagValues.add(0D);
        tagValues.add(0.087890625D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag5.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop5 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .naverId(naverId)
                .kakaoId(kakaoId)
                .tag(tag5) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus5 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("오징어입")
                .price(7000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("먹태")
                .price(14000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("갈릭빠다 포테이토")
                .price(7000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("옛날통닭(한마리)12000")
                .price(12000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("옛날통닭(반마리)12000")
                .price(6000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("버터구이오징어입")
                .price(8000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("할멘보샤")
                .price(10000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("한치")
                .price(9000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("양념먹태")
                .price(14000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto9 = ShopPhoto.builder().shop(shop5).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2091186_1671943165220234.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto10 = ShopPhoto.builder().shop(shop5).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2038726_1641895779640502.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



        // Testcase6
        phone = "02-465-0366";
        name = "손수제 치킨";
        address = "서울 광진구 군자로 129";
        addressPointY = 37.5537566100399D;
        addressPointX = 127.0738D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "16:00 ~ 02:00 \n" +
                "화\n" +
                "16:00 ~ 02:00 \n" +
                "수\n" +
                "16:00 ~ 02:00\n" +
                "목\n" +
                "16:00 ~ 02:00 \n" +
                "금\n" +
                "16:00 ~ 02:00 \n" +
                "일\n" +
                "16:00~ 02:00";
        onelineReview = "저렴한 치킨 맛집";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/281409/723564_1487075162062_8252";
        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fae3f32964076cfc27c2c9c947a7d3dc2c6c7cdf5%3Foriginal";
        naverId = 126318008L;
        kakaoId = 27245102L;
        Tag tag6 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag6.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop6 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .naverId(naverId)
                .kakaoId(kakaoId)
                .tag(tag6) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus6 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("후라이드(뼈치킨)한마리")
                .price(9900L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("후라이드(뼈치킨)반마리")
                .price(6000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간장 뼈치킨 한마리")
                .price(11500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간장 순살 한마리")
                .price(13000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간장 뼈치킨 반마리")
                .price(6500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간장 순살 반마리")
                .price(7500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("마늘간장 뼈치킨 한마리")
                .price(12000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("마늘간장 순살 한마리")
                .price(14000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("마늘간장 뼈치킨 반마리")
                .price(7000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("마늘간장 순살 치킨 반마리")
                .price(8000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("파닭 뼈치킨 한마리")
                .price(13000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("파닭 뼈치킨 반마리")
                .price(7500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("후라이드(반) + 양념 or 간장(반)")
                .price(11000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("후라이드(반) + 양념 or 간장(순살)")
                .price(12500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("후라이드(반) + 마늘간장")
                .price(11500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("후라이드(반) + 마늘간장(순살)")
                .price(13500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간장(반) + 양념(반)12000")
                .price(12000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간장(반) + 양념(반)12000(순살)")
                .price(14000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("순한양념(반) + 매운양념(반)")
                .price(12000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("순한양념(반) + 매운양념(반) (순살)")
                .price(14000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("양념 or 간장(반) + 마늘간장")
                .price(12500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("양념 or 간장(반) + 마늘간장(순살)")
                .price(14500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("닭다리 8개")
                .price(13000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("닭다리 4개")
                .price(7000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("감자튀김 추가")
                .price(4000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto11 = ShopPhoto.builder().shop(shop6).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/281409/723564_1487075162062_8252").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto12 = ShopPhoto.builder().shop(shop6).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fae3f32964076cfc27c2c9c947a7d3dc2c6c7cdf5%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto11); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto12); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]




        // Testcase7
        phone = "0507-1441-0280";
        name = "깍뚝";
        address = "서울 광진구 능동로19길 36 1층 (우)05009";
        addressPointY = 37.547D;
        addressPointX = 127.0722D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "16:00 ~ 00:00 \n" +
                "화\n" +
                "16:00 ~ 00:00 \n" +
                "수\n" +
                "16:00 ~ 00:00 \n" +
                "목\n" +
                "16:00 ~ 00:00 \n" +
                "금\n" +
                "16:00 ~ 00:00 \n" +
                "토\n" +
                "16:00 ~ 00:00 \n" +
                "일\n" +
                "16:00 ~ 00:00 \n" +
                "연중무휴";
        onelineReview = "건대, 세종대 맛집 삼겹살이 맛있는 곳";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F49d4a13827d0c27d8caae9b1d648642c8a11b5dc%3Foriginal";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/280411/1440124_1629614990766_8565?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80";
        naverId = 35357402L;
        kakaoId = 24944745L;
        Tag tag7 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(33.1578947D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(4D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(8.88888889D);
        tagValues.add(4D);
        tagValues.add(1.77777778D);
        tagValues.add(0D);
        tagValues.add(17.7777778D);
        tagValues.add(12.8888889D);
        tagValues.add(0D);
        tagValues.add(0.12111111D);
        tag7.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop7 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .naverId(naverId)
                .kakaoId(kakaoId)
                .tag(tag7) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus7 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("숙성 삼겹살 한판 600g")
                .price(25900L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("숙성 목살 한판 600g")
                .price(25900L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("숙성 삼겹살 반판 300g")
                .price(15900L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("숙성 목살 반판 300g")
                .price(15900L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("돼지갈비 250~300g")
                .price(11900L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("소갈비살")
                .price(13900L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto13 = ShopPhoto.builder().shop(shop7).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F49d4a13827d0c27d8caae9b1d648642c8a11b5dc%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto14 = ShopPhoto.builder().shop(shop7).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/280411/1440124_1629614990766_8565?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto13); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto14); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

    }
//
//    // 정제된 데이터 csv로 넣기
//    public void putDataIntoDatabaseByCSV() throws IOException, CsvException {
//
//        // csv 오픈
//        // utf-8 형태로 csv 파일 파싱
//        ClassPathResource resourceShop = new ClassPathResource("shop.csv");
//        CSVReader shopCsvReader = new CSVReader(new FileReader(resourceShop.getFile()));
//
//        shopCsvReader.readNext(); // 컬럼명은 저장되지 않도록 한 줄 읽기
//
//        String[] st
//
//        do {    //파일에서 데이터를 읽어 파싱하고 Park 객체로 만들어 ArrayList 에 넣는다.
//            shopCsvReader = shopCsvReader.readNext();    //한 라인 읽기 (자동으로 콤마 분리해서 배열에 저장 됌)
//
//            if (parkInfo != null) {
//                if (parkInfo[28] == null || parkInfo[29] == null || parkInfo[28].isEmpty() || parkInfo[29].isEmpty())  //읽어온 데이터의 위도, 경도 값이 없거나 null 이면 저장하지 않고 넘김
//                    continue;
//                else if (checkDuplicate(parkInfo[0], parkList))  //주차장 코드가 중복(checkDuplicate 값이 true)이면 저장하지 않고 넘김
//                    continue;
//                else {  //위의 두 조건에 해당사항이 없으면 데이터를 객체에 저장 후 임시 저장 ArrayList에 삽입
//                    Park park = new Park();   //Park 객체 생성하기
//
//                    park.setPrkplceNo(parkInfo[0]);      //객체에 값 저장하기
//                    park.setPrkplceNm(parkInfo[1]);
//                    park.setPrkplceSe(parkInfo[2]);
//                    park.setPrkplceType(parkInfo[3]);
//                    park.setRdnmadr(parkInfo[4]);
//                    park.setLnmadr(parkInfo[5]);
//                    park.setPrkcmprt(parkInfo[6]);
//                    park.setFeedingSe(parkInfo[7]);
//                    park.setEnforceSe(parkInfo[8]);
//                    park.setOperDay(parkInfo[9]);
//                    park.setWeekdayOperOpenHhmm(parkInfo[10]);
//                    park.setWeekdayOperCloseHhmm(parkInfo[11]);
//                    park.setSatOperOperOpenHhmm(parkInfo[12]);
//                    park.setSatOperCloseHhmm(parkInfo[13]);
//                    park.setHolidayOperOpenHhmm(parkInfo[14]);
//                    park.setHolidayCloseOpenHhmm(parkInfo[15]);
//                    park.setParkingchrgeInfo(parkInfo[16]);
//                    park.setBasicTime(parkInfo[17]);
//                    park.setBasicCharge(parkInfo[18]);
//                    park.setAddUnitTime(parkInfo[19]);
//                    park.setAddUnitCharge(parkInfo[20]);
//                    park.setDayCmmtktAdjTime(parkInfo[21]);
//                    park.setDayCmmtkt(parkInfo[22]);
//                    park.setMonthCmmtkt(parkInfo[23]);
//                    park.setMetpay(parkInfo[24]);
//                    park.setSpcmnt(parkInfo[25]);
//                    park.setInstitutionNm(parkInfo[26]);
//                    park.setPhoneNumber(parkInfo[27].replace("-", ""));
//                    park.setLatitude(parkInfo[28]);
//                    park.setLongitude(parkInfo[29]);
//                    park.setReferenceDate(parkInfo[30]);
//                    park.setInsttCode(parkInfo[31]);
//                    park.setInsttNm(parkInfo[32]);
//
//                    parkList.add(park);   //리스트에 Park 객체 저장하기
//                    em.persist(park);   //park 객체를 DB에 INSERT
//                }
//            }
//        } while (parkInfo != null);
//
//        csvReader.close();
//
//    }

}
