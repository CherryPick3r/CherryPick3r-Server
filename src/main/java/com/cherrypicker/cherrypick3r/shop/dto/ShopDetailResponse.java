package com.cherrypicker.cherrypick3r.shop.dto;

import com.cherrypicker.cherrypick3r.menu.dto.MenuSimple;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.tag.dto.TagPairDto;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopDetailResponse {

    public Long shopId;

    public String shopName;

    public String shopCategory;

    public String oneLineReview;

    public String shopAddress;

    public Long totalCherryPickCount;

    public String operatingHours;

    public List<TagPairDto> topTags;

    public List<MenuSimple> shopMenus;

    public List<String> shopMainPhotoURLs;

    public Long shopClipping;

    public Long shopNaverId;

    public Long shopKakaoId;

    @Builder
    public ShopDetailResponse(Long shopId, String shopName, String shopCategory, String oneLineReview, String shopAddress, Long totalCherryPickCount, String operatingHours, List<TagPairDto> topTags, List<MenuSimple> shopMenus, List<String> shopMainPhotoURLs, Long shopClipping, Long shopNaverId, Long shopKakaoId) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopCategory = shopCategory;
        this.oneLineReview = oneLineReview;
        this.shopAddress = shopAddress;
        this.totalCherryPickCount = totalCherryPickCount;
        this.operatingHours = operatingHours;
        this.topTags = topTags;
        this.shopMenus = shopMenus;
        this.shopMainPhotoURLs = shopMainPhotoURLs;
        this.shopClipping = shopClipping;
        this.shopNaverId = shopNaverId;
        this.shopKakaoId = shopKakaoId;
    }

    public ShopDetailResponse(ShopDto shopDto) {
        this.shopId = shopDto.getId();
        this.shopName = shopDto.getName();
        this.shopCategory = ""; //샵카테고리 어떻게 넣을지
        this.oneLineReview = shopDto.getOnelineReview();
        this.shopAddress = shopDto.getAddress();
        this.totalCherryPickCount = shopDto.getPickedCount();
        this.operatingHours = shopDto.getOperatingHours();
        this.topTags = null;
        this.shopMenus = null;
        this.shopMainPhotoURLs = null;
        this.shopClipping = null;
        this.shopNaverId = null;
        this.shopKakaoId = null;
    }
}