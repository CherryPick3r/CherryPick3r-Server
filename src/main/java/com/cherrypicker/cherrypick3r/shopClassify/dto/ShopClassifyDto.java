package com.cherrypicker.cherrypick3r.shopClassify.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class ShopClassifyDto {

    public Long id;

    private List<Long> shopClassifyTags;
    private Shop shop;

    @Builder
    public ShopClassifyDto(Long id, List<Long> shopClassifyTags, Shop shop)  {
        this.id = id;
        this.shopClassifyTags = shopClassifyTags;
        this.shop = shop;
    }
}
