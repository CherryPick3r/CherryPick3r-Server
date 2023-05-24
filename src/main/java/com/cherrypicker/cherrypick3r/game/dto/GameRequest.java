package com.cherrypicker.cherrypick3r.game.dto;

import lombok.Builder;

public class GameRequest {

    public Long gameId;

    public Long shopId;

    @Builder
    public GameRequest(Long gameId, Long shopId) {
        this.gameId = gameId;
        this.shopId = shopId;
    }

}
