package com.cherrypicker.cherrypick3r.shopCard.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.cherrypicker.cherrypick3r.clipping.service.ClippingSearchService;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopCard.domain.ShopCard;
import com.cherrypicker.cherrypick3r.shopCard.domain.ShopCardRedisRepository;
import com.cherrypicker.cherrypick3r.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopCardService {
    private final RedisKeyValueTemplate redisKeyValueTemplate;

    private final ShopCardRedisRepository shopCardRedisRepository;
    private final TagService tagService;
    private final ClippingSearchService clippingSearchService;

    @Transactional
    public ShopCard findShopCard(ShopDto shopDto, String userEmail) {
        String key = "shopcard::" + shopDto.getId().toString() + userEmail;
        Optional<ShopCard> shopCard = shopCardRedisRepository.findById(key);

        if (shopCard.isPresent()) {
            return shopCard.get();
        } else {
            ShopCard shopCardRet = new ShopCard(shopDto);

            shopCardRet.setShopCardId(key);
            shopCardRet.setTopTags(tagService.getTop5TagPairDtoByShop(shopDto));
            shopCardRet.setShopClipping(clippingSearchService.findClippingByUserEmailAndShopId(userEmail, shopDto.getId()));

            shopCardRedisRepository.save(shopCardRet);

            return shopCardRet;
        }
    }

    @Transactional
    public boolean updateShopCard(Long shopId, String userEmail, Long isClipping) {
        String key = "shopcard::" + shopId.toString() + userEmail;
        Optional<ShopCard> shopCard = shopCardRedisRepository.findById(key);

        if (shopCard.isPresent()) {
            ShopCard shopCardCur = shopCard.orElseThrow(() -> new NotFoundException("가게를 찾지 못했습니다."));
            shopCardCur.setShopClipping(isClipping);
            shopCardRedisRepository.save(shopCardCur);
            return true;
        } else {
            return false;
        }
    }

}
