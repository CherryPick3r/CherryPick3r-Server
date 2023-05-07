package com.cherrypicker.cherrypick3r.result.dto;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.Builder;
import lombok.Data;

@Data
public class ResultDto {

    private Long id;

    private Shop shop;

    private Game game;

    @Builder
    public ResultDto(Long id, Shop shop, Game game) {
        this.id = id;
        this.shop = shop;
        this.game = game;
    }

}
