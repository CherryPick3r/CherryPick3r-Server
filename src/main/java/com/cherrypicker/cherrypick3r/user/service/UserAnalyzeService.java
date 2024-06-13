package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.component.GameCalc;
import com.cherrypicker.cherrypick3r.component.TagType;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.dto.UserSimilarityPair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAnalyzeService {

    private final UserSearchService userSearchService;

    private final GameCalc gameCalc;

    @Transactional
    public Double calcUserPercentile(String userEmail) {
        List<User> users = userSearchService.findAllUsers();
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
        User user = userSearchService.findUserByEmail(userEmail);

        List<Double> tags = user.getTag().getTagsByList();
        List<Long> userClassifys = tags.stream()
            .map(tag -> tag <= 2D ? 0L : 1L)
            .collect(Collectors.toList());

        List<String> retTags = new ArrayList<>();

        TagType[] tagTypes = TagType.values();
        for (int i = 0; i < userClassifys.size(); i++) {
            if (userClassifys.get(i) == 1 && i < tagTypes.length) {
                retTags.add(tagTypes[i].getDescription());
            }
        }

        return retTags;
    }


}
