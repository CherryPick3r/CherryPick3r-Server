package com.cherrypicker.cherrypick3r.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ShopDetailRequest {

    public Long shopId;

    public String userEmail;

    @Builder
    public ShopDetailRequest(Long shopId, String userEmail) {
        this.shopId = shopId;
        this.userEmail = userEmail;
    }

}
