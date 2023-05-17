package com.cherrypicker.cherrypick3r.shop.dto;

import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import lombok.Builder;
import lombok.Data;

@Data
public class ShopSimilarityDto {
    private ShopDto shopDto;

    private Double similarity;

    public ShopSimilarityDto(ShopDto shopDto, Double similarity) {
        this.shopDto = shopDto;
        this.similarity = similarity;
    }
}
