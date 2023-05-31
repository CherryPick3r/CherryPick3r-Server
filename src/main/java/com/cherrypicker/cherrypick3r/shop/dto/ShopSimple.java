package com.cherrypicker.cherrypick3r.shop.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class ShopSimple {

    public Long shopId;

    public String shopName;

    public String shopCategory;

    public String shopAddress;

    public String operatingHours;

    public String mainPhotoUrl;

    private LocalDateTime dateTime;

    @Builder
    public ShopSimple(Long shopId, String shopName, String shopCategory, String shopAddress, String operatingHours, String mainPhotoUrl, LocalDateTime dateTime) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopCategory = shopCategory;
        this.shopAddress = shopAddress;
        this.operatingHours = operatingHours;
        this.mainPhotoUrl = mainPhotoUrl;
        this.dateTime = dateTime;
    }

    public ShopSimple(Shop shop, LocalDateTime dateTime) {
        this.shopId = shop.getId();
        this.shopName = shop.getName();
        this.shopCategory = "";
        this.shopAddress = shop.getAddress();
        this.operatingHours = shop.getOperatingHours();
        this.mainPhotoUrl = shop.getMainPhotoUrl1();
        this.dateTime = dateTime;
    }

    public ShopSimple(ShopDto shopDto, LocalDateTime dateTime) {
        this.shopId = shopDto.getId();
        this.shopName = shopDto.getName();
        this.shopCategory = "";
        this.shopAddress = shopDto.getAddress();
        this.operatingHours = shopDto.getOperatingHours();
        this.mainPhotoUrl = shopDto.getMainPhotoUrl1();
        this.dateTime = dateTime;
    }

}
