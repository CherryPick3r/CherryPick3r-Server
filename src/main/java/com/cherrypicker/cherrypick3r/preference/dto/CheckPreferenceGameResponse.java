package com.cherrypicker.cherrypick3r.preference.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CheckPreferenceGameResponse {

    public Long isPlayed;

    @Builder
    public CheckPreferenceGameResponse(Long isPlayed) {
        this.isPlayed = isPlayed;
    }

}
