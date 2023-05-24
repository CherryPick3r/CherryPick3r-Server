package com.cherrypicker.cherrypick3r.clipping.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ClippingUndoResponse {

    public Long shopId;

    public String userEmail;

    @Builder
    public ClippingUndoResponse(Long shopId, String userEmail) {
        this.shopId = shopId;
        this.userEmail = userEmail;
    }

}
