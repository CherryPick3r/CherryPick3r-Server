package com.cherrypicker.cherrypick3r.shop.service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopSearchService {

    private final ShopRepository shopRepository;

    public Shop findShopById(Long id) {
        return shopRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 가게가 존재하지 않습니다."));
    }

}
