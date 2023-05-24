package com.cherrypicker.cherrypick3r.clipping.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ClippingDoResponse {

    public Long clippingId;

    public Long shopId;

    public String userEmail;

    @Builder
    public ClippingDoResponse(Long clippingId, Long shopId, String userEmail) {
        this.clippingId = clippingId;
        this.shopId = shopId;
        this.userEmail = userEmail;
    }

}
