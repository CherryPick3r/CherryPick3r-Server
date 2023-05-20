package com.cherrypicker.cherrypick3r.menu.service;

import com.cherrypicker.cherrypick3r.menu.domain.Menu;
import com.cherrypicker.cherrypick3r.menu.domain.MenuRepository;
import com.cherrypicker.cherrypick3r.menu.dto.MenuDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu createMenu(String name, Long price, Shop shop){
        Menu menu = new Menu(name, price, shop);
        menuRepository.save(menu);
        return menu;
    }

    public List<Optional<Menu>> findMenusByShop(Shop shop){
        return menuRepository.findAllByShop(shop);

    }
    public List<Optional<MenuDto>> findMenuDtosByShop(Shop shop){
        List<Optional<Menu>> menuList = findMenusByShop(shop);
        List<Optional<MenuDto>> menuDtoList = menuList.stream()
                .map(optionalMenu -> optionalMenu.map(Menu::toDto))
                .collect(Collectors.toList());
        return menuDtoList;
    }

    public void deleteMenuById(Long id){
        Optional <Menu> Omenu = menuRepository.findById(id);
        Menu menu = Omenu.orElseThrow(() -> new RuntimeException("Menu is null"));
        menuRepository.delete(menu);
    }
    public void deleteMenusByShop(Shop shop){
        List <Optional<Menu>> menuList = findMenusByShop(shop);
        Menu menu;
        for(Optional <Menu> Omenu : menuList){
            menu = Omenu.orElseThrow(() -> new RuntimeException("Menu is null"));
            menuRepository.delete(menu);
        }
    }
}
