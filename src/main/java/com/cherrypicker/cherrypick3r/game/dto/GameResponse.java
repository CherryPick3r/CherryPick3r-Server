package com.cherrypicker.cherrypick3r.game.dto;

import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopCardResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GameResponse {

    public Long gameId;

    public Long totalRound;

    public Long curRound;

    public Long gameStatus;

    public List<Long> recommendShopIds;

    public List<ShopCardResponse> recommendShops;

    @Builder
    public GameResponse(Long gameId , Long totalRound, Long curRound, Long gameStatus, List<Long> recommendShopIds, List<ShopCardResponse> recommendShops) {
        this.gameId = gameId;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.gameStatus = gameStatus;
        this.recommendShopIds = recommendShopIds;
        this.recommendShops = recommendShops;
    }

    public GameResponse() {
        this.gameId = null;
        this.totalRound = null;
        this.curRound = null;
        this.gameStatus = null;
        this.recommendShopIds = null;
        this.recommendShops = null;
    }

//    public ResultDto resultDto;
//
//    public GameDto gameDto;
//
//    public List<ShopDto> shopDtos;
//
//    @Builder
//    public GameResponse(ResultDto resultDto, GameDto gameDto, List<ShopDto> shopDtos) {
//        this.resultDto = resultDto;
//        this.gameDto = gameDto;
//        this.shopDtos = shopDtos;
//    }
//
//    public GameResponse() {
//        this.resultDto = null;
//        this.gameDto = null;
//        this.shopDtos = null;
//    }
}
