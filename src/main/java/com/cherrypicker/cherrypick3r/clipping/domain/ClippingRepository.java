package com.cherrypicker.cherrypick3r.clipping.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.user.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClippingRepository extends JpaRepository<Clipping, Long> {

    @Query("SELECT c FROM Clipping c JOIN FETCH c.user WHERE c.shop = :shop")
    List<Clipping> findAllByShop(@Param("shop") Shop shop);

    @Query("SELECT c FROM Clipping c JOIN FETCH c.shop WHERE c.user = :user")
    List<Clipping> findAllByUser(@Param("user") User user);

    Clipping findByShopAndUser(Shop shop, User user);
}
