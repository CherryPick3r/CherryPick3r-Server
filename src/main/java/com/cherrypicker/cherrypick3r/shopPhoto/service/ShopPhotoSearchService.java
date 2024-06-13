package com.cherrypicker.cherrypick3r.shopPhoto.service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shopPhoto.domain.ShopPhoto;
import com.cherrypicker.cherrypick3r.shopPhoto.domain.ShopPhotoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopPhotoSearchService {

    private final ShopPhotoRepository shopPhotoRepository;

    public ShopPhoto findShopPhotoById(Long id) {
        return shopPhotoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 가게 사진이 존재하지 않습니다."));
    }

    public List<ShopPhoto> findShopPhotosByShop(Shop shop) {
        return shopPhotoRepository.findAllByShop(shop);
    }


}
