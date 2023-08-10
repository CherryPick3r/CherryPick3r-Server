package com.cherrypicker.cherrypick3r.shop.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shopSimple.domain.ShopSimple;
import lombok.Builder;
import lombok.Data;

@Data
public class ShopSimpleDto {

    public Long shopId;

    public String shopName;

    public String shopCategory;

    public String shopAddress;

    public String operatingHours;

    public String mainPhotoUrl;

    @Builder
    public ShopSimpleDto(Long shopId, String shopName, String shopCategory, String shopAddress, String operatingHours, String mainPhotoUrl) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopCategory = shopCategory;
        this.shopAddress = shopAddress;
        this.operatingHours = operatingHours;
        this.mainPhotoUrl = mainPhotoUrl;
    }

    public ShopSimpleDto(Shop shop) {
        this.shopId = shop.getId();
        this.shopName = shop.getName();
        this.shopCategory = "";
        this.shopAddress = shop.getAddress();
        this.operatingHours = shop.getOperatingHours();
        this.mainPhotoUrl = shop.getMainPhotoUrl1();
    }

    public ShopSimpleDto(ShopDto shopDto) {
        this.shopId = shopDto.getId();
        this.shopName = shopDto.getName();
        this.shopCategory = "";
        this.shopAddress = shopDto.getAddress();
        this.operatingHours = shopDto.getOperatingHours();
        this.mainPhotoUrl = shopDto.getMainPhotoUrl1();
    }

    public ShopSimpleDto(ShopSimple shopSimple) {
        this.shopId = shopSimple.getShopId();
        this.shopName = shopSimple.getShopName();
        this.shopCategory = shopSimple.getShopCategory();
        this.shopAddress = shopSimple.getShopAddress();
        this.operatingHours = shopSimple.getOperatingHours();
        this.mainPhotoUrl = shopSimple.getMainPhotoUrl();
    }

}
