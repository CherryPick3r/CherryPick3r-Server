package com.cherrypicker.cherrypick3r.result.dto;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.Builder;
import lombok.Data;

@Data
public class ResultDto {

    private Long id;

    private Double similarity;

    private Double score;

    private Shop shop;

    private Game game;


    @Builder
    public ResultDto(Long id, Double similarity, Double score, Shop shop, Game game) {
        this.id = id;
        this.similarity = similarity;
        this.score = score;
        this.shop = shop;
        this.game = game;
    }

}
