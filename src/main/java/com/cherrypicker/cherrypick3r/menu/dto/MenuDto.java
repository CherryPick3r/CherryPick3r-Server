package com.cherrypicker.cherrypick3r.menu.dto;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.Builder;

import java.util.Optional;

public class MenuDto {
    private Long id;
    private String name;

    private Long price;

    private Shop shop;

    @Builder
    public MenuDto(Long id, String name, Long price, Shop shop){
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

}
