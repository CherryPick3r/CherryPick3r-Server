package com.cherrypicker.cherrypick3r.shop.Service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class ShopService {

    private ShopRepository shopRepository;

    private final TagRepository tagRepository;

    public ShopDto createShop(String phone, String name, String address, Double addressPointY, Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Tag tag)
    {
        return new Shop(phone, name , address, addressPointY, addressPointX , clippingCount, pickedCount, operatingHours, onelineReview, mainPhotoUrl1, mainPhotoUrl2, tag).toDto();
    }

    public ShopDto findShopByShopId(Long id){
        Shop shop = shopRepository.findById(id).get();
        return shop.toDto();
    }
//    public ArrayList<ShopDto> findShopByTagIndex(Long tagId){ //나중에 Tag 메소드 찾으면 사용할 예정.
        //TagIndex를 갖고 있는 가게의 리스트를 반환.
        //가게를 순회하면서 해당 태그를 갖고 있으면 리스트에 더해서 반환하는 것으로 구현할 예정.

//    }
//    public ArrayList<ShopDto> findShopByOperatingHours(String operatingHours) {
//        //특정 시간 이후에도 운영하는 가게를 찾는다.
//        //엄밀히 말하면 오늘, 지금 운영하는 가게를 찾는다.
//    }

    public ShopDto findShopByName(String name){
        return shopRepository.findByName(name).get().toDto();
    }

}
