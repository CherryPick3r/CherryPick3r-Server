package com.cherrypicker.cherrypick3r.component;

import com.cherrypicker.cherrypick3r.menu.domain.Menu;
import com.cherrypicker.cherrypick3r.menu.domain.MenuRepository;
import com.cherrypicker.cherrypick3r.preferenceShop.domain.PreferenceShop;
import com.cherrypicker.cherrypick3r.preferenceShop.domain.PreferenceShopRepository;
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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
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
    private final PreferenceShopRepository preferenceShopRepository;

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

    public Tag makeTag(Double tagV1, Double tagV2, Double tagV3, Double tagV4, Double tagV5, Double tagV6, Double tagV7, Double tagV8, Double tagV9, Double tagV10, Double tagV11, Double tagV12, Double tagV13, Double tagV14, Double tagV15, Double tagV16, Double tagV17, Double tagV18, Double tagV19, Double tagV20, Double tagV21, Double tagV22, Double tagV23, Double tagV24, Double tagV25, Double tagV26, Double tagV27, Double tagV28) {
        List<Double> tagValues = new ArrayList<>();
        tagValues.add(tagV1);
        tagValues.add(tagV2);
        tagValues.add(tagV3);
        tagValues.add(tagV4);
        tagValues.add(tagV5);
        tagValues.add(tagV6);
        tagValues.add(tagV7);
        tagValues.add(tagV8);
        tagValues.add(tagV9);
        tagValues.add(tagV10);
        tagValues.add(tagV11);
        tagValues.add(tagV12);
        tagValues.add(tagV13);
        tagValues.add(tagV14);
        tagValues.add(tagV15);
        tagValues.add(tagV16);
        tagValues.add(tagV17);
        tagValues.add(tagV18);
        tagValues.add(tagV19);
        tagValues.add(tagV20);
        tagValues.add(tagV21);
        tagValues.add(tagV22);
        tagValues.add(tagV23);
        tagValues.add(tagV24);
        tagValues.add(tagV25);
        tagValues.add(tagV26);
        tagValues.add(tagV27);
        tagValues.add(tagV28);
        Tag tag = new Tag();
        tag.setTagsByList(tagValues);
        tagRepository.save(tag);
        return tag;
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

//        // 유저 초기 취향 게임 데이터 생성
//        PreferenceShop preferenceShop1 = new PreferenceShop(makeTag(44.2145D,33.5D,15.1D,0D,55.13513D,1.1D,1.1D,1.1D,1.1D,0D,0D,0D,1.1D,0D,0D,0D,0D,1.1D,15.155D,1.1D,20.134134D,0D,0D,10.55D,0D,0D,0D,0D));
//        PreferenceShop preferenceShop2 = new PreferenceShop(makeTag(0D,8.9D,0D,0D,0D,11.4D,41.33D,15.9D,0D,0D,0D,0D,0D,0D,0D,0D,0D,0D,0D,20.1D,0D,0D,0D,20.11D,30.613D,0D,34.0145D,45.4D));
//        PreferenceShop preferenceShop3 = new PreferenceShop(makeTag(0D,0D,30.3D,0D,0D,15.15D,0D,0D,0D,0D,0D,0D,45.22D,0D,8.9D,55.1D,20.5D,0D,0D,0D,0D,0D,0D,0D,0D,0D,0D,0D));
//        PreferenceShop preferenceShop4 = new PreferenceShop(makeTag(0D,0D,0D,54.2D,0D,0D,0D,15.9D,0D,0D,20.1D,0D,0D,0D,0D,0D,23.14D,40.4D,0D,9D,52.55D,0D,0D,0D,0D,0D,0D,0D));
//        PreferenceShop preferenceShop5 = new PreferenceShop(makeTag(0D,0D,0D,0D,0D,0D,49.1D,51.6D,0D,0D,0D,0D,0D,0D,0D,0D,0D,0D,0D,8.9D,20.92D,0D,48.22D,11.1D,31.99D,0D,0D,0D));
//
//        preferenceShopRepository.save(preferenceShop1);
//        preferenceShopRepository.save(preferenceShop2);
//        preferenceShopRepository.save(preferenceShop3);
//        preferenceShopRepository.save(preferenceShop4);
//        preferenceShopRepository.save(preferenceShop5);

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
//        mainPhotoUrl1 = "https://m.blog.naver.com/semins77/221675555000?view=img_13";
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
//        tagValues.add(29.5D);
//        tagValues.add(21.02272727D);
//        tagValues.add(5.340909091D);
//        tagValues.add(6.477272727D);
//        tagValues.add(64.97727273D);
//        tagValues.add(1.818181818D);
//        tagValues.add(30.54545455D);
//        tagValues.add(2.5D);
//        tagValues.add(0D);
//        tagValues.add(20.88636364D);
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
//        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop).photoUrl("https://m.blog.naver.com/semins77/221675555000?view=img_13").build();
//        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop).photoUrl("https://search.pstatic.net/common/?autoRotate=true&type=w560_sharpen&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_244%2F1441030738444nvPM1_JPEG%2F11727906_1.jpg").build();
//
//        shopPhotoRepository.save(shopPhoto1);
//        shopPhotoRepository.save(shopPhoto2);

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
//        tagValues.add(30.28571429D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(4.761904762D);
//        tagValues.add(9.523809524D);
//        tagValues.add(24.9047619D);
//        tagValues.add(6.28571429D);
//        tagValues.add(0D);
//        tagValues.add(4.761904762D);
//        tagValues.add(10.9047619D);
//        tagValues.add(9.523809524D);
//        tagValues.add(0D);
//        tagValues.add(35.04761905D);
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
//        tagValues.add(16.235294118D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(55.52941176D);
//        tagValues.add(10.82352941D);
//        tagValues.add(7.647058824D);
//        tagValues.add(8.235294118D);
//        tagValues.add(2.941176471D);
//        tagValues.add(1.176470588D);
//        tagValues.add(41.94117647D);
//        tagValues.add(5.294117647D);
//        tagValues.add(0D);
//        tagValues.add(35.58823529D);
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
//
//        // Testcase4
//        phone = "02-462-7826";
//        name = "송화양꼬치";
//        address = "서울 광진구 동일로18길 70";
//        addressPointY = 37.5389D;
//        addressPointX = 127.0666D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "11:00 - 24:00\n" +
//                "화\n" +
//                "정기휴무 (매주 화요일)\n" +
//                "수\n" +
//                "11:00 - 24:00\n" +
//                "목\n" +
//                "11:00 - 24:00\n" +
//                "금\n" +
//                "11:00 - 24:00\n" +
//                "토\n" +
//                "11:00 - 24:00\n" +
//                "일\n" +
//                "11:00 - 24:00";
//        onelineReview = "칠리새우와 맛있는 오리지널양꼬치";
//        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/2025425_1670417643920342.jpg";
//        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/73743/2627_1634469629406_6731";
//        naverId = 12966607L;
//        kakaoId = 14822911L;
//        Tag tag4 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(46.1273666092943D);
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
//        tagValues.add(1.63511187607573D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(30.621342512909D);
//        tagValues.add(19.85197934595525D);
//        tagValues.add(8.03614457831325D);
//        tagValues.add(0D);
//        tagValues.add(5.76592082616179D);
//        tagValues.add(33.4044750430293D);
//        tagValues.add(0D);
//        tagValues.add(0.0998278829604131D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag4.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop4 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag4) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus4 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("오리지널 양꼬치")
//                .price(18000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("고급양갈비")
//                .price(35000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("송화양꼬치(10꼬치)")
//                .price(16000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("양갈비살")
//                .price(25000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("소꼬치")
//                .price(22000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("꿔보로우")
//                .price(18000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("가지튀김")
//                .price(15000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("닭똥집")
//                .price(13000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("새우")
//                .price(13000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("돼지심장")
//                .price(13000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("소떡심")
//                .price(13000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("닭날개")
//                .price(13000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("어향육슬")
//                .price(15000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("향라육슬")
//                .price(15000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("경장육슬")
//                .price(15000L)
//                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto7 = ShopPhoto.builder().shop(shop4).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2025425_1670417642516181.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto8 = ShopPhoto.builder().shop(shop4).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/73743/2627_1634469629406_6731").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//
//        // Testcase5
//        phone = "02-455-4769";
//        name = "역전할머니맥주서울구의점";
//        address = "서울 광진구 아차산로51길 36";
//        addressPointY = 37.538652D;
//        addressPointX = 127.085122D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "16:00 ~ 03:00 \n" +
//                "화\n" +
//                "16:00 ~ 03:00 \n" +
//                "수\n" +
//                "16:00 ~ 03:00\n" +
//                "목\n" +
//                "16:00 ~ 03:00 \n" +
//                "금\n" +
//                "16:00 ~ 03:00 \n" +
//                "토\n" +
//                "16:00 ~ 03:00 \n" +
//                "일\n" +
//                "16:00~ 03:00";
//        onelineReview = "역전할머니맥주 구의점에서 먹는 시원한 얼음맥주";
//        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/2091186_1671943165220234.jpg";
//        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/2038726_1641895779640502.jpg";
//        naverId = 1208854457L;
//        kakaoId = 884648433L;
//        Tag tag5 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(33.0390625D);
//        tagValues.add(2.5390625D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(1.5625D);
//        tagValues.add(2.5390625D);
//        tagValues.add(0.1953125D);
//        tagValues.add(0D);
//        tagValues.add(20.9765625D);
//        tagValues.add(0.1953125D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(3.3203125D);
//        tagValues.add(30.8359375D);
//        tagValues.add(0.78125D);
//        tagValues.add(55.046875D);
//        tagValues.add(15.1796875D);
//        tagValues.add(0D);
//        tagValues.add(0.087890625D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag5.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop5 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag5) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus5 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("오징어입")
//                .price(7000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("먹태")
//                .price(14000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("갈릭빠다 포테이토")
//                .price(7000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("옛날통닭(한마리)12000")
//                .price(12000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("옛날통닭(반마리)12000")
//                .price(6000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("버터구이오징어입")
//                .price(8000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("할멘보샤")
//                .price(10000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("한치")
//                .price(9000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("양념먹태")
//                .price(14000L)
//                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto9 = ShopPhoto.builder().shop(shop5).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2091186_1671943165220234.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto10 = ShopPhoto.builder().shop(shop5).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2038726_1641895779640502.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//
//
//        // Testcase6
//        phone = "02-465-0366";
//        name = "손수제 치킨";
//        address = "서울 광진구 군자로 129";
//        addressPointY = 37.5537566100399D;
//        addressPointX = 127.0738D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "16:00 ~ 02:00 \n" +
//                "화\n" +
//                "16:00 ~ 02:00 \n" +
//                "수\n" +
//                "16:00 ~ 02:00\n" +
//                "목\n" +
//                "16:00 ~ 02:00 \n" +
//                "금\n" +
//                "16:00 ~ 02:00 \n" +
//                "일\n" +
//                "16:00~ 02:00";
//        onelineReview = "저렴한 치킨 맛집";
//        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/281409/723564_1487075162062_8252";
//        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fae3f32964076cfc27c2c9c947a7d3dc2c6c7cdf5%3Foriginal";
//        naverId = 126318008L;
//        kakaoId = 27245102L;
//        Tag tag6 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(33.1578947D);
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
//        tagValues.add(3.15789474D);
//        tagValues.add(31.5263158D);
//        tagValues.add(23.89473684D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(55.7368421D);
//        tagValues.add(22.73684211D);
//        tagValues.add(0D);
//        tagValues.add(0.15789474D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag6.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop6 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag6) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus6 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("후라이드(뼈치킨)한마리")
//                .price(9900L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("후라이드(뼈치킨)반마리")
//                .price(6000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("간장 뼈치킨 한마리")
//                .price(11500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("간장 순살 한마리")
//                .price(13000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("간장 뼈치킨 반마리")
//                .price(6500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("간장 순살 반마리")
//                .price(7500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("마늘간장 뼈치킨 한마리")
//                .price(12000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("마늘간장 순살 한마리")
//                .price(14000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("마늘간장 뼈치킨 반마리")
//                .price(7000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("마늘간장 순살 치킨 반마리")
//                .price(8000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("파닭 뼈치킨 한마리")
//                .price(13000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("파닭 뼈치킨 반마리")
//                .price(7500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("후라이드(반) + 양념 or 간장(반)")
//                .price(11000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("후라이드(반) + 양념 or 간장(순살)")
//                .price(12500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("후라이드(반) + 마늘간장")
//                .price(11500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("후라이드(반) + 마늘간장(순살)")
//                .price(13500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("간장(반) + 양념(반)12000")
//                .price(12000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("간장(반) + 양념(반)12000(순살)")
//                .price(14000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("순한양념(반) + 매운양념(반)")
//                .price(12000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("순한양념(반) + 매운양념(반) (순살)")
//                .price(14000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("양념 or 간장(반) + 마늘간장")
//                .price(12500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("양념 or 간장(반) + 마늘간장(순살)")
//                .price(14500L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("닭다리 8개")
//                .price(13000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("닭다리 4개")
//                .price(7000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("감자튀김 추가")
//                .price(4000L)
//                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//
//        menuRepository.saveAll(menus6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto11 = ShopPhoto.builder().shop(shop6).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/281409/723564_1487075162062_8252").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto12 = ShopPhoto.builder().shop(shop6).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fae3f32964076cfc27c2c9c947a7d3dc2c6c7cdf5%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto11); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto12); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//
//
//
//        // Testcase7
//        phone = "0507-1441-0280";
//        name = "깍뚝";
//        address = "서울 광진구 능동로19길 36 1층 (우)05009";
//        addressPointY = 37.547D;
//        addressPointX = 127.0722D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "16:00 ~ 00:00 \n" +
//                "화\n" +
//                "16:00 ~ 00:00 \n" +
//                "수\n" +
//                "16:00 ~ 00:00 \n" +
//                "목\n" +
//                "16:00 ~ 00:00 \n" +
//                "금\n" +
//                "16:00 ~ 00:00 \n" +
//                "토\n" +
//                "16:00 ~ 00:00 \n" +
//                "일\n" +
//                "16:00 ~ 00:00 \n" +
//                "연중무휴";
//        onelineReview = "건대, 세종대 맛집 삼겹살이 맛있는 곳";
//        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F49d4a13827d0c27d8caae9b1d648642c8a11b5dc%3Foriginal";
//        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/280411/1440124_1629614990766_8565";
//        naverId = 35357402L;
//        kakaoId = 24944745L;
//        Tag tag7 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(48.5555555555556D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(1D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(16.88888889D);
//        tagValues.add(18.1D);
//        tagValues.add(1.77777778D);
//        tagValues.add(0D);
//        tagValues.add(37.7777778D);
//        tagValues.add(6.8888889D);
//        tagValues.add(0D);
//        tagValues.add(0.12111111D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag7.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop7 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag7) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus7 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("숙성 삼겹살 한판 600g")
//                .price(25900L)
//                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("숙성 목살 한판 600g")
//                .price(25900L)
//                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("숙성 삼겹살 반판 300g")
//                .price(15900L)
//                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("숙성 목살 반판 300g")
//                .price(15900L)
//                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("돼지갈비 250~300g")
//                .price(11900L)
//                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("소갈비살")
//                .price(13900L)
//                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto13 = ShopPhoto.builder().shop(shop7).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F49d4a13827d0c27d8caae9b1d648642c8a11b5dc%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto14 = ShopPhoto.builder().shop(shop7).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/280411/1440124_1629614990766_8565").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto13); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto14); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        //testCase8
//
//        phone = "02-497-9610";
//        name = "왕십리 정곱창";
//        address = "서울 광진구 능동로19길 5";
//        addressPointY = 37.546886739153166D;
//        addressPointX = 127.07345242049D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "17:00 ~ 01:00 \n" +
//                "화\n" +
//                "17:00 ~ 01:00 \n" +
//                "수\n" +
//                "17:00 ~ 01:00 \n" +
//                "목\n" +
//                "17:00 ~ 01:00  \n" +
//                "금\n" +
//                "17:00 ~ 01:00  \n" +
//                "토\n" +
//                "17:00 ~ 01:00";
//        onelineReview = "행복과 맛을 전달해드리는 왕십리 정곱창입니다.";
//        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fcfile%2F19066B414FE19A570C";
//        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/2250/54384_1576407422612_20472";
//        naverId = 13098702L;
//        kakaoId = 15754295L;
//        Tag tag8 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(53.4426229508197D);
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
//        tagValues.add(8.85245901639344D);
//        tagValues.add(31.59016393442623D);
//        tagValues.add(35.59016393442623D);
//        tagValues.add(0D);
//        tagValues.add(19.18032786885246D);
//        tagValues.add(4.59016393442623D);
//        tagValues.add(0D);
//        tagValues.add(0.147540983606557D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag8.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop8 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag8) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus8 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("돼지막창양념구이(1인분)")
//                .price(14000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("한우소곱창구이(1인분)25000")
//                .price(25000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("치즈곱창(2인분)")
//                .price(28000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("치즈곱창(3인분)")
//                .price(42000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("한우곱창모듬한판")
//                .price(47000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("한우대창구이")
//                .price(24000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("한우모듬양념구이")
//                .price(49000L)
//                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto15 = ShopPhoto.builder().shop(shop8).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fcfile%2F19066B414FE19A570C").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto16 = ShopPhoto.builder().shop(shop8).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/2250/54384_1576407422612_20472").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto15); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto16); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//
//
//        //testCase9
//
//        phone = "02-462-8413";
//        name = "펀비어킹 광진 건대로데오점";
//        address = "서울특별시 광진구 아차산로33길 7";
//        addressPointY = 37.5441229D;
//        addressPointX = 127.069803D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "17:00 ~ 04:00 \n" +
//                "화\n" +
//                "17:00 ~ 04:00 \n" +
//                "수\n" +
//                "17:00 ~ 04:00 \n" +
//                "목\n" +
//                "17:00 ~ 04:00 \n" +
//                "금\n" +
//                "17:00 ~ 04:00 \n" +
//                "토\n" +
//                "17:00 ~ 04:00";
//        onelineReview = "이제는 맥주도 카페에서 즐긴다~ ^^  비어카페 No.1 술집맛집 '펀비어킹'";
//        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F308B159F051643BEBDA180D1F7E2AEAE";
//        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2FF80C972E4F66486F9B466677B2411E9E";
//        naverId = 1804165655L;
//        kakaoId = 1496664880L;
//        Tag tag9 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(29.3706293706294D);
//        tagValues.add(18.99300699300699D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(4.54545454545455D);
//        tagValues.add(2.44755244755245D);
//        tagValues.add(0.34965034965035D);
//        tagValues.add(54.4825174825175D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(4.1958041958042D);
//        tagValues.add(4.1958041958042D);
//        tagValues.add(0D);
//        tagValues.add(31.59440559440559D);
//        tagValues.add(21.034965034965D);
//        tagValues.add(0D);
//        tagValues.add(0.0979020979020979D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag9.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop9 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag9) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus9 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("페퍼로니페스츄리피자)")
//                .price(13900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("먹태킹")
//                .price(13900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("새우살타워링")
//                .price(14900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("치즈볼&리코타샐러드")
//                .price(15900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("아이스과일펀치")
//                .price(15900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("반반치킨")
//                .price(18900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("통오징어한판떡볶킹")
//                .price(19900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("곱도리탕")
//                .price(22900L)
//                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto17 = ShopPhoto.builder().shop(shop9).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F308B159F051643BEBDA180D1F7E2AEAE").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto18 = ShopPhoto.builder().shop(shop9).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2FF80C972E4F66486F9B466677B2411E9E").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto17); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto18); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        //testCase10
//
//        phone = "010-9177-9000";
//        name = "폼프리츠";
//        address = "서울 광진구 능동로19길 41";
//        addressPointY = 37.547202D;
//        addressPointX = 127.071572D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "월\n" +
//                "17:00 ~ 00:00 \n" +
//                "화\n" +
//                "17:00 ~ 00:00 \n" +
//                "수\n" +
//                "17:00 ~ 00:00 \n" +
//                "목\n" +
//                "17:00 ~ 00:00 \n" +
//                "금\n" +
//                "17:00 ~ 00:00 ";
//        onelineReview = "감튀맛집 폼프리츠";
//        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Fpostfiles14.naver.net%2FMjAyMTA2MTBfMjgg%2FMDAxNjIzMzM1NzY4OTA3.w0WMYNsCG244RmKw9_S3K5uGY2GOQ7lWDnsIXiHEP3Ug.npA8DxlHCFo_emgp5j6qDOWMCUvL9msAr0ArW78wr3Qg.JPEG.seraphhz%2FSE-6d93a04f-2be7-4736-9a36-9e7b7fb35f66.jpg%3Ftype%3Dw966";
//        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/75017/1560043_1577505070545";
//        naverId = 33510840L;
//        kakaoId = 21801734L;
//        Tag tag10 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(45.4416243654822D);
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
//        tagValues.add(43.58375634517766D);
//        tagValues.add(2.53807106598985);
//        tagValues.add(65.6598984771574D);
//        tagValues.add(3.55329949238579D);
//        tagValues.add(36.3959390862944D);
//        tagValues.add(30.09137055837563D);
//        tagValues.add(0D);
//        tagValues.add(0.157360406091371D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tagValues.add(0D);
//        tag10.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop10 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag10) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus10 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("미니소세지")
//                .price(7000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("미니핫도그")
//                .price(7000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("모듬튀김")
//                .price(7000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("모듬감자")
//                .price(9000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("어니언링")
//                .price(7000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("감자튀김 S")
//                .price(4000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("감자튀김 M")
//                .price(5000L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus10.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("감자튀김 L")
//                .price(6500L)
//                .shop(shop10).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto19 = ShopPhoto.builder().shop(shop10).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Fpostfiles14.naver.net%2FMjAyMTA2MTBfMjgg%2FMDAxNjIzMzM1NzY4OTA3.w0WMYNsCG244RmKw9_S3K5uGY2GOQ7lWDnsIXiHEP3Ug.npA8DxlHCFo_emgp5j6qDOWMCUvL9msAr0ArW78wr3Qg.JPEG.seraphhz%2FSE-6d93a04f-2be7-4736-9a36-9e7b7fb35f66.jpg%3Ftype%3Dw966").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto20 = ShopPhoto.builder().shop(shop10).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/75017/1560043_1577505070545").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto19); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto20); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        // Testcase1
        phone = "0507-1411-9394";
        name = "숙성회136 군자점";
        address = "서울 광진구 군자로 179-2 103호";
        addressPointY = 37.55677676909688D;
        addressPointX = 127.07801743469776D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours =
                "월\n" +
                "11:30 - 24:00\n" +
                "화\n" +
                "11:30 - 24:00\n" +
                "수\n" +
                "11:30 - 24:00\n" +
                "목\n" +
                "11:30 - 24:00\n" +
                "금\n" +
                "11:30 - 24:00\n" +
                "토\n" +
                "11:30 - 24:00\n" +
                "일\n" +
                "정기휴무 (매주 일요일)\n";
        onelineReview = "사케동(연어덮밥), 카이센동(모듬해물덮밥),마구로동(참치덮밥) 맛집.";
        mainPhotoUrl1 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MDZfMjIy/MDAxNjgzMzUzNjk0MTI1.89PdyjAJ7kCsefkzhnwxlUpSViQYgz7uDR2CwNR86hEg.Ro5pfCSaCOclTBZ2BO580U4eS6c9JQTKptNPnh9_q_8g.JPEG/IMG_8745.jpeg";
        mainPhotoUrl2 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MDZfMTg1/MDAxNjgzMzUzNTMwMzgz.ZCCY0xlD6e_sOEaVFiWCRsbW1CFmyWb0V-mmNyBLyl0g.oM7R7t5Yh2pXko3PZ-rzNhjV-8U5vOgdPmelX-xlLhAg.JPEG/IMG_8734.jpeg";
        naverId = 1848450733L;
        kakaoId = 974546283L;
        Tag tag = new Tag();
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(10.9D); // 컨셉이 독특해요
        tagValues.add(41.3D); // 맛있는 식당
        tagValues.add(21.933D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(13.452D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(33.2056D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(50.1222D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(22.9D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("사케동")
                .price(14500L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("모듬숙성회 9종")
                .price(34500L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("모듬숙성회 6종")
                .price(28500L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("간사이 오뎅 나베")
                .price(20000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("카이센나베")
                .price(19000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("모츠나베")
                .price(23000L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("마구로동")
                .price(14500L)
                .shop(shop).build());
        menus.add(Menu.builder()
                .name("카이센동")
                .price(18500L)
                .shop(shop).build());

        menuRepository.saveAll(menus);

        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MDZfMjIy/MDAxNjgzMzUzNjk0MTI1.89PdyjAJ7kCsefkzhnwxlUpSViQYgz7uDR2CwNR86hEg.Ro5pfCSaCOclTBZ2BO580U4eS6c9JQTKptNPnh9_q_8g.JPEG/IMG_8745.jpeg").build();
        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MDZfMTg1/MDAxNjgzMzUzNTMwMzgz.ZCCY0xlD6e_sOEaVFiWCRsbW1CFmyWb0V-mmNyBLyl0g.oM7R7t5Yh2pXko3PZ-rzNhjV-8U5vOgdPmelX-xlLhAg.JPEG/IMG_8734.jpeg").build();

        shopPhotoRepository.save(shopPhoto1);
        shopPhotoRepository.save(shopPhoto2);

        // Testcase2
        phone = "0507-1375-8407";
        name = "동래정 구의역점";
        address = "서울 광진구 아차산로51길 49 1층";
        addressPointY = 37.539162090966606D;
        addressPointX = 127.0847795146986D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "16:00 - 24:00\n" +
                "화\n" +
                "16:00 - 24:00\n" +
                "수\n" +
                "16:00 - 24:00\n" +
                "목\n" +
                "16:00 - 24:00\n" +
                "금\n" +
                "16:00 - 24:00\n" +
                "토\n" +
                "16:00 - 24:00\n" +
                "일\n" +
                "16:00 - 24:00\n";
        onelineReview = "소중한 사람들과 함께 하기 좋은 공간에서 최고의 1+암퇘지 직화구이를 즐겨보세요~";
        mainPhotoUrl1 = "https://ldb-phinf.pstatic.net/20230417_133/1681700403019qYypS_JPEG/47AF456D-AB36-400A-B270-965D8CE500A9.jpeg";
        mainPhotoUrl2 = "https://pup-review-phinf.pstatic.net/MjAyMzA2MDlfMjQ1/MDAxNjg2Mjc1MTQ3ODk3.NGRN58jjslDRd9i-Dh6XOQszgnV43E3IB_06dXCi-G4g.6hLwY0WNa6uYZLA-moD_aEcSRIKSSx6M0pSvvqXXjiQg.JPEG/SNOW_20230608_210139_767.jpg";
        naverId = 1781760595L;
        kakaoId = 331951612L;
        Tag tag2 = new Tag();
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(9.92D); // 컨셉이 독특해요
        tagValues.add(44.31D); // 맛있는 식당
        tagValues.add(14.235D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(5.452D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(8.1236D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(48.1256D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(23.2056D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(32.1842D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(5.9D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("정가브리")
                .price(17000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("동래목살")
                .price(16000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("1+통삼겹")
                .price(16000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("미갈매기")
                .price(16000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("제주산방 물 밀면")
                .price(7000L)
                .shop(shop2).build());
        menus2.add(Menu.builder()
                .name("제주산방 비빔 밀면")
                .price(7000L)
                .shop(shop2).build());

        menuRepository.saveAll(menus2);

        ShopPhoto shopPhoto3 = ShopPhoto.builder().shop(shop2).photoUrl("https://ldb-phinf.pstatic.net/20230417_133/1681700403019qYypS_JPEG/47AF456D-AB36-400A-B270-965D8CE500A9.jpeg").build();
        ShopPhoto shopPhoto4 = ShopPhoto.builder().shop(shop2).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA2MDlfMjQ1/MDAxNjg2Mjc1MTQ3ODk3.NGRN58jjslDRd9i-Dh6XOQszgnV43E3IB_06dXCi-G4g.6hLwY0WNa6uYZLA-moD_aEcSRIKSSx6M0pSvvqXXjiQg.JPEG/SNOW_20230608_210139_767.jpg").build();

        shopPhotoRepository.save(shopPhoto3);
        shopPhotoRepository.save(shopPhoto4);


        // Testcase3
        phone = "0507-1486-1008";
        name = "호파스타 건대 본점";
        address = "서울 광진구 군자로3길 23";
        addressPointY = 37.544230749012726D;
        addressPointX = 127.07023617343913D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "11:00 - 21:00\n" +
                "화\n" +
                "11:00 - 21:00\n" +
                "수\n" +
                "11:00 - 21:00\n" +
                "목\n" +
                "11:00 - 21:00\n" +
                "금\n" +
                "11:00 - 21:00\n" +
                "토\n" +
                "11:00 - 21:00\n" +
                "일\n" +
                "11:00 - 21:00\n";
        onelineReview = "직접 만든 생면. 스톡, 소스, 수제 청 음료를 편안하고 합리적인 가격으로 제공해 드립니다.";
        mainPhotoUrl1 = "https://ldb-phinf.pstatic.net/20211120_283/1637335852979BXzjw_JPEG/1637335846319.jpg";
        mainPhotoUrl2 = "http://blogfiles.naver.net/MjAyMzA0MjRfMTcw/MDAxNjgyMzE3NDc4NDE1.lB4oZeh0YQnmbmmsX_06Y73ifT_0gcPS_xYfK-qwCCQg.0UhuZMgXIanX6frhrBK9Tur1D9rPmL4XAu6bsqnrNjAg.JPEG.starry_722/P20230415_185028439_CCB98B5F-9C36-434F-941E-13E6208B9282.JPG";
        naverId = 1134743279L;
        kakaoId = 1137599191L;
        Tag tag3 = new Tag();
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("트러플 비프 풍미가 좋은 화이트 라구")
                .price(11900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("비프 풍미가 좋은 라구 볼로네제")
                .price(10900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("비프 생크림 로제")
                .price(9900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("쉬림프 바질페스토")
                .price(9900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("트러플 베이컨 크림 리조또")
                .price(10900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("바질페스토를 곁들인 부라타치즈 청포도 카프레제(레귤러)")
                .price(9900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("클래식 생면 라자냐")
                .price(14900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("치킨과 버터풍미 크림")
                .price(9900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("쉬림프 토마토 푸타네스카")
                .price(8900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("쉬림프 엔쵸비 루꼴라 오일")
                .price(8900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("트러플 바질 크림 리조또")
                .price(10900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("감바스 알 아히요")
                .price(10900L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("크림치즈 토마토 브루스게타")
                .price(1800L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("바질페스토 모짜렐라 브루스케타")
                .price(1800L)
                .shop(shop3).build());
        menus3.add(Menu.builder()
                .name("홈메이드 샐러드")
                .price(3500L)
                .shop(shop3).build());


        menuRepository.saveAll(menus3);

        ShopPhoto shopPhoto5 = ShopPhoto.builder().shop(shop3).photoUrl("https://ldb-phinf.pstatic.net/20211120_283/1637335852979BXzjw_JPEG/1637335846319.jpg").build();
        ShopPhoto shopPhoto6 = ShopPhoto.builder().shop(shop3).photoUrl("http://blogfiles.naver.net/MjAyMzA0MjRfMTcw/MDAxNjgyMzE3NDc4NDE1.lB4oZeh0YQnmbmmsX_06Y73ifT_0gcPS_xYfK-qwCCQg.0UhuZMgXIanX6frhrBK9Tur1D9rPmL4XAu6bsqnrNjAg.JPEG.starry_722/P20230415_185028439_CCB98B5F-9C36-434F-941E-13E6208B9282.JPG").build();

        shopPhotoRepository.save(shopPhoto5);
        shopPhotoRepository.save(shopPhoto6);


        // Testcase4
        phone = "0507-1378-3025";
        name = "대포집";
        address = "서울 광진구 자양로18길 53 1층 대포집";
        addressPointY = 37.53816754182459D;
        addressPointX = 127.08643033788209D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "16:00 - 02:00\n" +
                "화\n" +
                "16:00 - 02:00\n" +
                "수\n" +
                "16:00 - 02:00\n" +
                "목\n" +
                "16:00 - 02:00\n" +
                "금\n" +
                "16:00 - 02:00\n" +
                "토\n" +
                "16:00 - 02:00\n" +
                "일\n" +
                "16:00 - 02:00\n";
        onelineReview = "포항 참문어와 매일 삶는 맛있는 보쌈과의 조화.. 한번 맛보면 잊을 수 없는 맛집.";
        mainPhotoUrl1 = "https://pup-review-phinf.pstatic.net/MjAyMzA2MDlfMjUx/MDAxNjg2MjY1NTcwMjEz.4fZeme2bNYaiKREhRBuMvmDceUJfsGG_JdLh4LQh2DEg.TMCkmc3dZ3HRrOuVgEkV5tBmeh6fNFxjs9BVswe3kjEg.JPEG/E512B149-A829-477F-AB0C-8543636D6489.jpeg";
        mainPhotoUrl2 = "http://blogfiles.naver.net/MjAyMzAyMTZfMTY1/MDAxNjc2NTA4NDQxNTE5.LU4bqK-bnc9_3bu4GfuYoG_mLLB7lXkUxR6elxrY4N0g.4wVEbkXLUMYOhIRXA3HGOOKBUHJuePZy0HGV6Z1YYUEg.JPEG.hss05188/IMG_0704.JPG";
        naverId = 1090162638L;
        kakaoId = 27133941L;
        Tag tag4 = new Tag();
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(44.1962D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(12.9643D); // 아늑한 분위기
        tagValues.add(22.9738D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(45.1266D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(12.5346D); // 특별한 날
        tagValues.add(22.6465D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(32.9826D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
        tag4.setTagsByList(tagValues);

        tagRepository.save(tag4);

        Shop shop4 = Shop.builder()
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
                .tag(tag4)
                .build();

        shopRepository.save(shop4);

        List<Menu> menus4 = new ArrayList<>();
        menus4.add(Menu.builder()
                .name("꼬막")
                .price(22000L)
                .shop(shop4).build());
        menus4.add(Menu.builder()
                .name("해물파전")
                .price(16000L)
                .shop(shop4).build());
        menus4.add(Menu.builder()
                .name("문어숙회 (소-2인)")
                .price(30000L)
                .shop(shop4).build());
        menus4.add(Menu.builder()
                .name("문어보쌈 (소-2인)")
                .price(32000L)
                .shop(shop4).build());

        menuRepository.saveAll(menus3);

        ShopPhoto shopPhoto7 = ShopPhoto.builder().shop(shop4).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA2MDlfMjUx/MDAxNjg2MjY1NTcwMjEz.4fZeme2bNYaiKREhRBuMvmDceUJfsGG_JdLh4LQh2DEg.TMCkmc3dZ3HRrOuVgEkV5tBmeh6fNFxjs9BVswe3kjEg.JPEG/E512B149-A829-477F-AB0C-8543636D6489.jpeg").build();
        ShopPhoto shopPhoto8 = ShopPhoto.builder().shop(shop4).photoUrl("http://blogfiles.naver.net/MjAyMzAyMTZfMTY1/MDAxNjc2NTA4NDQxNTE5.LU4bqK-bnc9_3bu4GfuYoG_mLLB7lXkUxR6elxrY4N0g.4wVEbkXLUMYOhIRXA3HGOOKBUHJuePZy0HGV6Z1YYUEg.JPEG.hss05188/IMG_0704.JPG").build();

        shopPhotoRepository.save(shopPhoto7);
        shopPhotoRepository.save(shopPhoto8);


        // Testcase5
        phone = "0507-1347-3910";
        name = "한양대육회집 구의점";
        address = "서울 광진구 아차산로 395 112호";
        addressPointY = 37.53816309890665D;
        addressPointX = 127.08634547235566D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "17:00 - 02:00\n" +
                "화\n" +
                "17:00 - 02:00\n" +
                "수\n" +
                "17:00 - 02:00\n" +
                "목\n" +
                "17:00 - 02:00\n" +
                "금\n" +
                "17:00 - 02:00\n" +
                "토\n" +
                "17:00 - 02:00\n" +
                "일\n" +
                "정기휴무 (매주 일요일)\n";
        onelineReview = "서민갑부 426회 출연 최재환 갑부의 한우만 사용하고 있습니다!!";
        mainPhotoUrl1 = "https://pup-review-phinf.pstatic.net/MjAyMzA2MDhfMTY2/MDAxNjg2MjMyODE5ODc3.AbBp9azcWkC3DqMR5eZhyedn0daJqFhS5HSpzTiYMnAg.7-X4SAdxwaP-vu8TAhlkhYSMQXBGvvZS7xdruh6hHBQg.JPEG/20230608_212504.jpg";
        mainPhotoUrl2 = "https://ldb-phinf.pstatic.net/20230424_208/1682333795475CsxOC_JPEG/GJF01324.jpg";
        naverId = 1925688058L;
        kakaoId = 1203991180L;
        Tag tag5 = new Tag();
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
        tag5.setTagsByList(tagValues);

        tagRepository.save(tag5);

        Shop shop5 = Shop.builder()
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
                .tag(tag5)
                .build();

        shopRepository.save(shop5);

        List<Menu> menus5 = new ArrayList<>();
        menus5.add(Menu.builder()
                .name("한우 뭉티기 (200g)")
                .price(41900L)
                .shop(shop5).build());
        menus5.add(Menu.builder()
                .name("한우 뭉티기 (400g)")
                .price(79900L)
                .shop(shop5).build());
        menus5.add(Menu.builder()
                .name("한우 육회 (고기만 150g)")
                .price(24900L)
                .shop(shop5).build());
        menus5.add(Menu.builder()
                .name("한우 육회 (고기만 300g)")
                .price(46900L)
                .shop(shop5).build());

        menuRepository.saveAll(menus5);

        ShopPhoto shopPhoto9 = ShopPhoto.builder().shop(shop5).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA2MDhfMTY2/MDAxNjg2MjMyODE5ODc3.AbBp9azcWkC3DqMR5eZhyedn0daJqFhS5HSpzTiYMnAg.7-X4SAdxwaP-vu8TAhlkhYSMQXBGvvZS7xdruh6hHBQg.JPEG/20230608_212504.jpg").build();
        ShopPhoto shopPhoto10 = ShopPhoto.builder().shop(shop5).photoUrl("https://ldb-phinf.pstatic.net/20230424_208/1682333795475CsxOC_JPEG/GJF01324.jpg").build();

        shopPhotoRepository.save(shopPhoto9);
        shopPhotoRepository.save(shopPhoto10);


//        // Testcase6
//        phone = "";
//        name = "";
//        address = "";
//        addressPointY = D;
//        addressPointX = D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "";
//        onelineReview = "";
//        mainPhotoUrl1 = "";
//        mainPhotoUrl2 = "";
//        naverId = L;
//        kakaoId = L;
//        Tag tag6 = new Tag();
//        tagValues.clear();
//        tagValues.add(0D); // 이색맛집
//        tagValues.add(0D); // 컨셉이 독특해요
//        tagValues.add(0D); // 맛있는 식당
//        tagValues.add(0D); // 좋은 술집
//        tagValues.add(0D); // 코스요리 맛집
//        tagValues.add(0D); // 차분한 분위기
//        tagValues.add(0D); // 아늑한 분위기
//        tagValues.add(0D); // 오래 있기 좋아요
//        tagValues.add(0D); // 좋은 음악
//        tagValues.add(0D); // 주차하기 편해요
//        tagValues.add(0D); // 단체모임
//        tagValues.add(0D); // 입소문
//        tagValues.add(0D); // 음식이 빨리 나와요
//        tagValues.add(0D); // 특별한 날
//        tagValues.add(0D); // 신선해요
//        tagValues.add(0D); // 혼밥
//        tagValues.add(0D); // 푸짐해요
//        tagValues.add(0D); // 친구랑 가기 좋아요
//        tagValues.add(0D); // 특별메뉴
//        tagValues.add(0D); // 감성사진
//        tagValues.add(0D); // 가성비 맛집
//        tagValues.add(0D); // 쾌적한 공간
//        tagValues.add(0D); // 카공맛집
//        tagValues.add(0D); // 친절해요
//        tagValues.add(0D); // 카페
//        tagValues.add(0D); // 커피맛집
//        tagValues.add(0D); // 맛있는 디저트
//        tagValues.add(0D); // 맛있는 음료
//        tag6.setTagsByList(tagValues);
//
//        tagRepository.save(tag6);
//
//        Shop shop6 = Shop.builder()
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
//                .tag(tag6)
//                .build();
//
//        shopRepository.save(shop4);
//
//        List<Menu> menus6 = new ArrayList<>();
//        menus6.add(Menu.builder()
//                .name("")
//                .price(L)
//                .shop(shop6).build());
//
//        menuRepository.saveAll(menus3);
//
//        ShopPhoto shopPhoto11 = ShopPhoto.builder().shop(shop6).photoUrl("").build();
//        ShopPhoto shopPhoto12 = ShopPhoto.builder().shop(shop6).photoUrl("").build();
//
//        shopPhotoRepository.save(shopPhoto11);
//        shopPhotoRepository.save(shopPhoto12);

        // 태그 클래시파이 다시만들기
        shopClassifyRepository.deleteAll();
        shopClassifyService.makeAllShopClassifyUsingTagValues(15D);
    }


    @Transactional
    public void putDataebang(){
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

        //TestCase1
        phone = "0507-1410-1200";
        name = "파쏘";
        address = "서울특별시 광진구 군자로 174 1층";
        addressPointY = 37.5560D;
        addressPointX = 127.0778D;
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
                "17:00 ~ 00:00 \n" +
                "토\n"+
                "17:00 ~ 00:00 ";
        onelineReview = "파스타와 소주가 있는 착한 음주양식당";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/406525/875169_1677146431558_1000003557";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/406525/2215949_1648701267430_13615";
        naverId = 1220408309L;
        kakaoId = 1679819498L;
        Tag tag1 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
        tag1.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop1 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag1) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus1 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("까르보나라")
                .price(12000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우 로제 파스타")
                .price(13000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우한치따야린")
                .price(15000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("흑돼지 라구 딸리아뗄레")
                .price(16000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("감자뇨끼")
                .price(16000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우 엔초비 오일 그라탕")
                .price(18000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("생합찜")
                .price(18000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("트리빠")
                .price(20000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("가지구이")
                .price(18000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("포르게타")
                .price(24000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop1).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/406525/875169_1677146431558_1000003557").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop1).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/406525/2215949_1648701267430_13615").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        //TestCase2
        phone = "0507-1404-0365";
        name = "방이샤브샤브 세종대점";
        address = "서울 광진구 군자로 106 1층";
        addressPointY = 37.5525D;
        addressPointX = 127.0718D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "11:00 - 21:00\n" +
                "화\n" +
                "11:00 - 21:00\n" +
                "수\n" +
                "11:00 - 21:00\n" +
                "목\n" +
                "11:00 - 21:00\n" +
                "금\n" +
                "11:00 - 21:00\n" +
                "토\n" +
                "정기휴무 (매주 토요일)\n" +
                "일\n" +
                "정기휴무 (매주 일요일)\"";
        onelineReview = "세종대학교 입소문 샤브샤브 맛집";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/1067951_1679016923607944.jpg";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/463989_1676612715653933.jpg";
        naverId = 1743947640L;
        kakaoId = 976002163L;
        Tag tag2 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(43.1231D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(31.11D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(0D);
        tagValues.add(16.87D);
        tagValues.add(15.8D);
        tagValues.add(25.718D);
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
        tag2.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop2 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag2) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus2 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("샤브세트")
                .price(12000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto3 = ShopPhoto.builder().shop(shop2).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/1067951_1679016923607944.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto4 = ShopPhoto.builder().shop(shop2).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/463989_1676612715653933.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



        //TestCase3
        phone = "0507-1493-80880";
        name = "천미향";
        address = "서울특별시 광진구 군자동 능동로 237";
        addressPointY = 37.551274D;
        addressPointX = 127.0761D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "정기휴무 (매주 월요일)\n" +
                "화\n" +
                "11:00 - 22:00\n" +
                "수\n" +
                "11:00 - 22:00\n" +
                "목\n" +
                "11:00 - 22:00\n" +
                "금\n" +
                "11:00 - 22:00\n" +
                "토\n" +
                "11:00 - 22:00\n" +
                "일\n" +
                "11:00 - 22:00\n";
        onelineReview = "농림축산식품부 제공안심식당";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/261386_1655293223867021.jpg";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/395857/1240998_1646146879313";
        naverId = 12035278L;
        kakaoId = 833758468L;
        Tag tag3 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(21.91D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(21.38D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(41.56D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(33.85D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(15.8D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
        tag3.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop3 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag3) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus3 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("홍합짬뽕")
                .price(9000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("빙하 군만두")
                .price(10000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("미니탕수육")
                .price(15000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("짜장면")
                .price(6000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("간짜장")
                .price(7000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto5 = ShopPhoto.builder().shop(shop3).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/261386_1655293223867021.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto6 = ShopPhoto.builder().shop(shop3).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/395857/1240998_1646146879313").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //TestCase4
        phone = "010-6281-5547";
        name = "오늘와인한잔 건대점";
        address = "서울 광진구 동일로24길 102 1층 (우)05017";
        addressPointY = 37.5422D;
        addressPointX = 127.0705D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "\"월 17:00 - 03:00\n" +
                "화 17:00 - 03:00\n" +
                "수 17:00 - 03:00\n" +
                "목 17:00 - 03:00\n" +
                "금 17:00 - 03:00\n" +
                "토 16:00 - 03:00\n" +
                "일 16:00 - 03:00\"";
        onelineReview = "#데이트코스 #분위기좋은 #소개팅 #수제맥주";
        mainPhotoUrl1 = "https://mp-seoul-image-production-s3.mangoplate.com/1148533_1570873613125900.jpg";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/357114/1240998_1546539684486";
        naverId = 1438059030L;
        kakaoId = 1460831838L;
        Tag tag4 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(25.312D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(43.91D); // 아늑한 분위기
        tagValues.add(15.8D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(29.9D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(9.9D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("와인 한 잔")
                .price(2900L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("하몽 크룽지")
                .price(12900L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("명란구이 크래커")
                .price(6900L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("명란 크림 파스타")
                .price(12900L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("과일 & 치즈 플래터")
                .price(29900L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto7 = ShopPhoto.builder().shop(shop4).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/1148533_1570873613125900.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto8 = ShopPhoto.builder().shop(shop4).photoUrl("https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/357114/1240998_1546539684486").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]




        //TestCase5
        phone = "0507-1425-0704";
        name = "LAB41";
        address = "서울 광진구 능동로 300 2층";
        addressPointY = 37.5564D;
        addressPointX = 127.0794D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "정기휴무 (매주 월요일)\n" +
                "화\n" +
                "11:00 - 24:00\n" +
                "수\n" +
                "11:00 - 24:00\n" +
                "목\n" +
                "11:00 - 24:00\n" +
                "금\n" +
                "11:00 - 24:00\n" +
                "토\n" +
                "11:00 - 24:00\n" +
                "일\n" +
                "11:00 - 21:30\n";
        onelineReview = "";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420";
        mainPhotoUrl2 = "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/357114/1240998_1546539684486";
        naverId = 552724285L;
        kakaoId = 1431399667L;
        Tag tag5 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(15.9D); // 컨셉이 독특해요
        tagValues.add(25.91D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(13.8D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(38.9D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(28.11D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("고르곤졸라크림뇨끼")
                .price(20000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("화이트라구파스타")
                .price(20000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("명란알리오올리오")
                .price(16000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우루꼴라오일파스타")
                .price(18000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("아마트리치아나")
                .price(16000L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto9 = ShopPhoto.builder().shop(shop5).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto10 = ShopPhoto.builder().shop(shop5).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //TestCase6
        phone = "02-455-5207";
        name = "도른계";
        address = "서울 광진구 능동로36길 8 1층 도른계";
        addressPointY = 37.5561D;
        addressPointX = 127.0795D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "14:30 - 01:00\n" +
                "화\n" +
                "14:30 - 01:00\n" +
                "수\n" +
                "14:30 - 01:00\n" +
                "목\n" +
                "14:30 - 01:00\n" +
                "금\n" +
                "14:30 - 01:00\n" +
                "토\n" +
                "12:00 - 01:00\n" +
                "일\n" +
                "12:00 - 01:00\n";
        onelineReview = "치킨,닭강정";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.kakaocdn.net%2Fmystore%2FF0B475301A2F485392E077087D8BB663";
        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F47d445e267704b061dda931028109241525ce05b%3Foriginal";
        naverId = 1848549520L;
        kakaoId = 2035524806L;
        Tag tag6 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(28.11D); // 컨셉이 독특해요
        tagValues.add(32.81D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(11.3D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(8.9D); // 입소문
        tagValues.add(23.1D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(11.3D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("한국계")
                .price(26000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("미국계")
                .price(28000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("태국계")
                .price(28000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("일본계")
                .price(28000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("옛날통닭")
                .price(18000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto11 = ShopPhoto.builder().shop(shop6).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.kakaocdn.net%2Fmystore%2FF0B475301A2F485392E077087D8BB663").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto12 = ShopPhoto.builder().shop(shop6).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F47d445e267704b061dda931028109241525ce05b%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto11); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto12); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



        //TestCase7
        phone = "02-462-9256";
        name = "빠오즈푸 본점";
        address = "서울 광진구 광나루로 373";
        addressPointY = 37.5481D;
        addressPointX = 127.0715D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "11:30 - 21:20\n" +
                "화\n" +
                "11:30 - 21:20\n" +
                "수\n" +
                "11:30 - 21:20\n" +
                "목\n" +
                "11:30 - 21:20\n" +
                "금\n" +
                "11:30 - 21:20\n" +
                "토\n" +
                "11:30 - 21:20\n" +
                "일\n" +
                "11:30 - 21:20\n";
        onelineReview = "어린이대공원맛집 육즙이 가득찬 중국식만두";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.kakaocdn.net%2Fmystore%2FFDB18DA5E35E41E08B735781530EBAB3";
        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F317aebc2d4b38f3483c4153c9a7fcca3af0d16c6%3Foriginal";
        naverId = 20757891L;
        kakaoId = 15101449L;
        Tag tag7 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(43.14D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(18.99D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(33.1D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(23.8D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(9.3D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("고기빠오즈")
                .price(8000L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("삼선빠오즈")
                .price(9500L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("부추빠오즈")
                .price(8000L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("부추지짐")
                .price(8000L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus7.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("새우지짐")
                .price(9000L)
                .shop(shop7).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto13 = ShopPhoto.builder().shop(shop7).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.kakaocdn.net%2Fmystore%2FFDB18DA5E35E41E08B735781530EBAB3").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto14 = ShopPhoto.builder().shop(shop7).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2F317aebc2d4b38f3483c4153c9a7fcca3af0d16c6%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto13); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto14); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



        //TestCase8
        phone = "02-461-3739";
        name = "호야초밥참치 본점";
        address = "서울 광진구 능동로13길 39 1층";
        addressPointY = 37.5434D;
        addressPointX = 127.0702D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "정기휴무 (매주 월요일)\n" +
                "화\n" +
                "11:30 - 22:10\n" +
                "수\n" +
                "11:30 - 22:10\n" +
                "목\n" +
                "11:30 - 22:10\n" +
                "금\n" +
                "11:30 - 22:10\n" +
                "토\n" +
                "11:30 - 22:00\n" +
                "일\n" +
                "11:30 - 22:00\"";
        onelineReview = "건대 초밥맛집 지라시스시 생각나서 찾아간 호야초밥";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=https%3A%2F%2Fpostfiles.pstatic.net%2FMjAyMzA1MjlfODcg%2FMDAxNjg1MzU4OTIzMzYy.l_NP6jur7bfEyjpsWSIiUQ5oSu8WBGM4t7XJqPxnVHsg.UHz0Od-q0wEYBu2Vp2StJfjCbHguZJMedylM5fbhrAIg.JPEG.pure_yeong0%2FSE-EEDD93F9-4507-4562-B4D3-E52903B29BF0.jpg%3Ftype%3Dw966";
        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=https%3A%2F%2Fpostfiles.pstatic.net%2FMjAyMzA1MjVfMTIy%2FMDAxNjg0OTk3OTI4NzMz.jLVMVRzXd_F1jNet-5VGXiKWURO6u3fcKaLpWPW-onEg.h7q62VCtQbfhBvdAnJTUJr3OMAAZ7NRlzlhl7MTuGSgg.JPEG.dada9655%2FIMG_9900.jpg%3Ftype%3Dw773";
        naverId = 32089668L;
        kakaoId = 11989881L;
        Tag tag8 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(35.9D); // 컨셉이 독특해요
        tagValues.add(40.9D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(11.9D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(21.8D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(8.8D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("A호야")
                .price(15000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("B호야")
                .price(19000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("C연어")
                .price(25000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("런치초밥")
                .price(12000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus8.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("회덮밥")
                .price(9000L)
                .shop(shop8).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto15 = ShopPhoto.builder().shop(shop8).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=https%3A%2F%2Fpostfiles.pstatic.net%2FMjAyMzA1MjlfODcg%2FMDAxNjg1MzU4OTIzMzYy.l_NP6jur7bfEyjpsWSIiUQ5oSu8WBGM4t7XJqPxnVHsg.UHz0Od-q0wEYBu2Vp2StJfjCbHguZJMedylM5fbhrAIg.JPEG.pure_yeong0%2FSE-EEDD93F9-4507-4562-B4D3-E52903B29BF0.jpg%3Ftype%3Dw966").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto16 = ShopPhoto.builder().shop(shop8).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=https%3A%2F%2Fpostfiles.pstatic.net%2FMjAyMzA1MjVfMTIy%2FMDAxNjg0OTk3OTI4NzMz.jLVMVRzXd_F1jNet-5VGXiKWURO6u3fcKaLpWPW-onEg.h7q62VCtQbfhBvdAnJTUJr3OMAAZ7NRlzlhl7MTuGSgg.JPEG.dada9655%2FIMG_9900.jpg%3Ftype%3Dw773").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto15); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto16); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //TestCase9
        phone = "0507-1317-0558";
        name = "뉴웨이브서울";
        address = "서울 광진구 아차산로33길 28-10";
        addressPointY = 37.5417D;
        addressPointX = 127.0708D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "정기휴무 (매주 월요일)\n" +
                "화\n" +
                "12:00 - 22:00\n" +
                "수\n" +
                "12:00 - 22:00\n" +
                "목\n" +
                "12:00 - 22:00\n" +
                "금\n" +
                "12:00 - 24:00\n" +
                "토\n" +
                "12:00 - 24:00\n" +
                "일\n" +
                "12:00 - 22:00\n";
        onelineReview = "";
        mainPhotoUrl1 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fc5dba11324799e969c093caeabc4c1205756f42d%3Foriginal";
        mainPhotoUrl2 = "https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fd3acbe4340a29f1f5b4ad08e6b9938e017dc17ad%3Foriginal";
        naverId = 1774311378L;
        kakaoId = 1602523591L;
        Tag tag9 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(15.9D); // 컨셉이 독특해요
        tagValues.add(43.3D); // 맛있는 식당
        tagValues.add(9.9D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(29.8D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(22.9D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
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
                .name("하우스와인")
                .price(6900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("클래식 라자냐")
                .price(18900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("블루치즈크림 튀긴뇨끼")
                .price(16900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("대명 방앗간 들기름파스타")
                .price(15900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus9.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("스테이크")
                .price(39900L)
                .shop(shop9).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        menuRepository.saveAll(menus9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto17 = ShopPhoto.builder().shop(shop9).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fc5dba11324799e969c093caeabc4c1205756f42d%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto18 = ShopPhoto.builder().shop(shop9).photoUrl("https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fd3acbe4340a29f1f5b4ad08e6b9938e017dc17ad%3Foriginal").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto17); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto18); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



    }

    @Transactional
    public void putDataBySeongmik() {
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

//        //testCase
//        phone = "";
//        name = "";
//        address = "";
//        addressPointY = D;
//        addressPointX = D;
//        clippingCount = 0L;
//        pickedCount = 0L;
//        operatingHours = "";
//        onelineReview = "";
//        mainPhotoUrl1 = "";
//        mainPhotoUrl2 = "";
//        naverId = L;
//        kakaoId = L;
//        Tag tag1 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        tagValues.clear();
//        tagValues.add(0D); // 이색맛집
//        tagValues.add(0D); // 컨셉이 독특해요
//        tagValues.add(0D); // 맛있는 식당
//        tagValues.add(0D); // 좋은 술집
//        tagValues.add(0D); // 코스요리 맛집
//        tagValues.add(0D); // 차분한 분위기
//        tagValues.add(0D); // 아늑한 분위기
//        tagValues.add(0D); // 오래 있기 좋아요
//        tagValues.add(0D); // 좋은 음악
//        tagValues.add(0D); // 주차하기 편해요
//        tagValues.add(0D); // 단체모임
//        tagValues.add(0D); // 입소문
//        tagValues.add(0D); // 음식이 빨리 나와요
//        tagValues.add(0D); // 특별한 날
//        tagValues.add(0D); // 신선해요
//        tagValues.add(0D); // 혼밥
//        tagValues.add(0D); // 푸짐해요
//        tagValues.add(0D); // 친구랑 가기 좋아요
//        tagValues.add(0D); // 특별메뉴
//        tagValues.add(0D); // 감성사진
//        tagValues.add(0D); // 가성비 맛집
//        tagValues.add(0D); // 쾌적한 공간
//        tagValues.add(0D); // 카공맛집
//        tagValues.add(0D); // 친절해요
//        tagValues.add(0D); // 카페
//        tagValues.add(0D); // 커피맛집
//        tagValues.add(0D); // 맛있는 디저트
//        tagValues.add(0D); // 맛있는 음료
//        tag1.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        tagRepository.save(tag1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        Shop shop1 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
//                .tag(tag1) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .build();
//
//        shopRepository.save(shop1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        List<Menu> menus1 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//                .name("")
//                .price(L)
//                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        menuRepository.saveAll(menus1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop1).photoUrl("").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop1).photoUrl("").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//
//        shopPhotoRepository.save(shopPhoto1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
//        shopPhotoRepository.save(shopPhoto2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        //testCase1
        phone = "02-465-1253";
        name = "온달집건대점";
        address = "서울 광진구 아차산로33길 46";
        addressPointY = 206195.337758774D;
        addressPointX = 448896.53740221D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "화\n" +
                "17:00 - 01:00\n" +
                "수\n" +
                "17:00 - 01:00\n" +
                "목\n" +
                "17:00 - 01:00\n" +
                "금\n" +
                "17:00 - 03:00\n" +
                "토\n" +
                "16:00 - 03:00\n" +
                "일\n" +
                "16:00 - 01:00\n" +
                "월\n" +
                "17:00 - 01:00\n";
        onelineReview = "술이 술술 넘어가는 숯불에 직접 구운 안주 신사동 전설의 맛집 온달집 프랜차이즈";
        mainPhotoUrl1 = "https://ldb-phinf.pstatic.net/20211018_169/1634544698532qkrRh_JPEG/X4iFTY1X9zsJlgA-_Kdk3u9w.jpg";
        mainPhotoUrl2 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MjNfMTQ5/MDAxNjg0ODUyNTU3Mzkx.UD5nz_8VO7z2V4whgehoMRo_BsJmsbfWG6TziwaAy-8g.D8bJ437klraPp9iTHNH-OjrR6TXDDwEi8hAs8jN5oqUg.JPEG/IMG_8935.jpeg";
        naverId = 1586693898L;
        kakaoId = 1184197970L;
        Tag tag1 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(24.9674D); // 맛있는 식당
        tagValues.add(23.7545D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(41.3246D); // 단체모임
        tagValues.add(20.4537D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(34.2345D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(10.0754D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
        tag1.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop1 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag1) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus1 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("닭다리살")
                .price(12000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("꼼장어")
                .price(12000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("무뼈닭발")
                .price(12000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus1.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("닭똥집")
                .price(12000L)
                .shop(shop1).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop1).photoUrl("https://ldb-phinf.pstatic.net/20211018_169/1634544698532qkrRh_JPEG/X4iFTY1X9zsJlgA-_Kdk3u9w.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop1).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MjNfMTQ5/MDAxNjg0ODUyNTU3Mzkx.UD5nz_8VO7z2V4whgehoMRo_BsJmsbfWG6TziwaAy-8g.D8bJ437klraPp9iTHNH-OjrR6TXDDwEi8hAs8jN5oqUg.JPEG/IMG_8935.jpeg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]



        //testCase2
        phone = "0507-1318-6780";
        name = "도시어부";
        address = "서울 광진구 뚝섬로 616";
        addressPointY = 206834.260286064D;
        addressPointX = 447788.378329188D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "화\n" +
                "10:30 - 00:50\n" +
                "수\n" +
                "10:30 - 00:50\n" +
                "목\n" +
                "10:30 - 00:50\n" +
                "금\n" +
                "10:30 - 00:50\n" +
                "토\n" +
                "11:00 - 00:50\n" +
                "일\n" +
                "11:00 - 23:50\n" +
                "월\n" +
                "10:30 - 00:50";
        onelineReview = "후회없는 맛과 가격!";
        mainPhotoUrl1 = "https://ldb-phinf.pstatic.net/20220915_279/1663234719226bQiT1_JPEG/20220211_194843.jpg";
        mainPhotoUrl2 = "https://myplace-phinf.pstatic.net/20210605_24/1622865206964vTX0y_JPEG/upload_f71d11c267a1d8556c71383af7370683.jpg";
        naverId = 1349503302L;
        kakaoId = 1615342777L;
        Tag tag2 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(29.4572D); // 맛있는 식당
        tagValues.add(15.4576D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(14.5684D); // 주차하기 편해요
        tagValues.add(17.2346D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(50.2138D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(27.8921D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
        tag2.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop2 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag2) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus2 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("주방장추천사시미")
                .price(30000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("참치")
                .price(45000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("방어")
                .price(40000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("전어")
                .price(35000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("세꼬시")
                .price(40000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("특초밥")
                .price(25000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("해산물")
                .price(25000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus2.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("사시미")
                .price(45000L)
                .shop(shop2).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto3 = ShopPhoto.builder().shop(shop2).photoUrl("https://ldb-phinf.pstatic.net/20220915_279/1663234719226bQiT1_JPEG/20220211_194843.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto4 = ShopPhoto.builder().shop(shop2).photoUrl("https://myplace-phinf.pstatic.net/20210605_24/1622865206964vTX0y_JPEG/upload_f71d11c267a1d8556c71383af7370683.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //testCase3
        phone = "02-462-1939";
        name = "매화반점";
        address = "서울 광진구 동일로18길 96";
        addressPointY = 205931.654297134D;
        addressPointX = 448457.421711072D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "화\n" +
                "14:00 - 24:00\n" +
                "수\n" +
                "14:00 - 24:00\n" +
                "목\n" +
                "14:00 - 24:00\n" +
                "금\n" +
                "14:00 - 24:00\n" +
                "토\n" +
                "14:00 - 24:00\n" +
                "일\n" +
                "14:00 - 24:00\n" +
                "월\n" +
                "정기휴무 (매주 월요일)";
        onelineReview = "건대에 왔으면 양꼬치";
        mainPhotoUrl1 = "https://mblogthumb-phinf.pstatic.net/MjAyMzA0MTBfOCAg/MDAxNjgxMTE2MzY3MTk5.N4jdX8UKPoPQ866ACT_4jtes-uQYwX-XTkTcyNMR2Ckg.sFe2T5_KdByW4P462_an02gAgySkH1io4RGrWGspW84g.JPEG.duwlsrjdwb/KakaoTalk_20230410_171704036_15.jpg?type=w800";
        mainPhotoUrl2 = "https://mblogthumb-phinf.pstatic.net/MjAyMzA0MTBfMjU4/MDAxNjgxMTE3NTIyNTcy.vIoze1MXlNqrHrIy785adyr0z_Ny9oHBQl3lOFyTXDcg.eBxif6Bm2Hl1b6eD-2y0CGJ_DbA4vLIGkqAyqln7E9og.JPEG.duwlsrjdwb/KakaoTalk_20230410_171704036_13.jpg?type=w800";
        naverId = 11864410L;
        kakaoId = 1746169235L;
        Tag tag3 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(15.122D); // 맛있는 식당
        tagValues.add(40.3543D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(30.4643D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(18.12392D); // 입소문
        tagValues.add(15.98124D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(40.4531D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(0D); // 카공맛집
        tagValues.add(5.1289D); // 친절해요
        tagValues.add(0D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(0D); // 맛있는 디저트
        tagValues.add(0D); // 맛있는 음료
        tag3.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        tagRepository.save(tag3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        Shop shop3 = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                .tag(tag3) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .build();

        shopRepository.save(shop3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        List<Menu> menus3 = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("양꼬치 1인분 (10꼬치)")
                .price(15000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("중국식 탕수육")
                .price(14000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("가지볶음")
                .price(12000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus3.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("크림새우")
                .price(17000L)
                .shop(shop3).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus3); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto5 = ShopPhoto.builder().shop(shop3).photoUrl("https://mblogthumb-phinf.pstatic.net/MjAyMzA0MTBfOCAg/MDAxNjgxMTE2MzY3MTk5.N4jdX8UKPoPQ866ACT_4jtes-uQYwX-XTkTcyNMR2Ckg.sFe2T5_KdByW4P462_an02gAgySkH1io4RGrWGspW84g.JPEG.duwlsrjdwb/KakaoTalk_20230410_171704036_15.jpg?type=w800").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto6 = ShopPhoto.builder().shop(shop3).photoUrl("https://mblogthumb-phinf.pstatic.net/MjAyMzA0MTBfMjU4/MDAxNjgxMTE3NTIyNTcy.vIoze1MXlNqrHrIy785adyr0z_Ny9oHBQl3lOFyTXDcg.eBxif6Bm2Hl1b6eD-2y0CGJ_DbA4vLIGkqAyqln7E9og.JPEG.duwlsrjdwb/KakaoTalk_20230410_171704036_13.jpg?type=w800").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //testCase4
        phone = "070-8787-9359";
        name = "그리네";
        address = "서울 광진구 동일로22길 117-7 1~2층 그리네";
        addressPointY = 206062.782587035D;
        addressPointX = 449463.60323827D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "매일\n" +
                "11:00 - 22:00";
        onelineReview = "건대 감성넘치는 베이커리 카페";
        mainPhotoUrl1 = "https://ldb-phinf.pstatic.net/20210219_63/1613734808431YORla_JPEG/PMn9YFhutxFkzh8ssytr4Gi1.jpg";
        mainPhotoUrl2 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MzBfMjUg/MDAxNjg1NDE0NDE0OTg2.TDEic6av5VJSdFwh7R80k5nrtrMYiSK7lCuxRJ6Byq4g.ZaLeNq-vg_o-l3LfAnwRHjyZTqLRDKWHAvSsGcCB8ZUg.JPEG/BC88C1A8-0842-4837-BE1D-FBBC13C392A3.jpeg";
        naverId = 1799218070L;
        kakaoId = 2106246357L;
        Tag tag4 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(24.2999D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(50.5995D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(12.3256D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(31.3256D); // 카페
        tagValues.add(0D); // 커피맛집
        tagValues.add(62.6233D); // 맛있는 디저트
        tagValues.add(16.1931D); // 맛있는 음료
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
                .name("마틸다 초코 케이크")
                .price(6300L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("바스크 치즈 케이크")
                .price(5900L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("고메 잠봉&뵈르 샌드위치")
                .price(6400L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("풀드포크 샌드위치")
                .price(6400L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus4.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("터키쉬 베이글 샌드위치")
                .price(6400L)
                .shop(shop4).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus4); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto7 = ShopPhoto.builder().shop(shop4).photoUrl("https://ldb-phinf.pstatic.net/20210219_63/1613734808431YORla_JPEG/PMn9YFhutxFkzh8ssytr4Gi1.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto8 = ShopPhoto.builder().shop(shop4).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MzBfMjUg/MDAxNjg1NDE0NDE0OTg2.TDEic6av5VJSdFwh7R80k5nrtrMYiSK7lCuxRJ6Byq4g.ZaLeNq-vg_o-l3LfAnwRHjyZTqLRDKWHAvSsGcCB8ZUg.JPEG/BC88C1A8-0842-4837-BE1D-FBBC13C392A3.jpeg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto7); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto8); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //testCase5
        phone = "0507-1407-3968";
        name = "흐릇";
        address = "서울 광진구 군자로 19 1층";
        addressPointY = 37.544964572070384D;
        addressPointX = 127.07105725368037D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "10:00 ~ 22:00\n" +
                "화\n" +
                "10:00 ~ 22:00\n" +
                "수\n" +
                "10:00 ~ 22:00\n" +
                "목\n" +
                "10:00 ~ 22:00\n" +
                "금\n" +
                "10:00 ~ 22:00\n" +
                "토\n" +
                "10:00 ~ 22:00\n" +
                "일\n" +
                "휴무";
        onelineReview = "홍차, 밀크티, 커피 그리고 다과가 있는 편안한 공간의 카페";
        mainPhotoUrl1 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MzBfMjIy/MDAxNjg1NDM4ODg1MzYy.OtxLInbz2AaIOwrpm4zTmQ6rCChI54Nqw3YprXkJvkMg.deRCQ2yVkT0PVt30bZBdMioSWPWTs4GoqO6UMMA0VBgg.JPEG/5E7002A1-DC9B-4D08-A00D-686ABF635B86.jpeg";
        mainPhotoUrl2 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MjdfMjY0/MDAxNjg1MTg3NTAzOTcz.1TyAxv5EqU_iFRs9JxciOsiKf4Cxcw-TOkYtIFjXj6gg.1_Qbgk6XT_9TUY0oNXoCxA-x1cYi3P1SQkRGZDIFrLAg.JPEG/IMG_20230527_203515_257.jpg";
        naverId = 1779793102L;
        kakaoId = 560527159L;
        Tag tag5 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(0D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(44.2926D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(13.2373D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(28.4334D); // 카페
        tagValues.add(18.2368D); // 커피맛집
        tagValues.add(42.2947D); // 맛있는 디저트
        tagValues.add(32.2185D); // 맛있는 음료
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
                .name("수박쥬스(생과일100%)대표")
                .price(6500L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("피넛초코바")
                .price(4500L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("바질스콘")
                .price(4300L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("베이컨감자스콘")
                .price(4500L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus5.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("보늬밤토스")
                .price(5500L)
                .shop(shop5).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus5); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto9 = ShopPhoto.builder().shop(shop5).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MzBfMjIy/MDAxNjg1NDM4ODg1MzYy.OtxLInbz2AaIOwrpm4zTmQ6rCChI54Nqw3YprXkJvkMg.deRCQ2yVkT0PVt30bZBdMioSWPWTs4GoqO6UMMA0VBgg.JPEG/5E7002A1-DC9B-4D08-A00D-686ABF635B86.jpeg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto10 = ShopPhoto.builder().shop(shop5).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MjdfMjY0/MDAxNjg1MTg3NTAzOTcz.1TyAxv5EqU_iFRs9JxciOsiKf4Cxcw-TOkYtIFjXj6gg.1_Qbgk6XT_9TUY0oNXoCxA-x1cYi3P1SQkRGZDIFrLAg.JPEG/IMG_20230527_203515_257.jpg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto9); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto10); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]


        //testCase6
        phone = "070-7954-1700";
        name = "트레비커피로스터스";
        address = "서울 광진구 군자로 63 1층 (우)05003";
        addressPointY = 208041.585129128D;
        addressPointX = 448135.50795533D;
        clippingCount = 0L;
        pickedCount = 0L;
        operatingHours = "월\n" +
                "09:00 ~ 22:00\n" +
                "화\n" +
                "09:00 ~ 22:00\n" +
                "수\n" +
                "09:00 ~ 22:00\n" +
                "목\n" +
                "09:00 ~ 22:00\n" +
                "금\n" +
                "09:00 ~ 22:00\n" +
                "토\n" +
                "10:00 ~ 22:00\n" +
                "일\n" +
                "10:00 ~ 22:00\n";
        onelineReview = "루프탑이 있는 핸드드립 전문 카페";
        mainPhotoUrl1 = "https://pup-review-phinf.pstatic.net/MjAyMzA1MDZfMTQ0/MDAxNjgzMzgwNDc3Mzg3.hBQsS3k9yIiHa0dZ6iuboMjG4tE8a-kRgZ1OOnqrqswg.AuLFbp5nTb0iKIy1ICiTPI3FWibNfGp2q9L9oZukGokg.JPEG/31AC664C-2165-481C-8B2F-53661E7DE86C.jpeg";
        mainPhotoUrl2 = "http://blogfiles.naver.net/MjAyMzAzMDlfOTkg/MDAxNjc4Mjg4NDkwMDAz.UIV5w94bQWEf1Eih9wPVnDl9ThwbTEQC13b0AWFvlUkg.lyEjhbuKLzs61k-deWlzvmC9zvY2jtOESXEfDcvEBcYg.JPEG.s_hyun_pila/8B120D2F-1607-454E-A21D-D1A8AC7459DB.jpeg";
        naverId = 1198884294L;
        kakaoId = 1220194232L;
        Tag tag6 = new Tag(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        tagValues.clear();
        tagValues.add(0D); // 이색맛집
        tagValues.add(0D); // 컨셉이 독특해요
        tagValues.add(0D); // 맛있는 식당
        tagValues.add(0D); // 좋은 술집
        tagValues.add(0D); // 코스요리 맛집
        tagValues.add(0D); // 차분한 분위기
        tagValues.add(12.2468D); // 아늑한 분위기
        tagValues.add(0D); // 오래 있기 좋아요
        tagValues.add(0D); // 좋은 음악
        tagValues.add(0D); // 주차하기 편해요
        tagValues.add(0D); // 단체모임
        tagValues.add(0D); // 입소문
        tagValues.add(0D); // 음식이 빨리 나와요
        tagValues.add(0D); // 특별한 날
        tagValues.add(0D); // 신선해요
        tagValues.add(0D); // 혼밥
        tagValues.add(0D); // 푸짐해요
        tagValues.add(0D); // 친구랑 가기 좋아요
        tagValues.add(0D); // 특별메뉴
        tagValues.add(0D); // 감성사진
        tagValues.add(0D); // 가성비 맛집
        tagValues.add(0D); // 쾌적한 공간
        tagValues.add(54.21216D); // 카공맛집
        tagValues.add(0D); // 친절해요
        tagValues.add(30.12766D); // 카페
        tagValues.add(44.1999D); // 커피맛집
        tagValues.add(12.4797D); // 맛있는 디저트
        tagValues.add(23.2384D); // 맛있는 음료
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
                .name("필터커피")
                .price(5500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("아메리카노")
                .price(4000L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("케모마일")
                .price(4500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        menus6.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                .name("자몽에이드")
                .price(5500L)
                .shop(shop6).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        menuRepository.saveAll(menus6); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        ShopPhoto shopPhoto11 = ShopPhoto.builder().shop(shop6).photoUrl("https://pup-review-phinf.pstatic.net/MjAyMzA1MDZfMTQ0/MDAxNjgzMzgwNDc3Mzg3.hBQsS3k9yIiHa0dZ6iuboMjG4tE8a-kRgZ1OOnqrqswg.AuLFbp5nTb0iKIy1ICiTPI3FWibNfGp2q9L9oZukGokg.JPEG/31AC664C-2165-481C-8B2F-53661E7DE86C.jpeg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        ShopPhoto shopPhoto12 = ShopPhoto.builder().shop(shop6).photoUrl("http://blogfiles.naver.net/MjAyMzAzMDlfOTkg/MDAxNjc4Mjg4NDkwMDAz.UIV5w94bQWEf1Eih9wPVnDl9ThwbTEQC13b0AWFvlUkg.lyEjhbuKLzs61k-deWlzvmC9zvY2jtOESXEfDcvEBcYg.JPEG.s_hyun_pila/8B120D2F-1607-454E-A21D-D1A8AC7459DB.jpeg").build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        shopPhotoRepository.save(shopPhoto11); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
        shopPhotoRepository.save(shopPhoto12); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

    }

    // 정제된 데이터 csv로 넣기
    @Transactional
    public void putDataIntoDatabaseByCSV() throws IOException, CsvException {

        // csv 오픈
        // utf-8 형태로 csv 파일 파싱
        ClassPathResource resourceShop = new ClassPathResource("db_shop_table.csv");
        CSVReader shopCsvReader = new CSVReader(new FileReader(resourceShop.getFile()));

        ClassPathResource resourceTag = new ClassPathResource("db_tag_table.csv");
        CSVReader tagCsvReader = new CSVReader(new FileReader(resourceTag.getFile()));

        ClassPathResource resourceMenu = new ClassPathResource("db_menu_table.csv");
        CSVReader menuCsvReader = new CSVReader(new FileReader(resourceMenu.getFile()));

        shopCsvReader.readNext(); // 컬럼명은 저장되지 않도록 한 줄 읽기

        String[] shopStrings;
        String[] tagStrings;
        String[] menuStrings;

        int cnt = 0;

        while ((shopStrings = shopCsvReader.readNext()) != null) {
            //한 라인 읽기 (자동으로 콤마 분리해서 배열에 저장 됌)
            tagStrings = tagCsvReader.readNext();
            menuStrings = tagCsvReader.readNext();

            cnt++;

            String phone = shopStrings[1];
            String name = shopStrings[2];
            String address = shopStrings[3];
            Double addressPointY = Double.valueOf(shopStrings[4]);
            Double addressPointX = Double.valueOf(shopStrings[5]);
            Long clippingCount = Long.valueOf(shopStrings[6]);
            Long pickedCount = Long.valueOf(shopStrings[7]);
            String operatingHours = shopStrings[8];
            String onelineReview = shopStrings[9];
            String mainPhotoUrl1 = shopStrings[10];
            String mainPhotoUrl2 = shopStrings[11];
            Long naverId = Long.valueOf(shopStrings[12]);
            Long kakaoId = Long.valueOf(shopStrings[13]);
            Tag tag = new Tag();
            List<Double> tagValues = new ArrayList<>();
            for (int i=1;i<=28;i++) {
                tagValues.add(Double.valueOf(tagStrings[i]));
            }
            tag.setTagsByList(tagValues); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

            tagRepository.save(tag); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

            Shop shop = Shop.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
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
                    .tag(tag) // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                    .build();

            shopRepository.save(shop); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

            List<Menu> menus = new ArrayList<>(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
            for (;Long.valueOf(menuStrings[2]) != cnt; menuStrings = menuCsvReader.readNext()) {
                menus.add(Menu.builder() // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
                        .name(menuStrings[0])
                        .price(Long.valueOf(menuStrings[1]))
                        .shop(shop).build()); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
            }

            menuRepository.saveAll(menus); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

            ShopPhoto shopPhoto1 = ShopPhoto.builder().shop(shop).photoUrl(shopStrings[10]).build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
            ShopPhoto shopPhoto2 = ShopPhoto.builder().shop(shop).photoUrl(shopStrings[11]).build(); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

            shopPhotoRepository.save(shopPhoto1); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]
            shopPhotoRepository.save(shopPhoto2); // [테스트 데이터 늘릴 때, 객체 이름 바꿔줘야 함]

        }

        shopCsvReader.close();
        tagCsvReader.close();
        menuCsvReader.close();
    }

}