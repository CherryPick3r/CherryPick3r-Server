package com.cherrypicker.cherrypick3r.game.dto;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameSimple {

    private Long GameId;

    private Long totalRound;

    private Long curRound;

    // 1:시작 전, 2:진행 중, 3:종료
    private Long status;

    private String userEmail;

    private Long tagId;

    private List<Long> shopIds;

    private Long resultShopId;

    private Double score;

    private Double similarity;

    public GameSimple(Long gameId, Long totalRound, Long curRound, Long status, String userEmail, Long tagId, List<Long> shopIds, Long resultShopId) {
        this.GameId = gameId;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.status = status;
        this.userEmail = userEmail;
        this.tagId = tagId;
        this.shopIds = shopIds;
        this.resultShopId = resultShopId;
    }

    public GameSimple(GameResponse gameResponse) {
        this.GameId = gameResponse.getGameDto().getId();
        this.totalRound = gameResponse.gameDto.getTotalRound();
        this.curRound = gameResponse.gameDto.getCurRound();
        this.status = gameResponse.gameDto.getStatus();
        this.userEmail = gameResponse.gameDto.getUser().getEmail();
        this.tagId = gameResponse.gameDto.getTag().getId();
        if (gameResponse.resultDto != null) {
            this.resultShopId = gameResponse.resultDto.getId();
            this.score = gameResponse.getResultDto().getScore();
            this.similarity = gameResponse.getResultDto().getSimilarity();
        }
        if (gameResponse.shopDtos != null && gameResponse.shopDtos.size() == 3){
            this.shopIds = new ArrayList<>();
            for (int i=0;i<3;i++) {
                this.shopIds.add(gameResponse.shopDtos.get(i).getId());
            }
        }
    }
}
