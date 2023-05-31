package com.cherrypicker.cherrypick3r.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class UserClassPair {

    public String userClass;

    public List<Double> userClassValues;

    @Builder
    public UserClassPair(String userClass, List<Double> userClassValues) {
        this.userClass = userClass;
        this.userClassValues = userClassValues;
    }

}
