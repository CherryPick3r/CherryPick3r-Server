package com.cherrypicker.cherrypick3r.menu.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Optional <Menu>> findAllByShop(Shop shop);
}
