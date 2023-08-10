package com.cherrypicker.cherrypick3r.shop.dto;

import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;

@Data
public class ShopDto {

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
    public ShopDto(Long id, String phone, String name, String address, Double addressPointY, Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Long naverId, Long kakaoId, Tag tag, ShopClassify shopClassify) {
        this.id = id;
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
        this.tag = tag;
        this.shopClassify = shopClassify;
    }
}
