package com.cherrypicker.cherrypick3r.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserNicknameChangeResponse {

    public String originalUserNickname;

    public String changedUserNickname;

    @Builder
    public UserNicknameChangeResponse(String originalUserNickname, String changedUserNickname) {
        this.originalUserNickname = originalUserNickname;
        this.changedUserNickname = changedUserNickname;
    }

}
