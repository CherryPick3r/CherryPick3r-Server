package com.cherrypicker.cherrypick3r.shopRedis.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("shop")
public class ShopRedis {
    @Id
    private Long id;

    private String phone;

    private String name;

    private String address;

    private Double addressPointY;

    private Double addressPointX;

    private Long clippingCount;

    private Long pickedCount;

    private String operatingHours;

    private String onelineReview;

    private String mainPhotoUrl1;

    private String mainPhotoUrl2;

    private Long naverId;

    private Long kakaoId;

    private Tag tag;

    private ShopClassify shopClassify;

    @Builder
    public ShopRedis(String phone, String name, String address, Double addressPointY, Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Long naverId, Long kakaoId, Tag tag, ShopClassify shopClassify) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.addressPointY = addressPointY;
        this.addressPointX = addressPointX;
        this.clippingCount = clippingCount;
        this.pickedCount = pickedCount;
        this.operatingHours = operatingHours;
        this.onelineReview = onelineReview;
        this.mainPhotoUrl1 = mainPhotoUrl1;
        this.mainPhotoUrl2 = mainPhotoUrl2;
        this.naverId = naverId;
        this.kakaoId = kakaoId;
        this.shopClassify = shopClassify;
        this.tag = tag;
    }

    public ShopRedis(Shop shop) {
        this.phone = shop.getPhone();
        this.name = shop.getName();
        this.address = shop.getAddress();
        this.addressPointY = shop.getAddressPointY();
        this.addressPointX = shop.getAddressPointX();
        this.clippingCount = shop.getClippingCount();
        this.pickedCount = shop.getPickedCount();
        this.operatingHours = shop.getOperatingHours();
        this.onelineReview = shop.getOnelineReview();
        this.mainPhotoUrl1 = shop.getMainPhotoUrl1();
        this.mainPhotoUrl2 = shop.getMainPhotoUrl2();
        this.naverId = shop.getNaverId();
        this.kakaoId = shop.getKakaoId();
        this.shopClassify = shop.getShopClassify();
        this.tag = shop.getTag();
    }

    public ShopDto toDto() {
        return ShopDto.builder()
                .id(this.id)
                .phone(this.phone)
                .name(this.name)
                .address(this.address)
                .addressPointX(this.addressPointX)
                .addressPointY(this.addressPointY)
                .clippingCount(this.clippingCount)
                .pickedCount(this.pickedCount)
                .operatingHours(this.operatingHours)
                .onelineReview(this.onelineReview)
                .mainPhotoUrl1(this.mainPhotoUrl1)
                .mainPhotoUrl2(this.mainPhotoUrl2)
                .naverId(naverId)
                .kakaoId(kakaoId)
                .tag(this.tag)
                .shopClassify(this.shopClassify)
                .build();
    }


    public void increasePickedCount() {
        this.pickedCount++;

        return ;
    }

    public void decreasePickedCount() {
        this.pickedCount--;

        return ;
    }

    public void mappingShopClassify(ShopClassify shopClassify) {
        this.shopClassify = shopClassify;
        return ;
    }
}
