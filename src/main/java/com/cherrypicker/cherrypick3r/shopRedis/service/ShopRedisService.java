package com.cherrypicker.cherrypick3r.shopRedis.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopDetail.domain.ShopDetail;
import com.cherrypicker.cherrypick3r.shopRedis.domain.ShopRedis;
import com.cherrypicker.cherrypick3r.shopRedis.domain.ShopRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopRedisService {

    private final ShopRedisRepository shopRedisRepository;

    private final ShopRepository shopRepository;

    @Transactional
    public ShopRedis findShop(Long shopId) {
        Long key = shopId;
        Optional<ShopRedis> shopRedis = shopRedisRepository.findById(key);

        if (shopRedis.isPresent()) {
            return shopRedis.get();
        } else {
            Shop shop = shopRepository.findById(key).orElseThrow(() -> new NotFoundException("존재하지 않는 가게입니다."));
            ShopRedis shopRedisRet = new ShopRedis(shop);

            shopRedisRet.setId(key);

            shopRedisRepository.save(shopRedisRet);

            return shopRedisRet;
        }
    }

}
