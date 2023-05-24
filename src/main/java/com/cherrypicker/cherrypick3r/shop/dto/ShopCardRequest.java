package com.cherrypicker.cherrypick3r.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ShopCardRequest {

    public Long gameId;

    @Builder
    public ShopCardRequest(Long gameId) {
        this.gameId = gameId;
    }

}
