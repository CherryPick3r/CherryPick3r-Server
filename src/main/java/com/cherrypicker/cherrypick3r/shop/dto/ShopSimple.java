package com.cherrypicker.cherrypick3r.shop.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
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

    public ShopSimple(Shop shop) {
        this.shopId = shop.getId();
        this.shopName = shop.getName();
        this.shopCategory = "";
        this.shopAddress = shop.getAddress();
        this.operatingHours = shop.getOperatingHours();
        this.mainPhotoUrl = shop.getMainPhotoUrl1();
    }

    public ShopSimple(ShopDto shopDto) {
        this.shopId = shopDto.getId();
        this.shopName = shopDto.getName();
        this.shopCategory = "";
        this.shopAddress = shopDto.getAddress();
        this.operatingHours = shopDto.getOperatingHours();
        this.mainPhotoUrl = shopDto.getMainPhotoUrl1();
    }

}
