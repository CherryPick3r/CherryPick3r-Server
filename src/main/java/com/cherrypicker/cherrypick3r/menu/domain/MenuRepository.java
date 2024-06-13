package com.cherrypicker.cherrypick3r.menu.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByShop(Shop shop);
}
