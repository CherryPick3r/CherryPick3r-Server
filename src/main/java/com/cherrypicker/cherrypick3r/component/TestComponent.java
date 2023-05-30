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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

        // testuser

        Tag tagUser = new Tag();
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
        tagUser.setTagsByList(tagValues);

        tagRepository.save(tagUser);

        User user = User.builder()
                .email("kakao_test@naver.com")
                .auth("User")
                .nickname("맛집탐방자")
                .tag(tagUser)
                .build();

        userRepository.save(user);

        // Testcase1
        phone = "02-457-8319";
        name = "서북면옥";
        address = "서울 광진구 자양로 199-1 서북면옥";
        addressPointY = 207471.153472131D;
        addressPointX = 449242.931984079D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "화\n" +
                "11:00 - 19:30\n" +
                "19:00 라스트오더/수\n" +
                "11:00 - 19:30\n" +
                "19:00 라스트오더/목\n" +
                "11:00 - 19:30\n" +
                "19:00 라스트오더/금\n" +
                "11:00 - 19:30\n" +
                "19:00 라스트오더/토\n" +
                "11:00 - 19:30\n" +
                "19:00 라스트오더/일\n" +
                "정기휴무 (매주 일요일)/월\n" +
                "11:00 - 19:30\n" +
                "19:00 라스트오더";
        onelineReview = "중소벤처기업부 인증 백년가게";
        mainPhotoUrl1 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_137%2F1441030738247q5Ht8_JPEG%2F11727906_0.jpg";
        mainPhotoUrl2 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_244%2F1441030738444nvPM1_JPEG%2F11727906_1.jpg";
        naverId = 11727906L;
        Tag tag = new Tag();
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0.113636364D);
        tagValues.add(0.113636364D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(3.295454545D);
        tagValues.add(6.477272727D);
        tagValues.add(0D);
        tagValues.add(0.568181818D);
        tagValues.add(1.363636364D);
        tagValues.add(12.5D);
        tagValues.add(11.02272727D);
        tagValues.add(5.340909091D);
        tagValues.add(6.477272727D);
        tagValues.add(18.97727273D);
        tagValues.add(1.818181818D);
        tagValues.add(14.54545455D);
        tagValues.add(2.5D);
        tagValues.add(0D);
        tagValues.add(14.88636364D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag.setTagsByList(tagValues);

        tagRepository.save(tag);

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
                .naverId(naverId)
                .kakaoId(kakaoId)
                .tag(tag)
                .build();

        shopRepository.save(shop);

        List<Menu> menus = new ArrayList<>();
        menus.add(Menu.builder()
                .name("물냉면")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("비빔냉면")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("온면")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("만둣국")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("수육(소고기)")
                .price(15000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("편육(돼지고기)")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("떡만두")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("접시만두")
                .price(10000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("냉동만두 포장 5인분")
                .price(25000L)
                .shop(shop).build());

        menuRepository.saveAll(menus);


        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_137%2F1441030738247q5Ht8_JPEG%2F11727906_0.jpg").build();
        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_244%2F1441030738444nvPM1_JPEG%2F11727906_1.jpg").build();

        shopPhotoRepository.save(shopPhoto1);
        shopPhotoRepository.save(shopPhoto2);

        // Testcase2
        phone = "02-444-9009";
        name = "가람성";
        address = "서울 광진구 광나루로24길 22";
        addressPointY = 206685.852736958D;
        addressPointX = 449228.796631785D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "매일\n" +
                "00:00 - 24:00";
        onelineReview = "맛있는 짜장면 집!";
        mainPhotoUrl1 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20160427_95%2F1461748880413puPwv_JPEG%2F176377585139428_0.jpeg";
        mainPhotoUrl2 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMjEyMjlfNTEg%2FMDAxNjcyMzA5Njk1OTAx.6WO75tYLunRH_7hL5VJPt1hQqj_ADZ9jMmcY4dLVJLcg.k5-fXopjfoMAlCvGa2o6mBZ9vNmYxVYAs5L34Io8xXYg.JPEG%2F68F00654-113B-4B7D-B4D2-3E1C3E14415D.jpeg";
        naverId = 18002798L;
        Tag tag2 = new Tag();
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
        tagValues.add(14.28571429D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(4.761904762D);
        tagValues.add(9.523809524D);
        tagValues.add(11.9047619D);
        tagValues.add(14.28571429D);
        tagValues.add(0D);
        tagValues.add(4.761904762D);
        tagValues.add(11.9047619D);
        tagValues.add(9.523809524D);
        tagValues.add(0D);
        tagValues.add(19.04761905D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag2.setTagsByList(tagValues);

        tagRepository.save(tag2);

        Shop shop2 = Shop.builder()
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
                .tag(tag2)
                .build();

        shopRepository.save(shop2);

        List<Menu> menus2 = new ArrayList<>();
        menus2.add(Menu.builder()
                .name("해물쟁반짜장")
                .price(9000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("해물볶음짬")
                .price(10000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("제육덮밥")
                .price(10000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("잡탕밥")
                .price(16000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("사천탕수육(小)")
                .price(23000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("사천탕수육(中)")
                .price(27000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("사천탕수육(大)")
                .price(32000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("깐풍새우(中)")
                .price(36000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("깐풍새우(大)")
                .price(46000L)
                .shop(shop2).build());

        menuRepository.saveAll(menus2);

        ShopPhoto shopPhoto3 = ShopPhoto.builder().shop(shop2).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20160427_95%2F1461748880413puPwv_JPEG%2F176377585139428_0.jpeg").build();
        ShopPhoto shopPhoto4 = ShopPhoto.builder().shop(shop2).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyMjEyMjlfNTEg%2FMDAxNjcyMzA5Njk1OTAx.6WO75tYLunRH_7hL5VJPt1hQqj_ADZ9jMmcY4dLVJLcg.k5-fXopjfoMAlCvGa2o6mBZ9vNmYxVYAs5L34Io8xXYg.JPEG%2F68F00654-113B-4B7D-B4D2-3E1C3E14415D.jpeg").build();

        shopPhotoRepository.save(shopPhoto3);
        shopPhotoRepository.save(shopPhoto4);

        // Testcase3
        phone = "010-9444-0969";
        name = "샤브삘";
        address = "서울 광진구 자양로18길 15 1층 샤브삘";
        addressPointY = 207380.463780592D;
        addressPointX = 448387.748170675D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "화\n" +
                "11:00 - 22:00\n" +
                "21:30 라스트오더/수\n" +
                "11:00 - 22:00\n" +
                "21:30 라스트오더/목\n" +
                "11:00 - 22:00\n" +
                "21:30 라스트오더/금\n" +
                "11:00 - 22:00\n" +
                "21:30 라스트오더/토\n" +
                "정기휴무 (매주 토요일)/일\n" +
                "11:00 - 22:00\n" +
                "21:30 라스트오더/월\n" +
                "11:00 - 22:00\n" +
                "21:30 라스트오더";
        onelineReview = "동네 주민들은 다 아는 샤브샤브 맛집";
        mainPhotoUrl1 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230217_279%2F1676608690615rBeRn_JPEG%2F20230209_201042.jpg";
        mainPhotoUrl2 = "https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230323_141%2F1679573785448siNlR_JPEG%2FCYMERA_20230323_211542.jpg";
        naverId = 1183950262L;
        Tag tag3 = new Tag();
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
        tagValues.add(0.588235294D);
        tagValues.add(8.235294118D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(13.52941176D);
        tagValues.add(18.82352941D);
        tagValues.add(7.647058824D);
        tagValues.add(8.235294118D);
        tagValues.add(2.941176471D);
        tagValues.add(1.176470588D);
        tagValues.add(12.94117647D);
        tagValues.add(5.294117647D);
        tagValues.add(0D);
        tagValues.add(20.58823529D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag3.setTagsByList(tagValues);

        tagRepository.save(tag3);

        Shop shop3 = Shop.builder()
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
                .tag(tag3)
                .build();

        shopRepository.save(shop3);

        List<Menu> menus3 = new ArrayList<>();
        menus3.add(Menu.builder()
                .name("검은콩국수")
                .price(9000L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("굴림만두샤브")
                .price(12000L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("소고기샤브")
                .price(10000L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("해물샤브")
                .price(12000L)
                .shop(shop3).build());

        menuRepository.saveAll(menus3);

        ShopPhoto shopPhoto5 = ShopPhoto.builder().shop(shop3).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230217_279%2F1676608690615rBeRn_JPEG%2F20230209_201042.jpg").build();
        ShopPhoto shopPhoto6 = ShopPhoto.builder().shop(shop3).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230323_141%2F1679573785448siNlR_JPEG%2FCYMERA_20230323_211542.jpg").build();

        shopPhotoRepository.save(shopPhoto5);
        shopPhotoRepository.save(shopPhoto6);

        //test case 8

        phone = "02-497-9610";
        name = "왕십리 정곱창";
        address = "서울 광진구 능동로19길 5";
        addressPointY = 37.546886739153166D;
        addressPointX = 127.07345242049D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "17:00 ~ 01:00 \n" +
                "화\n" +
                "17:00 ~ 01:00 \n" +
                "수\n" +
                "17:00 ~ 01:00 \n" +
                "목\n" +
                "17:00 ~ 01:00  \n" +
                "금\n" +
                "17:00 ~ 01:00  \n" +
                "토\n" +
                "17:00 ~ 01:00";
        onelineReview = "행복과 맛을 전달해드리는 왕십리정곱창입니다.";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fcfile%2F19066B414FE19A570C";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/2250/54384_1576407422612_20472";
        naverId = 13098702L;
        kakaoId = 15754295L;
        Tag tag8 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(53.4426229508197D);
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
        tagValues.add(8.85245901639344D);
        tagValues.add(4.59016393442623D);
        tagValues.add(4.59016393442623D);
        tagValues.add(0D);
        tagValues.add(9.18032786885246D);
        tagValues.add(4.59016393442623D);
        tagValues.add(0D);
        tagValues.add(0.147540983606557D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag8.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop8 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag8) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus8 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("돼지막창양념구이(1인분)")
                .price(14000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("한우소곱창구이(1인분)25000")
                .price(25000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("치즈곱창(2인분)")
                .price(28000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("치즈곱창(3인분)")
                .price(42000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("한우곱창모듬한판")
                .price(47000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("한우대창구이")
                .price(24000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("한우모듬양념구이")
                .price(49000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto15 = ShopPhoto.builder().shop(shop8).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fcfile%2F19066B414FE19A570C").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto16 = ShopPhoto.builder().shop(shop8).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2250/54384_1576407422612_20472").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto15); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto16); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



        //test case 9

        phone = "02-462-8413";
        name = "펀비어킹 광진 건대로데오점";
        address = "서울특별시 광진구 아차산로33길 7";
        addressPointY = 37.5441229D;
        addressPointX = 127.069803D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "17:00 ~ 04:00 \n" +
                "화\n" +
                "17:00 ~ 04:00 \n" +
                "수\n" +
                "17:00 ~ 04:00 \n" +
                "목\n" +
                "17:00 ~ 04:00 \n" +
                "금\n" +
                "17:00 ~ 04:00 \n" +
                "토\n" +
                "17:00 ~ 04:00";
        onelineReview = "이제는 맥주도 카페에서 즐긴다~ ^^  비어카페 No.1 술집맛집 '펀비어킹'";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F308B159F051643BEBDA180D1F7E2AEAE";
        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2FF80C972E4F66486F9B466677B2411E9E";
        naverId = 1804165655L;
        kakaoId = 1496664880L;
        Tag tag9 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(29.3706293706294D);
        tagValues.add(6.99300699300699D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(4.54545454545455D);
        tagValues.add(2.44755244755245D);
        tagValues.add(0.34965034965035D);
        tagValues.add(17.4825174825175D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(4.1958041958042D);
        tagValues.add(4.1958041958042D);
        tagValues.add(0D);
        tagValues.add(5.59440559440559D);
        tagValues.add(15.034965034965D);
        tagValues.add(0D);
        tagValues.add(0.0979020979020979D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag9.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop9 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag9) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus9 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("페퍼로니페스츄리피자)")
                .price(13900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("먹태킹")
                .price(13900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우살타워링")
                .price(14900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("치즈볼&리코타샐러드")
                .price(15900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("아이스과일펀치")
                .price(15900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("반반치킨")
                .price(18900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("통오징어한판떡볶킹")
                .price(19900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("곱도리탕")
                .price(22900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto17 = ShopPhoto.builder().shop(shop9).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F308B159F051643BEBDA180D1F7E2AEAE").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto18 = ShopPhoto.builder().shop(shop9).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2FF80C972E4F66486F9B466677B2411E9E").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto17); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto18); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        //test case 10

        phone = "010-9177-9000";
        name = "폼프리츠";
        address = "서울 광진구 능동로19길 41";
        addressPointY = 37.547202D;
        addressPointX = 127.071572D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "17:00 ~ 00:00 \n" +
                "화\n" +
                "17:00 ~ 00:00 \n" +
                "수\n" +
                "17:00 ~ 00:00 \n" +
                "목\n" +
                "17:00 ~ 00:00 \n" +
                "금\n" +
                "17:00 ~ 00:00 ";
        onelineReview = "감튀맛집 폼프리츠";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Fpostfiles14.naver.net%2FMjAyMTA2MTBfMjgg%2FMDAxNjIzMzM1NzY4OTA3.w0WMYNsCG244RmKw9_S3K5uGY2GOQ7lWDnsIXiHEP3Ug.npA8DxlHCFo_emgp5j6qDOWMCUvL9msAr0ArW78wr3Qg.JPEG.seraphhz%2FSE-6d93a04f-2be7-4736-9a36-9e7b7fb35f66.jpg%3Ftype%3Dw966";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/75017/1560043_1577505070545"
        naverId = 33510840L;
        kakaoId = 21801734L;
        Tag tag10 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(29.4416243654822D);
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
        tagValues.add(5.58375634517766D);
        tagValues.add(2.53807106598985);
        tagValues.add(10.6598984771574D);
        tagValues.add(3.55329949238579D);
        tagValues.add(26.3959390862944D);
        tagValues.add(6.09137055837563D);
        tagValues.add(0D);
        tagValues.add(0.157360406091371D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tag10.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop10 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag10) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus10 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("미니소세지")
                .price(7000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("미니핫도그")
                .price(7000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("모듬튀김")
                .price(7000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("모듬감자")
                .price(9000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("어니언링")
                .price(7000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("감자튀김 S")
                .price(4000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("감자튀김 M")
                .price(5000L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("감자튀김 L")
                .price(6500L)
                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto19 = ShopPhoto.builder().shop(shop10).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Fpostfiles14.naver.net%2FMjAyMTA2MTBfMjgg%2FMDAxNjIzMzM1NzY4OTA3.w0WMYNsCG244RmKw9_S3K5uGY2GOQ7lWDnsIXiHEP3Ug.npA8DxlHCFo_emgp5j6qDOWMCUvL9msAr0ArW78wr3Qg.JPEG.seraphhz%2FSE-6d93a04f-2be7-4736-9a36-9e7b7fb35f66.jpg%3Ftype%3Dw966").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto20 = ShopPhoto.builder().shop(shop10).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/75017/1560043_1577505070545").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto19); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto20); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
    }


}

/*
해야할 일
1. DB
2.
3.
4.
5.
 */