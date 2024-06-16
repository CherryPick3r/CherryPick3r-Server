package com.cherrypicker.cherrypick3r.result.dto;

import com.cherrypicker.cherrypick3r.shop.dto.ShopSimple;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class ResultsSimpleResponse {
    public List<ShopSimple> shopSimples;

    @Builder
    public ResultsSimpleResponse(List<ShopSimple> shopSimples) {
        this.shopSimples = shopSimples;
    }
}
