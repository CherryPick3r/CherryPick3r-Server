package com.cherrypicker.cherrypick3r.shop.Service;

import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.menu.service.MenuService;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopCardResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDetailResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopSimpleDto;
import com.cherrypicker.cherrypick3r.shopCard.service.ShopCardService;
import com.cherrypicker.cherrypick3r.shopDetail.service.ShopDetailService;
import com.cherrypicker.cherrypick3r.shopPhoto.service.ShopPhotoService;
import com.cherrypicker.cherrypick3r.shopSimple.service.ShopSimpleService;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;

import com.cherrypicker.cherrypick3r.tag.service.TagService;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ShopService {

    private final ShopRepository shopRepository;

    private final UserRepository userRepository;

    private final ClippingService clippingService;

    private final GameRepository gameRepository;

    private final ResultRepository resultRepository;

    private final ShopCardService shopCardService;

    private final ShopDetailService shopDetailService;

    private final ShopSimpleService shopSimpleService;

    @Transactional
    public Shop createShop(String phone, String name, String address, Double addressPointY, Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours, String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Long naverId, Long kakaoId, Tag tag)
    {
        Shop shop =  new Shop(phone, name , address, addressPointY, addressPointX , clippingCount, pickedCount, operatingHours, onelineReview, mainPhotoUrl1, mainPhotoUrl2, naverId, kakaoId, tag);
        shopRepository.save(shop);
        return shop;
    }

    // Redis 캐싱
    @Transactional
    public ShopCardResponse createShopCardResponseByShopDtoAndUserEmail(ShopDto shopDto, String userEmail) {
        ShopCardResponse  shopCardResponse= new ShopCardResponse(shopCardService.findShopCard(shopDto, userEmail));

        return shopCardResponse;
    }

    // Redis 캐싱
    @Transactional
    public ShopDetailResponse createShopDetailResponseByShopDto(ShopDto shopDto, String userEmail) {
        ShopDetailResponse shopDetailResponse = new ShopDetailResponse(shopDetailService.findShopDetail(shopDto, userEmail));

//        ShopDetailResponse shopDetailResponse = new ShopDetailResponse(shopDto);

//        shopDetailResponse.setTopTags(tagService.getTop5TagPairDtoByShop(shopDto));
//        shopDetailResponse.setShopMenus(menuService.findAllMenuSimpleByShopDto(shopDto));
//        shopDetailResponse.setShopMainPhotoURLs(shopPhotoService.findShopPhotoURLsByShopDto(shopDto));
//        shopDetailResponse.setShopClipping(clippingService.findClippingByUserEmailAndShopId(userEmail, shopDto.getId()));

        return shopDetailResponse;
    }

    @Transactional
    public ShopSimpleDto createShopSimpleByShopDto(ShopDto shopDto) {
        ShopSimpleDto shopSimpleDto = new ShopSimpleDto(shopSimpleService.findShopSimple(shopDto.getId()));

//        ShopSimpleDto shopSimpleDto = ShopSimpleDto.builder()
//                .shopId(shopDto.getId())
//                .shopName(shopDto.getName())
//                .shopCategory("")
//                .shopAddress(shopDto.getAddress())
//                .operatingHours(shopDto.getOperatingHours())
//                .mainPhotoUrl(shopDto.getMainPhotoUrl1())
//                .build();

        return shopSimpleDto;
    }

    @Transactional
    public List<ShopSimpleDto> createShopSimpleListByUserEmailResults(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        List<Game> games = gameRepository.findAllByUser(user);
        List<ShopSimpleDto> shopSimpleDtos = new ArrayList<>();

        for (Game game : games) {
            Result result = resultRepository.findByGame(game);
            if (result != null) {
                shopSimpleDtos.add(new ShopSimpleDto(result.getShop()));
            }
        }

        // Set을 이용해서 중복 제거
        // List를 Set으로 변경
        Set<ShopSimpleDto> set = new HashSet<ShopSimpleDto>(shopSimpleDtos);
        // Set을 List로 변경
        List<ShopSimpleDto> shopSimplesDtoResult =new ArrayList<ShopSimpleDto>(set);

        return shopSimplesDtoResult;
    }

    @Transactional
    public List<ShopSimpleDto> createShopSimpleListByUserEmailClippings(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        List<ShopDto> shopDtos = clippingService.findClippingShopByUser(user);
        List<ShopSimpleDto> shopSimpleDtos = new ArrayList<>();

        for (ShopDto shopDto : shopDtos) {
            if (shopDto != null) {
                shopSimpleDtos.add(new ShopSimpleDto(shopDto));
            }
        }

        // Set을 이용해서 중복 제거
        // List를 Set으로 변경
        Set<ShopSimpleDto> set = new HashSet<ShopSimpleDto>(shopSimpleDtos);
        // Set을 List로 변경
        List<ShopSimpleDto> shopSimplesDtoResult =new ArrayList<ShopSimpleDto>(set);

        return shopSimplesDtoResult;
    }
}
