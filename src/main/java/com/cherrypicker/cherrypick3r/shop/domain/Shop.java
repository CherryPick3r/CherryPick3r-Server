package com.cherrypicker.cherrypick3r.shop.domain;

import com.cherrypicker.cherrypick3r.global.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name="SHOP_TABLE")
public class Shop extends BaseTimeEntity {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_phone")
    private String phone;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "shop_address")
    private String address;

    @Column(name = "shop_address_point_y")
    private Double addressPointY;

    @Column(name = "shop_address_point_x")
    private Double addressPointX;

    @Column(name = "shop_clipping_count")
    private Long clippingCount;

    @Column(name = "shop_picked_count")
    private Long pickedCount;

    @Column(name = "shop_operating_hours")
    private String operatingHours;

    @Column(name = "shop_oneline_review")
    private String onelineReview;

    @Column(name = "shop_main_photo_url_1", length = 1000)
    private String mainPhotoUrl1;

    @Column(name = "shop_main_photo_url_2", length = 1000)
    private String mainPhotoUrl2;

    @Column(name = "shop_naver_id")
    private Long naverId;

    @Column(name = "shop_kakao_id")
    private Long kakaoId;


    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToOne(mappedBy = "shop")
    @JsonManagedReference
    private ShopClassify shopClassify;


    @Builder
    public Shop(String phone, String name, String address, Double addressPointY, Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Long naverId, Long kakaoId, Tag tag) {
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
        this.shopClassify = null;
        this.tag = tag;
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
