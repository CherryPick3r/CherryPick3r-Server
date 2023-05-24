package com.cherrypicker.cherrypick3r.game.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopDetailResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class GameEndResponse {

    public Long gameId;

    public Long totalRound;

    public Long curRound;

    public Long gameStatus;

    public Long recommendedShopId;

    public ShopDetailResponse recommendedShopDetail;

    @Builder
    public GameEndResponse(Long gameId, Long totalRound, Long curRound, Long gameStatus, Long recommendedShopId, ShopDetailResponse recommendedShopDetail) {
        this.gameId = gameId;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.gameStatus = gameStatus;
        this.recommendedShopId = recommendedShopId;
        this.recommendedShopDetail = recommendedShopDetail;
    }

}
