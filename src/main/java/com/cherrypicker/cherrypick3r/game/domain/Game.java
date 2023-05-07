package com.cherrypicker.cherrypick3r.game.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="GAME_TABLE")
public class Game extends BaseTimeEntity {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_total_round")
    private Long totalRound;

    @Column(name = "game_cur_round")
    private Long curRound;

    // 1:시작 전, 2:진행 중, 3:종료
    @Column(name = "game_status")
    private Long status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private User user;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    public Game(Long totalRound, Long curRound, Long status, User user, Tag tag) {
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.status = status;
        this.user = user;
        this.tag = tag;
    }

    public GameDto toDto() {
        return GameDto.builder()
                .id(this.id)
                .totalRound(this.totalRound)
                .curRound(this.curRound)
                .status(this.status)
                .user(this.user)
                .tag(this.tag)
                .build();
    }
}
