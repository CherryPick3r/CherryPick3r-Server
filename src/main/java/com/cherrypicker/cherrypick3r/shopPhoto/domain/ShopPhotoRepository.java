package com.cherrypicker.cherrypick3r.shopPhoto.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopPhotoRepository extends JpaRepository<ShopPhoto, Long> {
    List<ShopPhoto> findAllByShop(Shop shop);
}
