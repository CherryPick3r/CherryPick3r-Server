package com.cherrypicker.cherrypick3r.preference.dto;

import com.cherrypicker.cherrypick3r.preference.domain.PreferenceGame;
import lombok.Builder;
import lombok.Data;

@Data
public class UserPreferenceResponse {

    public Long preferenceGameId;

    public Long totalRound;

    public Long curRound;

    public Long gameStatus;

    @Builder
    public UserPreferenceResponse(Long preferenceGameId, Long totalRound, Long curRound, Long gameStatus) {
        this.preferenceGameId = preferenceGameId;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.gameStatus = gameStatus;
    }

    public UserPreferenceResponse(PreferenceGame preferenceGame) {
        this.preferenceGameId = preferenceGame.getId();
        this.totalRound = preferenceGame.getTotalRound();
        this.curRound = preferenceGame.getCurRound();
        this.gameStatus = preferenceGame.getStatus();
    }

}
