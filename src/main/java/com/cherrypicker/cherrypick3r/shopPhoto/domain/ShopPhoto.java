package com.cherrypicker.cherrypick3r.shopPhoto.domain;

import com.cherrypicker.cherrypick3r.global.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shopPhoto.dto.ShopPhotoDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="SHOP_PHOTO_TABLE")
public class ShopPhoto extends BaseTimeEntity {

    @Id
    @Column(name = "shop_photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_photo_url", length = 1000)
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Builder
    public ShopPhoto(String photoUrl, Shop shop) {
        this.photoUrl = photoUrl;
        this.shop = shop;
    }

    public ShopPhotoDto toDto(){
        return ShopPhotoDto.builder()
                .photoUrl(this.photoUrl)
                .shop(this.shop)
                .build();

    }

}
