package com.cherrypicker.cherrypick3r.shopPhoto.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shopPhoto.dto.ShopPhotoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="SHOP_PHOTO_TABLE")
public class ShopPhoto extends BaseTimeEntity {

    @Id
    @Column(name = "shop_photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_photo_url")
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
