package com.cherrypicker.cherrypick3r.clipping.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="CLIPPING_TABLE")
public class Clipping extends BaseTimeEntity {

    @Id
    @Column(name = "clipping_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private User user;

    @Builder
    public Clipping(Shop shop, User user) {
        this.shop = shop;
        this.user = user;
    }

}
