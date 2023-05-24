package com.cherrypicker.cherrypick3r.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserNicknameResponse {

    public String userNickname;

    @Builder
    public UserNicknameResponse(String userNickname) {
        this.userNickname = userNickname;
    }

}
