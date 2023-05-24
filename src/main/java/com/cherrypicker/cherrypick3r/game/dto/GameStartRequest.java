package com.cherrypicker.cherrypick3r.game.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class GameStartRequest {

    public String userEmail;

    public Long gameMode;

    @Builder
    public GameStartRequest(String userEmail, Long gameMode) {
        this.userEmail = userEmail;
        this.gameMode = gameMode;
    }

}
