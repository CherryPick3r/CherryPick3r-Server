package com.cherrypicker.cherrypick3r.clipping.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ClippingsSimpleRequest {

    public String userEmail;

    public Long gameCategory;

    @Builder
    public ClippingsSimpleRequest(String userEmail, Long gameCategory) {
        this.userEmail = userEmail;
        this.gameCategory = gameCategory;
    }

}
