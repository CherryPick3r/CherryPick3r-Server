package com.cherrypicker.cherrypick3r.shopPhoto.service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopPhoto.domain.ShopPhoto;
import com.cherrypicker.cherrypick3r.shopPhoto.domain.ShopPhotoRepository;
import com.cherrypicker.cherrypick3r.shopPhoto.dto.ShopPhotoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class shopPhotoService {


    private final ShopPhotoRepository shopPhotoRepository;

    @Transactional
    public ShopPhoto createShopPhoto(String photoUrl, Shop shop){
        ShopPhoto shopPhoto = new ShopPhoto(photoUrl, shop);
        shopPhotoRepository.save(shopPhoto);
        return shopPhoto;
    }

    @Transactional
    public List<Optional<ShopPhotoDto>> findShopPhotoDtosByShop(Shop shop){
        List<Optional <ShopPhoto>> allByShop = shopPhotoRepository.findAllByShop(shop);
        List<ShopPhotoDto> shopDtoList = new ArrayList<>();
        //Dto 객체 리스트를 만든다.
        for(Optional <ShopPhoto> shopPhoto: allByShop){
            if(shopPhoto.isEmpty() == false)
                shopDtoList.add(shopPhoto.get().toDto());
        }
        //Optional 리스트로 바꾸어 반환한다.
        List <Optional <ShopPhotoDto> > optionalList = shopDtoList.stream()
                .map(dto -> Optional.ofNullable(dto))
                .collect(Collectors.toList());

        return optionalList;
    }


    //ShopPhotoList 중에서 원하는 인덱스의 ShopPhotoDto만 가져온다. (id 값 = 0부터 시작)
    //못찾을 경우 널을 감싼 Optional 객체를 반환한다.
    @Transactional
    public Optional <ShopPhotoDto> findShopPhotoDtoByIdx(List<Optional <ShopPhotoDto>> shopPhotoDtoList, Long idx){
        ShopPhotoDto shopPhotoDtoObj = null;
        for(Optional <ShopPhotoDto> iter: shopPhotoDtoList){
            if(iter.isEmpty() == false){
                 shopPhotoDtoObj = iter.get();
                if(shopPhotoDtoObj.getId() == idx)
                    return iter;
            }
        }
        return Optional.ofNullable(shopPhotoDtoObj);
    }
    //shop의 mainUrl1에 해당하는 shopPhoto를 반환하는 역할을 한다.
    @Transactional
    public Optional <ShopPhotoDto> findOneByShop(Shop shop) {
        return findShopPhotoDtoByIdx(findShopPhotoDtosByShop(shop), 0L);
    }
    //shop의 mainUrl2에 해당하는 shopPhoto를 반환하는 역할을 한다.
    @Transactional
    public Optional <ShopPhotoDto> findTwoByShop(Shop shop) {
        return findShopPhotoDtoByIdx(findShopPhotoDtosByShop(shop), 1L);
    }

    @Transactional
    public void deleteShopPhoto(ShopPhoto shopPhoto){
        shopPhotoRepository.delete(shopPhoto);
    }
}

