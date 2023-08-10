package com.cherrypicker.cherrypick3r.menu.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.menu.dto.MenuSimple;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="MENU_TABLE")
public class Menu extends BaseTimeEntity {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "menu_price")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Builder
    public Menu(String name, Long price, Shop shop) {
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public MenuSimple getSimple(Menu menu) {
        return MenuSimple.builder()
                .name(menu.getName())
                .price(menu.getPrice())
                .build();
    }

    public List<MenuSimple> getSimpleList(List<Menu> menus) {
        List<MenuSimple> menuSimples = new ArrayList<>();
        for (Menu menu : menus) {
            menuSimples.add(getSimple(menu));
        }
        return menuSimples;
    }
}
