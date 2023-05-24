package com.cherrypicker.cherrypick3r.result.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopSimple;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ResultsSimpleResponse {
    public List<ShopSimple> shopSimples;

    @Builder
    public ResultsSimpleResponse(List<ShopSimple> shopSimples) {
        this.shopSimples = shopSimples;
    }
}
