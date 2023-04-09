package com.cherrypicker.cherrypick3r.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoAccessTokenDto {

    // 토큰 타입, bearer로 고정
    private String token_type;

    // 사용자 액세스 토큰 값
    private String access_token;

    // 액세스 토큰과 ID 토큰의 만료 시간(초)
    private Integer expires_in;

    // 사용자 리프레시 토큰 값
    private String refresh_token;

    // 리프레시 토큰 만료 시간(초)
    private Integer refresh_token_expires_in;

}
