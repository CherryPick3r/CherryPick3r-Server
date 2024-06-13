package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.component.TagType;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.user.dto.UserSimilarityPair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAnalyzeService {

    private final UserRepository userRepository;

    private final GameCalc gameCalc;

    @Transactional
    public Double calcUserPercentile(String userEmail) {
        List<User> users = userRepository.findAll();
        List<UserSimilarityPair> userSimilarityPairs = new ArrayList<>();

        // 각 유저와 다른 모든 유저의 유사도를 더한 리스트를 만든다.
        for (User user : users) {
            UserSimilarityPair userSimilarityPair = new UserSimilarityPair(user, 0D);

            for (User innerUser : users) {
                userSimilarityPair.setSimilarity(
                    userSimilarityPair.getSimilarity() + gameCalc.euclideanSimilarity(
                        innerUser.getTag().getTagsByList(), user.getTag().getTagsByList()));
            }

            userSimilarityPairs.add(userSimilarityPair);
        }

        // 오름차순 정렬
        userSimilarityPairs.sort(Comparator.comparingDouble(UserSimilarityPair::getSimilarity));

        int size = userSimilarityPairs.size();
        for (int i = 0; i < size; i++) {
            if (userSimilarityPairs.get(i).getUser().getEmail().equals(userEmail)) {
                double percentile = (1 - ((double) i / size)) * 100;
                return Double.valueOf(String.format("%.2f", percentile));
            }
        }

        // 유저가 리스트에 없는 경우
        return 1D;
    }

    @Transactional
    public List<String> findUserPreferenceTags(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();

        List<Double> tags = user.getTag().getTagsByList();
        List<Long> userClassifys = new ArrayList<>();
        int tagsLen = tags.size();

        for (int i = 0; i < tagsLen; i++) {
            if (tags.get(i) <= 2D) {
                userClassifys.add(0L);
            } else {
                userClassifys.add(1L);
            }
        }

        List<String> retTags = new ArrayList<>();

        if (userClassifys.get(0) == 1) {
            retTags.add(TagType.CTAG001.getDescription());
        }
        if (userClassifys.get(1) == 1) {
            retTags.add(TagType.CTAG002.getDescription());
        }
        if (userClassifys.get(2) == 1) {
            retTags.add(TagType.CTAG003.getDescription());
        }
        if (userClassifys.get(3) == 1) {
            retTags.add(TagType.CTAG004.getDescription());
        }
        if (userClassifys.get(4) == 1) {
            retTags.add(TagType.CTAG005.getDescription());
        }
        if (userClassifys.get(5) == 1) {
            retTags.add(TagType.CTAG006.getDescription());
        }
        if (userClassifys.get(6) == 1) {
            retTags.add(TagType.CTAG007.getDescription());
        }
        if (userClassifys.get(7) == 1) {
            retTags.add(TagType.CTAG008.getDescription());
        }
        if (userClassifys.get(8) == 1) {
            retTags.add(TagType.CTAG009.getDescription());
        }
        if (userClassifys.get(9) == 1) {
            retTags.add(TagType.CTAG010.getDescription());
        }
        if (userClassifys.get(10) == 1) {
            retTags.add(TagType.CTAG011.getDescription());
        }
        if (userClassifys.get(11) == 1) {
            retTags.add(TagType.CTAG012.getDescription());
        }
        if (userClassifys.get(12) == 1) {
            retTags.add(TagType.CTAG013.getDescription());
        }
        if (userClassifys.get(13) == 1) {
            retTags.add(TagType.CTAG014.getDescription());
        }
        if (userClassifys.get(14) == 1) {
            retTags.add(TagType.CTAG015.getDescription());
        }
        if (userClassifys.get(15) == 1) {
            retTags.add(TagType.CTAG016.getDescription());
        }
        if (userClassifys.get(16) == 1) {
            retTags.add(TagType.CTAG017.getDescription());
        }
        if (userClassifys.get(17) == 1) {
            retTags.add(TagType.CTAG018.getDescription());
        }
        if (userClassifys.get(18) == 1) {
            retTags.add(TagType.CTAG019.getDescription());
        }
        if (userClassifys.get(19) == 1) {
            retTags.add(TagType.CTAG020.getDescription());
        }
        if (userClassifys.get(20) == 1) {
            retTags.add(TagType.CTAG021.getDescription());
        }
        if (userClassifys.get(21) == 1) {
            retTags.add(TagType.CTAG022.getDescription());
        }
        if (userClassifys.get(22) == 1) {
            retTags.add(TagType.CTAG023.getDescription());
        }
        if (userClassifys.get(23) == 1) {
            retTags.add(TagType.CTAG024.getDescription());
        }
        if (userClassifys.get(24) == 1) {
            retTags.add(TagType.CTAG025.getDescription());
        }
        if (userClassifys.get(25) == 1) {
            retTags.add(TagType.CTAG026.getDescription());
        }
        if (userClassifys.get(26) == 1) {
            retTags.add(TagType.CTAG027.getDescription());
        }
        if (userClassifys.get(27) == 1) {
            retTags.add(TagType.CTAG028.getDescription());
        }

        return retTags;
    }


}
