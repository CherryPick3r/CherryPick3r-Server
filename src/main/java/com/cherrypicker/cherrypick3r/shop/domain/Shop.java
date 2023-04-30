package com.cherrypicker.cherrypick3r.shop.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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

    @Column(name = "shop_like_count")
    private Long likeCount;

    @Column(name = "shop_picked_count")
    private Long pickedCount;

    @Column(name = "shop_operating_hours")
    private String operatingHours;

    @Column(name = "shop_oneline_review")
    private String onelineReview;

    @Column(name = "shop_main_photo_url_1")
    private String mainPhotoUrl1;

    @Column(name = "shop_main_photo_url_2")
    private String mainPhotoUrl2;

    @Builder
    public Shop(String phone, String name, String address, Double addressPointY, Double addressPointX, Long likeCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.addressPointY = addressPointY;
        this.addressPointX = addressPointX;
        this.likeCount = likeCount;
        this.pickedCount = pickedCount;
        this.operatingHours = operatingHours;
        this.onelineReview = onelineReview;
        this.mainPhotoUrl1 = mainPhotoUrl1;
        this.mainPhotoUrl2 = mainPhotoUrl2;
    }
}
