package com.cherrypicker.cherrypick3r.clipping.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopSimple;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ClippingsSimpleResponse {

    public List<ShopSimple> shopSimples;

    @Builder
    public ClippingsSimpleResponse(List<ShopSimple> shopSimples) {
        this.shopSimples = shopSimples;
    }

}
