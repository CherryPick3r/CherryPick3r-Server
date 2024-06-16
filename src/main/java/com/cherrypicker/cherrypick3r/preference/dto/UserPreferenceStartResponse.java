package com.cherrypicker.cherrypick3r.preference.dto;

import com.cherrypicker.cherrypick3r.preference.domain.PreferenceGame;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class UserPreferenceStartResponse {

    public Long preferenceGameId;

    public Long totalRound;

    public Long curRound;

    public Long gameStatus;

    public List<PreferenceCard> preferenceCards;

    @Builder
    public UserPreferenceStartResponse(Long preferenceGameId, Long totalRound, Long curRound, Long gameStatus, List<PreferenceCard> preferenceCards) {
        this.preferenceGameId = preferenceGameId;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.gameStatus = gameStatus;
        this.preferenceCards = preferenceCards;
    }

    public UserPreferenceStartResponse(PreferenceGame preferenceGame, List<PreferenceCard> preferenceCards) {
        this.preferenceGameId = preferenceGame.getId();
        this.totalRound = preferenceGame.getTotalRound();
        this.curRound = preferenceGame.getCurRound();
        this.gameStatus = preferenceGame.getStatus();
        this.preferenceCards = preferenceCards;
    }

}
