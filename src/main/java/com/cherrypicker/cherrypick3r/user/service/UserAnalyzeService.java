package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.clipping.domain.ClippingRepository;
import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.component.TagType;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopScoreDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.user.dto.UserClassPair;
import com.cherrypicker.cherrypick3r.user.dto.UserSimilarityPair;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassify;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassifyRepository;
import com.cherrypicker.cherrypick3r.userClassify.service.UserClassifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAnalyzeService {

    private final UserRepository userRepository;

    private final TagRepository tagRepository;

    private final ShopRepository shopRepository;

    private final ClippingService clippingService;

    private final ClippingRepository clippingRepository;

    private final UserClassifyRepository userClassifyRepository;

    private final UserClassifyService userClassifyService;

    private final ShopClassifyService shopClassifyService;

    private final ShopClassifyRepository shopClassifyRepository;

    private final GameCalc gameCalc;

    @Transactional
    public Double calcUserPercentile(String userEmail) {
        List<User> users = userRepository.findAll();
        List<UserSimilarityPair> userSimilarityPairs = new ArrayList<>();

        // 각 유저와 다른 모든 유저의 유사도를 더한 리스트를 만든다.
        for (User user : users) {
            UserSimilarityPair userSimilarityPair = new UserSimilarityPair(user, 0D);

            for (User innerUser : users) {
                userSimilarityPair.setSimilarity(userSimilarityPair.getSimilarity() + gameCalc.euclideanSimilarity(innerUser.getTag().getTagsByList(), user.getTag().getTagsByList()));
            }

            userSimilarityPairs.add(userSimilarityPair);
        }

        // 오름차순 정렬
        Collections.sort(userSimilarityPairs, Comparator.comparingDouble(UserSimilarityPair::getSimilarity));

        int size = userSimilarityPairs.size();
        for (int i=0;i<size;i++) {
            if (userSimilarityPairs.get(i).getUser().getEmail().equals(userEmail)) {
                double percentile = (1 - ((double)i / size)) * 100;
                return Double.valueOf(String.format("%.2f", percentile));
            }
        }

//        System.out.println("PreferenceUserNotFound");
        // 유저가 리스트에 없는 경우
        return 1D;
    }

    @Transactional
    public UserClassPair findUserClass(String userEmail) {
        List<Shop> shops = clippingService.findClippingShopByUser(userEmail);

        if (shops.size() == 0) {
            List<Double> userClassValues = new ArrayList<>();
            userClassValues.add(0D);
            userClassValues.add(0D);
            userClassValues.add(0D);
            userClassValues.add(0D);
            userClassValues.add(0D);
            userClassValues.add(0D);
            userClassValues.add(0D);

            UserClassPair userClassPair = UserClassPair.builder()
                    .userClass("기타")
                    .userClassValues(userClassValues)
                    .build();
            return userClassPair;
        }

        // 순서: 맛집탐방러, 미니인플루언서, 건강식, 기타, 카페인 뱀파이어, 혼밥러, 술고래
        String userClass;
//        List<String> userClasses = new ArrayList<>();
//        userClasses.add("맛집탐방러");     // 11001 00000 01010 00010 00010 011
//        userClasses.add("미니인플루언서");  // 00000 00000 00000 00001 01000 011
//        userClasses.add("건강식");        // 00000 00000 00001 00000 00000 000
//        userClasses.add("기타");         // 00000 00001 00000 00000 00000 000
//        userClasses.add("카페인 뱀파이어"); // 00000 11100 00000 00000 01101 111
//        userClasses.add("혼밥러");        // 00000 00000 00000 10000 10000 000
//        userClasses.add("술고래");        // 00110 00010 10100 01100 00000 000

        List<Double> userClassValues = new ArrayList<>();

        // 태그에 해당하는 개수
        int total = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt4 = 0;
        int cnt5 = 0;
        int cnt6 = 0;
        int cnt7 = 0;

        // 만약 가게 클래시파이 테이블이 없는 경우에는 전체 가게에 대한 클래시파이 테이블 생성해두기
        if (shopClassifyRepository.findAll().size() == 0) {
            shopClassifyService.makeAllShopClassifyUsingTagValues(15D);
        }

        for (Shop shop : shops) {
            List<Long> values = shop.getShopClassify().getShopClassifyByList();

            if (values.get(0) == 1 || values.get(1) == 1 || values.get(4) == 1 || values.get(11) == 1 || values.get(13) == 1 || values.get(18) == 1 || values.get(23) == 1 || values.get(26) == 1 || values.get(27) == 1) {
                cnt1++;
            }

            if (values.get(19) == 1 || values.get(21) == 1 || values.get(26) == 1 || values.get(27) == 1) {
                cnt2++;
            }

            if (values.get(14) == 1) {
                cnt3++;
            }

            if (values.get(9) == 1) {
                cnt4++;
            }

            if (values.get(5) == 1 || values.get(6) == 1 || values.get(7) == 1 || values.get(21) == 1 || values.get(22) == 1 || values.get(24) == 1 || values.get(25) == 1 || values.get(26) == 1 || values.get(27) == 1) {
                cnt5++;
            }

            if (values.get(12) == 1 || values.get(15) == 1 || values.get(20) == 1) {
                cnt6++;
            }

            if (values.get(2) == 1 || values.get(3) == 1 || values.get(8) == 1 || values.get(10) == 1 || values.get(16) == 1 || values.get(17) == 1) {
                cnt7++;
            }
        }

        int max = Math.max(cnt1, Math.max(cnt2, Math.max(cnt3, Math.max(cnt4, Math.max(cnt5, Math.max(cnt6, cnt7))))));
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

        total = cnt1 + cnt2 + cnt3 + cnt4 + cnt5 + cnt6 + cnt7;

        userClassValues.add(Double.valueOf((double)cnt1 / total));
        userClassValues.add(Double.valueOf((double)cnt2 / total));
        userClassValues.add(Double.valueOf((double)cnt3 / total));
        userClassValues.add(Double.valueOf((double)cnt4 / total));
        userClassValues.add(Double.valueOf((double)cnt5 / total));
        userClassValues.add(Double.valueOf((double)cnt6 / total));
        userClassValues.add(Double.valueOf((double)cnt7 / total));

        UserClassPair userClassPair = UserClassPair.builder()
                .userClass(userClass)
                .userClassValues(userClassValues)
                .build();

        return userClassPair;
    }

    @Transactional
    public List<String> findUserPreferenceTags(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();

        List<Double> tags = user.getTag().getTagsByList();
        List<Long> userClassifys = new ArrayList<>();
        int tagsLen = tags.size();

        for (int i=0;i<tagsLen;i++) {
            if (tags.get(i) <= 2D) {
                userClassifys.add(0L);
            }
            else {
                userClassifys.add(1L);
            }
        }

        List<String> retTags = new ArrayList<>();

        if (userClassifys.get(0) == 1) retTags.add(TagType.CTAG001.getDescription());
        if (userClassifys.get(1) == 1) retTags.add(TagType.CTAG002.getDescription());
        if (userClassifys.get(2) == 1) retTags.add(TagType.CTAG003.getDescription());
        if (userClassifys.get(3) == 1) retTags.add(TagType.CTAG004.getDescription());
        if (userClassifys.get(4) == 1) retTags.add(TagType.CTAG005.getDescription());
        if (userClassifys.get(5) == 1) retTags.add(TagType.CTAG006.getDescription());
        if (userClassifys.get(6) == 1) retTags.add(TagType.CTAG007.getDescription());
        if (userClassifys.get(7) == 1) retTags.add(TagType.CTAG008.getDescription());
        if (userClassifys.get(8) == 1) retTags.add(TagType.CTAG009.getDescription());
        if (userClassifys.get(9) == 1) retTags.add(TagType.CTAG010.getDescription());
        if (userClassifys.get(10) == 1) retTags.add(TagType.CTAG011.getDescription());
        if (userClassifys.get(11) == 1) retTags.add(TagType.CTAG012.getDescription());
        if (userClassifys.get(12) == 1) retTags.add(TagType.CTAG013.getDescription());
        if (userClassifys.get(13) == 1) retTags.add(TagType.CTAG014.getDescription());
        if (userClassifys.get(14) == 1) retTags.add(TagType.CTAG015.getDescription());
        if (userClassifys.get(15) == 1) retTags.add(TagType.CTAG016.getDescription());
        if (userClassifys.get(16) == 1) retTags.add(TagType.CTAG017.getDescription());
        if (userClassifys.get(17) == 1) retTags.add(TagType.CTAG018.getDescription());
        if (userClassifys.get(18) == 1) retTags.add(TagType.CTAG019.getDescription());
        if (userClassifys.get(19) == 1) retTags.add(TagType.CTAG020.getDescription());
        if (userClassifys.get(20) == 1) retTags.add(TagType.CTAG021.getDescription());
        if (userClassifys.get(21) == 1) retTags.add(TagType.CTAG022.getDescription());
        if (userClassifys.get(22) == 1) retTags.add(TagType.CTAG023.getDescription());
        if (userClassifys.get(23) == 1) retTags.add(TagType.CTAG024.getDescription());
        if (userClassifys.get(24) == 1) retTags.add(TagType.CTAG025.getDescription());
        if (userClassifys.get(25) == 1) retTags.add(TagType.CTAG026.getDescription());
        if (userClassifys.get(26) == 1) retTags.add(TagType.CTAG027.getDescription());
        if (userClassifys.get(27) == 1) retTags.add(TagType.CTAG028.getDescription());

        return retTags;
    }


}
