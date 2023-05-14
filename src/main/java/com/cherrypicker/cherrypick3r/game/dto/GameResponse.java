package com.cherrypicker.cherrypick3r.game.dto;

import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GameResponse {
    public ResultDto resultDto;

    public GameDto gameDto;

    public List<ShopDto> shopDtos;

    @Builder
    public GameResponse(ResultDto resultDto, GameDto gameDto, List<ShopDto> shopDtos) {
        this.resultDto = resultDto;
        this.gameDto = gameDto;
        this.shopDtos = shopDtos;
    }

    public GameResponse() {
        this.resultDto = null;
        this.gameDto = null;
        this.shopDtos = null;
    }
}
