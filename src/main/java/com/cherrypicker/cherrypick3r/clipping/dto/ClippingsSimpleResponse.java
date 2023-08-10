package com.cherrypicker.cherrypick3r.clipping.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopSimpleDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ClippingsSimpleResponse {

    public List<ShopSimpleDto> shopSimpleDtos;

    @Builder
    public ClippingsSimpleResponse(List<ShopSimpleDto> shopSimpleDtos) {
        this.shopSimpleDtos = shopSimpleDtos;
    }

}
