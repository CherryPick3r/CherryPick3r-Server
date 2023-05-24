package com.cherrypicker.cherrypick3r.result.domain;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    Result findByShop(Shop shop);
    Result findByGame(Game game);

    Result findByGameAndShop(Game game, Shop shop);
    void deleteByShop(Shop shop);
    void deleteByGame(Game game);
}
