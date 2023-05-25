package com.cherrypicker.cherrypick3r.result.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="RESULT_TABLE")
public class Result extends BaseTimeEntity {
    @Id
    @Column(name = "result_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "result_similarity")
    private Double similarity;

    @Column(name = "result_score")
    private Double score;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "game_id")
    private Game game;

    @Builder
    public Result(Double similarity, Double score, Shop shop, Game game) {
        this.similarity = similarity;
        this.score = score;
        this.shop = shop;
        this.game = game;
    }

    public ResultDto toDto() {
        return ResultDto.builder()
                .id(this.id)
                .similarity(this.similarity)
                .score(this.score)
                .shop(this.shop)
                .game(this.game)
                .build();
    }
}
