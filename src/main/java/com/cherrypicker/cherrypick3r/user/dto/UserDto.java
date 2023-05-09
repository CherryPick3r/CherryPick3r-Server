package com.cherrypicker.cherrypick3r.user.dto;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassify;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    // 유저 이메일
    private String email;

    // 유저 이름 (소셜 로그인의 경우 실명)
    private String nickname;

    // 유저 권한 "ROLE_USER, ROLE_ADMIN"
    private String auth;

    private Tag tag;

    private UserClassify userClassify;
}
