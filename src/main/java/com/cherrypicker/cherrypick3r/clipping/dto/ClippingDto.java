package com.cherrypicker.cherrypick3r.clipping.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;

public class ClippingDto {
    private Long id;
    private Shop shop;
    private User user;

    @Builder
    public ClippingDto(Long id, Shop shop, User user) {
        this.id = id;
        this.shop = shop;
        this.user = user;
    }

}

