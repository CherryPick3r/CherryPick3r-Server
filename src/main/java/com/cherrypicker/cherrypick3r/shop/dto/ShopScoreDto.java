package com.cherrypicker.cherrypick3r.shop.dto;

import lombok.Data;

@Data
public class ShopScoreDto {
    private ShopDto shopDto;

    private Double score;

    public ShopScoreDto(ShopDto shopDto, Double score) {
        this.shopDto = shopDto;
        this.score = score;
    }
}
