package com.cherrypicker.cherrypick3r.shop.domain;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findByName(String name);

    // 랜덤한 한 개의 가게를 뽑는다.
    @Query(value = "SELECT * FROM shop_table ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Shop> findRandomShop();

    // 랜덤한 5개의 가게를 뽑는다.
    @Query(value = "SELECT * FROM shop_table ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Shop> findRandomShops();
}
