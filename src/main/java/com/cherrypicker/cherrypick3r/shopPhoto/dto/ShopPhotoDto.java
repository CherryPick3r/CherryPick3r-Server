package com.cherrypicker.cherrypick3r.shopPhoto.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.Builder;

public class ShopPhotoDto {
    private Long id;
    private String photoUrl;

    private Shop shop;

    @Builder
    public ShopPhotoDto(String photoUrl, Shop shop) {
        this.photoUrl = photoUrl;
        this.shop = shop;
    }

    public Long getId(){
        return this.id;
    }
}
