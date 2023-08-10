package com.cherrypicker.cherrypick3r.menu.service;

import com.cherrypicker.cherrypick3r.menu.domain.Menu;
import com.cherrypicker.cherrypick3r.menu.domain.MenuRepository;
import com.cherrypicker.cherrypick3r.menu.dto.MenuSimple;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    private final ShopRepository shopRepository;

    @Transactional
    public List<MenuSimple> findAllMenuSimpleByShopDto(ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();

        List<Menu> menus = menuRepository.findAllByShop(shop);

        List<MenuSimple> menuSimples = new Menu().getSimpleList(menus);

        return menuSimples;
    }

}
