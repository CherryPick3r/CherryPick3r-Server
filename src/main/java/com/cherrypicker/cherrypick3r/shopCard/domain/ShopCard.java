package com.cherrypicker.cherrypick3r.shopCard.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.tag.dto.TagPairDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("shopcard")
public class ShopCard {

    @Id
    public String shopCardId; // "shopId" + "useremail" = shopCardId

    public Long shopId;

    public String shopMainPhoto1;

    public String shopMainPhoto2;

    public String shopName;

    public String shopCategory;

    public String oneLineReview;

    public List<TagPairDto> topTags;

    public Long shopClipping;

    @Builder
    public ShopCard(String shopCardId, Long shopId, String shopMainPhoto1, String shopMainPhoto2, String shopName, String shopCategory, String oneLineReview, List<TagPairDto> topTags, Long shopClipping) {
        this.shopCardId = shopCardId;
        this.shopId = shopId;
        this.shopMainPhoto1 = shopMainPhoto1;
        this.shopMainPhoto2 = shopMainPhoto2;
        this.shopName = shopName;
        this.shopCategory = shopCategory;
        this.oneLineReview = oneLineReview;
        this.topTags = topTags;
        this.shopClipping = shopClipping;
    }

    public ShopCard(ShopDto shopDto) {
        this.shopCardId = "";
        this.shopId = shopDto.getId();
        this.shopMainPhoto1 = shopDto.getMainPhotoUrl1();
        this.shopMainPhoto2 = shopDto.getMainPhotoUrl2();
        this.shopName = shopDto.getName();
        this.shopCategory = ""; // 카테고리 어떻게 채워줄까
        this.oneLineReview = shopDto.getOnelineReview();
        this.topTags = null;
        this.shopClipping = null;
    }
}
