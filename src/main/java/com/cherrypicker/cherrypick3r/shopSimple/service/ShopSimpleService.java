package com.cherrypicker.cherrypick3r.shopSimple.service;

import com.cherrypicker.cherrypick3r.shop.Service.ShopSearchService;
import com.cherrypicker.cherrypick3r.shop.Service.ShopService;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopSimple.domain.ShopSimple;
import com.cherrypicker.cherrypick3r.shopSimple.domain.ShopSimpleRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopSimpleService {
    private final ShopSimpleRedisRepository shopSimpleRedisRepository;

    private final ShopSearchService shopSearchService;

    @Transactional
    public ShopSimple findShopSimple(Long shopId) {
        String key = "shopsimple::" + shopId.toString();
        Optional<ShopSimple> shopSimple = shopSimpleRedisRepository.findById(key);

        if (shopSimple.isPresent()) {
            return shopSimple.get();
        } else {
            ShopDto shopDto = shopSearchService.findShopByShopId(shopId);

            ShopSimple shopSimpleRet = new ShopSimple(shopDto);

            shopSimpleRet.setShopSimpleId(key);

            shopSimpleRedisRepository.save(shopSimpleRet);

            return shopSimpleRet;
        }
    }
}
