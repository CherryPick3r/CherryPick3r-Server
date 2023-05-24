package com.cherrypicker.cherrypick3r.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginResponse {

    public String loginURL;

    @Builder
    public LoginResponse(String loginURL) {
        this.loginURL = loginURL;
    }
}
