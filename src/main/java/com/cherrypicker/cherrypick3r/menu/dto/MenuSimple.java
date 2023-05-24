package com.cherrypicker.cherrypick3r.menu.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MenuSimple {

    public String name;

    public Long price;

    @Builder
    public MenuSimple(String name, Long price) {
        this.name = name;
        this.price = price;
    }

}
