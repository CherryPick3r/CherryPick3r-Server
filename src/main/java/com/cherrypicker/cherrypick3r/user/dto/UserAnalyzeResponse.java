package com.cherrypicker.cherrypick3r.user.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopSimpleDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class UserAnalyzeResponse {

    public String userNickname;

    public Double userPercentile;

    // 보류: 유저 분류

    // 보류: 유저 분석 그래프에 넣을 값

    public Long cherrypickClippingTotalCount;

    public Long cherrypickCount;

    public List<ShopSimpleDto> recentCherrypickShops;

    public Long clippingCount;

    public List<ShopSimpleDto> recentClippingShops;

    public List<String> weeklyTags;

    @Builder
    public UserAnalyzeResponse(String userNickname, Double userPercentile, Long cherrypickClippingTotalCount, Long cherrypickCount, List<ShopSimpleDto> recentCherrypickShops, Long clippingCount, List<ShopSimpleDto> recentClippingShops, List<String> weeklyTags) {
        this.userNickname = userNickname;
        this.userPercentile = userPercentile;
        this.cherrypickClippingTotalCount = cherrypickClippingTotalCount;
        this.cherrypickCount = cherrypickCount;
        this.recentCherrypickShops = recentCherrypickShops;
        this.clippingCount = clippingCount;
        this.recentClippingShops = recentClippingShops;
        this.weeklyTags = weeklyTags;
    }

}
