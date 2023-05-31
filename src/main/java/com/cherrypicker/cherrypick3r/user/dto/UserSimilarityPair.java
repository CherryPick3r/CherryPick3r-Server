package com.cherrypicker.cherrypick3r.user.dto;

import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserSimilarityPair {

    public User user;

    public Double similarity;

    @Builder
    public UserSimilarityPair(User user, Double similarity) {
        this.user = user;
        this.similarity = similarity;
    }

}
