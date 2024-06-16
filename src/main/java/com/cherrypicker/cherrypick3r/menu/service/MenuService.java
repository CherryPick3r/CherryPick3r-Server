package com.cherrypicker.cherrypick3r.menu.service;

import com.cherrypicker.cherrypick3r.menu.domain.Menu;
import com.cherrypicker.cherrypick3r.menu.domain.MenuRepository;
import com.cherrypicker.cherrypick3r.menu.dto.MenuSimple;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shop.service.ShopSearchService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    private final ShopSearchService shopSearchService;

    @Transactional
    public List<MenuSimple> findAllMenuSimpleByShopDto(ShopDto shopDto) {
        Shop shop = shopSearchService.findShopById(shopDto.getId());

        List<Menu> menus = menuRepository.findAllByShop(shop);

        List<MenuSimple> menuSimples = new ArrayList<>();
        for (Menu menu : menus) {
            menuSimples.add(MenuSimple.builder()
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build());
        }

        return menuSimples;
    }

}
