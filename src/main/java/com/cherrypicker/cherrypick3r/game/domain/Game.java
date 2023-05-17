package com.cherrypicker.cherrypick3r.game.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection
    private List<Long> recommendedShopIds;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
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
        this.recommendedShopIds = new ArrayList<>();
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

    public void addRecommendedShopId(Long shopId) {
        this.recommendedShopIds.add(shopId);
    }

    public int findRecommendedShopIdIndexByShopId(Long shopId) {
        int len = this.recommendedShopIds.size();

        for (int i=0;i<len;i++) {
            if (recommendedShopIds.get(i).equals(shopId)) {
                return i;
            }
        }

        return -1;
    }
}
