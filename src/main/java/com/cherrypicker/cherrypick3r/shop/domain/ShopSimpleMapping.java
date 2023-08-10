package com.cherrypicker.cherrypick3r.shop.domain;

public interface ShopSimpleMapping {
    Long getId();
    String getName();
    String getCategory();
    String getAddress();
    String getOperatingHours();
    String getMainPhotoUrl();
}
/*
        this.shopId = shopDto.getId();
        this.shopName = shopDto.getName();
        this.shopCategory = "";
        this.shopAddress = shopDto.getAddress();
        this.operatingHours = shopDto.getOperatingHours();
        this.mainPhotoUrl = shopDto.getMainPhotoUrl1();
 */
