package com.cherrypicker.cherrypick3r.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ShopSimple {

    public Long shopId;

    public String shopName;

    public String shopCategory;

    public String shopAddress;

    public String operatingHours;

    public String mainPhotoUrl;

    @Builder
    public ShopSimple(Long shopId, String shopName, String shopCategory, String shopAddress, String operatingHours, String mainPhotoUrl) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopCategory = shopCategory;
        this.shopAddress = shopAddress;
        this.operatingHours = operatingHours;
        this.mainPhotoUrl = mainPhotoUrl;
    }

}
