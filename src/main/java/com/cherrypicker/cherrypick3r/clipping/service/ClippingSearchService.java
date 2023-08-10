package com.cherrypicker.cherrypick3r.clipping.service;

import com.cherrypicker.cherrypick3r.clipping.domain.Clipping;
import com.cherrypicker.cherrypick3r.clipping.domain.ClippingRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ClippingSearchService {

    private final ShopRepository shopRepository;

    private final UserRepository userRepository;

    private final ClippingRepository clippingRepository;

    @Transactional
    public Long findClippingByUserEmailAndShopId(String userEmail, Long shopId) {
        Shop shop = shopRepository.findById(shopId).get();
        User user = userRepository.findByEmail(userEmail).get();

        Clipping clipping = clippingRepository.findByShopAndUser(shop, user);

        if (clipping != null) {
            return 1L;
        }
        else {
            return 0L;
        }
    }
}
