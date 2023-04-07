package com.cherrypicker.cherrypick3r.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialDto {

    // 유저 이메일
    private String email;

    // 유저 이름 (소셜 로그인의 경우 실명)
    private String name;

    // 유저의 프로필 사진 Url
    private String imageUrl;
}
