package com.cherrypicker.cherrypick3r.clipping.service;

import com.cherrypicker.cherrypick3r.clipping.domain.Clipping;
import com.cherrypicker.cherrypick3r.clipping.domain.ClippingRepository;
import com.cherrypicker.cherrypick3r.clipping.dto.ClippingDoResponse;
import com.cherrypicker.cherrypick3r.clipping.dto.ClippingUndoResponse;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopSimpleDto;
import com.cherrypicker.cherrypick3r.shopCard.service.ShopCardService;
import com.cherrypicker.cherrypick3r.shopDetail.service.ShopDetailService;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClippingService {

    private final ClippingRepository clippingRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    private final ShopCardService shopCardService;

    private final ShopDetailService shopDetailService;

    @Transactional
    public Clipping createClipping(Shop shop, User user)
    {
        Clipping clip = new Clipping(shop, user);
        clippingRepository.save(clip);
        return clip;
    }

    @Transactional
    public ClippingDoResponse createClipping(Long shopId, String userEmail)
    {
        Shop shop = shopRepository.findById(shopId).get();
        User user = userRepository.findByEmail(userEmail).get();
        Clipping clipping = createClipping(shop, user);

        ClippingDoResponse clippingDoResponse = ClippingDoResponse.builder()
                .clippingId(clipping.getId())
                .shopId(shopId)
                .userEmail(userEmail)
                .build();

        shopCardService.updateShopCard(shopId, userEmail, 1L);
        shopDetailService.updateShopDetail(shopId, userEmail, 1L);

        return clippingDoResponse;
    }

    @Transactional
    public ClippingUndoResponse deleteClipping(Long shopId, String userEmail)
    {
        Shop shop = shopRepository.findById(shopId).get();
        User user = userRepository.findByEmail(userEmail).get();
        Clipping clipping = clippingRepository.findByShopAndUser(shop, user);

        clippingRepository.delete(clipping);

        ClippingUndoResponse clippingUndoResponse = ClippingUndoResponse.builder()
                .shopId(shopId)
                .userEmail(userEmail)
                .build();

        shopCardService.updateShopCard(shopId, userEmail, 0L);
        shopDetailService.updateShopDetail(shopId, userEmail, 0L);

        return clippingUndoResponse;
    }

    @Transactional
    public List<ShopDto> findClippingShopByUser(User user)
    {
        List <Clipping> clippingList = clippingRepository.findAllByUser(user);
        List <ShopDto> clippedShopByUser =  new ArrayList<>();


        for(Clipping clip : clippingList){
            clippedShopByUser.add(clip.getShop().toDto());
        }
        return clippedShopByUser;
    }

    @Transactional
    public List<UserDto> findClippingUserByShop(Shop shop)
    {
        List <Clipping> clippingList = clippingRepository.findAllByShop(shop);
        List <UserDto> clippedUserByShop = new ArrayList<>();
        for(Clipping clip : clippingList){
            clippedUserByShop.add(clip.getUser().toDto());
        }
        return clippedUserByShop;
    }

    @Transactional
    public Integer findClippingShopNumberByShop(User user){
        return findClippingShopByUser(user).size();
    }

    @Transactional
    public Integer findClippingUserNumberByShop(User user){
        return findClippingShopByUser(user).size();
    }


    @Transactional
    public Long findClippingCountByUserEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        List<Clipping> clippings = clippingRepository.findAllByUser(user);

        return Long.valueOf(clippings.size());
    }

    @Transactional
    public List<ShopSimpleDto> find3ShopSimpleByUserEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        List<Clipping> clippings = clippingRepository.findAllByUser(user);
        List<ShopSimpleDto> shopSimpleDtos = new ArrayList<>();
        int cnt = 0;

        Collections.reverse(clippings);
        for (Clipping clipping : clippings) {
            if (cnt >= 3)
                break;
            shopSimpleDtos.add(new ShopSimpleDto(clipping.getShop()));
            cnt++;
        }

        return shopSimpleDtos;
    }

}
