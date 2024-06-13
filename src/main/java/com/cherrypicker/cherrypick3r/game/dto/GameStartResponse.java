package com.cherrypicker.cherrypick3r.game.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopCardResponse;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class GameStartResponse {

    public Long gameId;

    public Long totalRound;

    public Long curRound;

    public Long gameStatus;

    public List<Long> recommendShopIds;

    public List<ShopCardResponse> recommendShops;

    @Builder
    public GameStartResponse(Long gameId, Long totalRound, Long curRound, Long gameStatus, List<Long> recommendShopIds , List<ShopCardResponse> recommendShops) {
        this.gameId = gameId;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.gameStatus = gameStatus;
        this.recommendShopIds = recommendShopIds;
        this.recommendShops = recommendShops;
    }

}
