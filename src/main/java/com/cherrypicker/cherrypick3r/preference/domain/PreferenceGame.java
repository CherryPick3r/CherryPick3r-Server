package com.cherrypicker.cherrypick3r.preference.domain;

import com.cherrypicker.cherrypick3r.user.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="PREFERENCE_GAME_TABLE")
public class PreferenceGame {

    @Id
    @Column(name = "preference_game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preference_game_total_round")
    private Long totalRound;

    @Column(name = "preference_game_cur_round")
    private Long curRound;

    // 1:시작 전, 2:진행 중, 3:종료
    @Column(name = "preference_game_status")
    private Long status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_email")
    private User user;

    @ElementCollection
    private List<Long> recommendedShopIds;

    @Builder
    public PreferenceGame(Long totalRound, Long curRound, Long status, User user) {
        this.totalRound = totalRound;
        this.curRound = curRound;
        this.status = status;
        this.user = user;
        this.recommendedShopIds = new ArrayList<>();
    }

    public void setStatusStart() {
        this.status = 2L; // 2:게임 진행 중
    }

    public void setStatusEnd() {
        this.status = 3L; // 3:게임 종료
    }

    public void increaseCurRound() {
        this.curRound++;
    }

    public void decreaseCurRound() {
        this.curRound--;
    }

}
