package com.cherrypicker.cherrypick3r.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDeleteResponse {

    public String loginURL;

    @Builder
    public UserDeleteResponse(String loginURL) {
        this.loginURL = loginURL;
    }

}
