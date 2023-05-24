package com.cherrypicker.cherrypick3r.result.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResultsSimpleRequest {

    public String userEmail;

    public Long gameCategory;

    @Builder
    public ResultsSimpleRequest(String userEmail, Long gameCategory) {
        this.userEmail = userEmail;
        this.gameCategory = gameCategory;
    }

}
