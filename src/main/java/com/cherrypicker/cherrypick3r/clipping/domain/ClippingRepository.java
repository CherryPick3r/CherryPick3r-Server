package com.cherrypicker.cherrypick3r.clipping.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClippingRepository extends JpaRepository<Clipping, Long> {

    List<Clipping> findAllByShop(Shop shop);
    List<Clipping> findAllByUser(User user);


}
