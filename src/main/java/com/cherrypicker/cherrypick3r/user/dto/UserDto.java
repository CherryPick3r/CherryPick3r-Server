package com.cherrypicker.cherrypick3r.user.dto;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassify;
import lombok.Builder;
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

    @Builder
    public UserDto(String email, String nickname, String auth, Tag tag, UserClassify userClassify){
        this.email = email;
        this.nickname = nickname;
        this.auth = auth;
        this.tag = tag;
        this.userClassify = userClassify;
    }
}
