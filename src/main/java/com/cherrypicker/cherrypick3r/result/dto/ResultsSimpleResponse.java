package com.cherrypicker.cherrypick3r.result.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopSimpleDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ResultsSimpleResponse {
    public List<ShopSimpleDto> shopSimpleDtos;

    @Builder
    public ResultsSimpleResponse(List<ShopSimpleDto> shopSimpleDtos) {
        this.shopSimpleDtos = shopSimpleDtos;
    }
}
