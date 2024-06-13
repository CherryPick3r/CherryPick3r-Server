package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.user.dto.UserClassPair;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserClassService {

    private final ClippingService clippingService;

    private final ShopClassifyService shopClassifyService;

    private final ShopClassifyRepository shopClassifyRepository;

    final int USER_CLASS_SIZE = 7;

    @Transactional
    public UserClassPair findUserClass(String userEmail) {
        List<Shop> shops = clippingService.findClippingShopByUser(userEmail);

        // 유저가 아직 저장한 가게가 없는 경우, 기본 설정을 반환
        if (shops.isEmpty()) {
            return getEmptyClassPair();
        }

        String userClass; // 유저가 속한 분류
        List<Double> userClassValues = getEmptyClassValues(); // 분류별 비율

        // 태그에 해당하는 개수
        int total = 0, cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0, cnt6 = 0, cnt7 = 0;

        // 만약 가게 클래시파이 테이블이 없는 경우에는 전체 가게에 대한 클래시파이 테이블 생성해두기
        if (shopClassifyRepository.findAll().isEmpty()) {
            shopClassifyService.makeAllShopClassifyUsingTagValues(15D);
        }

        for (Shop shop : shops) {
            List<Long> values = shop.getShopClassify().getShopClassifyByList();

            cnt1 += isUserClass1(values) ? 1 : 0;
            cnt2 += isUserClass2(values) ? 1 : 0;
            cnt3 += isUserClass3(values) ? 1 : 0;
            cnt4 += isUserClass4(values) ? 1 : 0;
            cnt5 += isUserClass5(values) ? 1 : 0;
            cnt6 += isUserClass6(values) ? 1 : 0;
            cnt7 += isUserClass7(values) ? 1 : 0;
        }

        // 유저가 어떤 범주에 속하는지 도출한다.
        userClass = calcUserClass(cnt1, cnt2, cnt3, cnt4, cnt5, cnt6, cnt7);

        // 유저 통계의 값을 계산한다.
        total = cnt1 + cnt2 + cnt3 + cnt4 + cnt5 + cnt6 + cnt7;
        userClassValues.set(0, (double) cnt1 / total);
        userClassValues.set(1, (double) cnt2 / total);
        userClassValues.set(2, (double) cnt3 / total);
        userClassValues.set(3, (double) cnt4 / total);
        userClassValues.set(4, (double) cnt5 / total);
        userClassValues.set(5, (double) cnt6 / total);
        userClassValues.set(6, (double) cnt7 / total);

        return UserClassPair.builder()
            .userClass(userClass)
            .userClassValues(userClassValues)
            .build();
    }

    // '맛집탐방러' 범주에 속하는지 확인 [11001 00000 01010 00010 00010 011]
    private Boolean isUserClass1(List<Long> values) {
        return values.get(0) == 1 || values.get(1) == 1 || values.get(4) == 1
            || values.get(11) == 1 || values.get(13) == 1 || values.get(18) == 1
            || values.get(23) == 1 || values.get(26) == 1 || values.get(27) == 1;
    }

    // '미니인플루언서' 범주에 속하는지 확인 [00000 00000 00000 00001 01000 011]
    private Boolean isUserClass2(List<Long> values) {
        return values.get(19) == 1 || values.get(21) == 1 || values.get(26) == 1
            || values.get(27) == 1;
    }

    // '건강식' 범주에 속하는지 확인 [00000 00000 00001 00000 00000 000]
    private Boolean isUserClass3(List<Long> values) {
        return values.get(14) == 1;
    }

    // '기타' 범주에 속하는지 확인 [00000 00001 00000 00000 00000 000]
    private Boolean isUserClass4(List<Long> values) {
        return values.get(9) == 1;
    }

    // '카페인 뱀파이어' 범주에 속하는지 확인 [00000 11100 00000 00000 01101 111]
    private Boolean isUserClass5(List<Long> values) {
        return values.get(5) == 1 || values.get(6) == 1 || values.get(7) == 1
            || values.get(21) == 1 || values.get(22) == 1 || values.get(24) == 1
            || values.get(25) == 1 || values.get(26) == 1 || values.get(27) == 1;
    }

    // '혼밥러' 범주에 속하는지 확인 [00000 00000 00000 10000 10000 000]
    private Boolean isUserClass6(List<Long> values) {
        return values.get(12) == 1 || values.get(15) == 1 || values.get(20) == 1;
    }

    // '술고래' 범주에 속하는지 확인 [00110 00010 10100 01100 00000 000]
    private Boolean isUserClass7(List<Long> values) {
        return values.get(2) == 1 || values.get(3) == 1 || values.get(8) == 1
            || values.get(10) == 1 || values.get(16) == 1 || values.get(17) == 1;
    }

    // 카운팅된 값들을 이용해서 유저 클래스를 도출한다.
    private String calcUserClass(int cnt1, int cnt2, int cnt3, int cnt4, int cnt5, int cnt6,
        int cnt7) {
        // 순서: 맛집탐방러, 미니인플루언서, 건강식, 기타, 카페인 뱀파이어, 혼밥러, 술고래
        String userClass;

        int max = Math.max(cnt1,
            Math.max(cnt2, Math.max(cnt3, Math.max(cnt4, Math.max(cnt5, Math.max(cnt6, cnt7))))));
        if (max == cnt1) {
            userClass = "맛집탐방러";
        } else if (max == cnt2) {
            userClass = "미니인플루언서";
        } else if (max == cnt3) {
            userClass = "건강식";
        } else if (max == cnt4) {
            userClass = "기타";
        } else if (max == cnt5) {
            userClass = "카페인 뱀파이어";
        } else if (max == cnt6) {
            userClass = "혼밥러";
        } else {
            userClass = "술고래";
        }

        return userClass;
    }

    // 0으로 초기화된 유저 클래스 값 반환
    private List<Double> getEmptyClassValues() {
        List<Double> userClassValues = new ArrayList<>();
        for (int i = 0; i < USER_CLASS_SIZE; i++) {
            userClassValues.add(0D);
        }

        return userClassValues;
    }

    // 클리핑한 가게가 없는 경우, 기본 설정을 반환
    private UserClassPair getEmptyClassPair() {
        List<Double> userClassValues = getEmptyClassValues();

        return UserClassPair.builder()
            .userClass("기타")
            .userClassValues(userClassValues)
            .build();
    }

}
