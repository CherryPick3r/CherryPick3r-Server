package com.cherrypicker.cherrypick3r.game.dto;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
public class GameDto {
    private Long id;

    private Long totalRound;

    private Long curRound;

    // 1:시작 전, 2:진행 중, 3:종료
    private Long status;

    private User user;

    private Tag tag;

    @Builder
    public GameDto(Long id, Long totalRound, Long curRound, Long status, User user, Tag tag) {
        this.id = id;
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.status = status;
        this.user = user;
        this.tag = tag;
    }
}
