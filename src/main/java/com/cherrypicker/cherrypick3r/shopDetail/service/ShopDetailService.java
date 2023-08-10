package com.cherrypicker.cherrypick3r.shopDetail.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.cherrypicker.cherrypick3r.clipping.service.ClippingSearchService;
import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import com.cherrypicker.cherrypick3r.menu.service.MenuService;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDetailResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopCard.domain.ShopCard;
import com.cherrypicker.cherrypick3r.shopDetail.domain.ShopDetail;
import com.cherrypicker.cherrypick3r.shopDetail.domain.ShopDetailRedisRepository;
import com.cherrypicker.cherrypick3r.shopPhoto.service.ShopPhotoService;
import com.cherrypicker.cherrypick3r.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopDetailService {

    private final RedisKeyValueTemplate redisKeyValueTemplate;
    private final ShopDetailRedisRepository shopDetailRedisRepository;

    private final TagService tagService;

    private final MenuService menuService;

    private final ShopPhotoService shopPhotoService;

    private final ClippingSearchService clippingSearchService;


    @Transactional
    public ShopDetail findShopDetail(ShopDto shopDto, String userEmail) {
        String key = "shopdetail::" + shopDto.getId().toString() + userEmail;
        Optional<ShopDetail> shopDetail = shopDetailRedisRepository.findById(key);

        if (shopDetail.isPresent()) {
            return shopDetail.get();
        } else {
            ShopDetail shopDetailRet = new ShopDetail(shopDto);

            shopDetailRet.setShopDetailId(key);
            shopDetailRet.setTopTags(tagService.getTop5TagPairDtoByShop(shopDto));
            shopDetailRet.setShopMenus(menuService.findAllMenuSimpleByShopDto(shopDto));
            shopDetailRet.setShopMainPhotoURLs(shopPhotoService.findShopPhotoURLsByShopDto(shopDto));
            shopDetailRet.setShopClipping(clippingSearchService.findClippingByUserEmailAndShopId(userEmail, shopDto.getId()));

            shopDetailRedisRepository.save(shopDetailRet);

            return shopDetailRet;
        }
    }

    @Transactional
    public boolean updateShopDetail(Long shopId, String userEmail, Long isClipping) {
        String key = "shopdetail::" + shopId.toString() + userEmail;
        Optional<ShopDetail> shopDetail = shopDetailRedisRepository.findById(key);

        if (shopDetail.isPresent()) {
            ShopDetail shopDetailCur = shopDetail.orElseThrow(() -> new NotFoundException("가게를 찾지 못했습니다."));
            shopDetailCur.setShopClipping(isClipping);
            shopDetailRedisRepository.save(shopDetailCur);
            return true;
        } else {
            return false;
        }
    }
}
