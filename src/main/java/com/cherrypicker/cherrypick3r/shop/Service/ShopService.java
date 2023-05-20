package com.cherrypicker.cherrypick3r.shop.Service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShopService {

    private final ShopRepository shopRepository;

    private final TagRepository tagRepository;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    private final ShopClassifyService shopClassifyService;

    @Transactional
    public Shop createShop(String phone, String name, String address, Double addressPointY, Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Tag tag)
    {
        Shop shop =  new Shop(phone, name , address, addressPointY, addressPointX , clippingCount, pickedCount, operatingHours, onelineReview, mainPhotoUrl1, mainPhotoUrl2, tag);
        shopRepository.save(shop);
        return shop;

    }

    @Transactional
    public ShopDto findShopByShopId(Long id){
        Shop shop = shopRepository.findById(id).get();
        return shop.toDto();
    }


    //은정  : shopClassifyService. findAllShopByClassifyTags(taglist)를 이용해서 특정 태그를 가진 가게 리스트를 반환한다 : 태그의 희소성을 나타낼 수 있다. (해당 태그 가게 수/전체 가게 수)
    @Transactional
    public List<Shop> findAllShopByTagIdx(int idx){

        ArrayList<Long> tagBoolList  = new ArrayList<>();
        for(int i = 0; i < idx; i++)
            tagBoolList.add(0L);
        tagBoolList.add(1L);
        for(int i = idx + 1; i < 28; i++)
            tagBoolList.add(0L);
        return shopClassifyService.findAllShopByClassifyTags(tagBoolList);
    }

    @Transactional
    public List<ShopDto> findAllShopDtoByTagIdx(int idx){

        ArrayList<Long> tagBoolList  = new ArrayList<>();
        for(int i = 0; i < idx; i++)
            tagBoolList.add(0L);
        tagBoolList.add(1L);
        for(int i = idx + 1; i < 28; i++)
            tagBoolList.add(0L);
        return shopClassifyService.findAllShopDtoByClassifyTags(tagBoolList);
    }

    //오버로딩: Integer.
    @Transactional
    public List<ShopDto> findAllShopDtoByTagIdx(Integer idx){

        ArrayList<Long> tagBoolList  = new ArrayList<>();
        for(int i = 0; i < idx; i++)
            tagBoolList.add(0L);
        tagBoolList.add(1L);
        for(int i = idx + 1; i < 28; i++)
            tagBoolList.add(0L);
        return shopClassifyService.findAllShopDtoByClassifyTags(tagBoolList);
    }


        @Transactional
        public Long findShopid(Shop shop)
        {
            return shop.getId();
        }
        @Transactional
        public ShopDto findShopById(Long id)
        {
            return shopRepository.findById(id).get().toDto();
        }


    public ShopDto findShopByName(String name){
        return shopRepository.findByName(name).get().toDto();
    }



}
