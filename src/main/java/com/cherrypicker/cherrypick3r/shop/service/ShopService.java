package com.cherrypicker.cherrypick3r.shop.service;

import com.cherrypicker.cherrypick3r.clipping.domain.Clipping;
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
import com.cherrypicker.cherrypick3r.shop.dto.ShopSimple;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.shopPhoto.service.ShopPhotoService;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.service.TagService;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.service.UserSearchService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopService {

    private final ShopRepository shopRepository;

    private final ShopSearchService shopSearchService;

    private final ShopClassifyService shopClassifyService;

    private final UserSearchService userSearchService;

    private final TagService tagService;

    private final ClippingService clippingService;

    private final MenuService menuService;

    private final ShopPhotoService shopPhotoService;

    private final GameRepository gameRepository;

    private final ResultRepository resultRepository;

    @Transactional
    public Shop createShop(String phone, String name, String address, Double addressPointY,
        Double addressPointX, Long clippingCount, Long pickedCount, String operatingHours,
        String onelineReview, String mainPhotoUrl1, String mainPhotoUrl2, Long naverId,
        Long kakaoId, Tag tag) {
        Shop shop = new Shop(phone, name, address, addressPointY, addressPointX, clippingCount,
            pickedCount, operatingHours, onelineReview, mainPhotoUrl1, mainPhotoUrl2, naverId,
            kakaoId, tag);
        shopRepository.save(shop);
        return shop;
    }

    @Transactional
    public ShopDto findShopByShopId(Long id) {
        return shopSearchService.findShopById(id).toDto();
    }


    //은정  : shopClassifyService. findAllShopByClassifyTags(taglist)를 이용해서 특정 태그를 가진 가게 리스트를 반환한다 : 태그의 희소성을 나타낼 수 있다. (해당 태그 가게 수/전체 가게 수)
    @Transactional
    public List<Shop> findAllShopByTagIdx(int idx) {

        ArrayList<Long> tagBoolList = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            tagBoolList.add(0L);
        }
        tagBoolList.add(1L);
        for (int i = idx + 1; i < 28; i++) {
            tagBoolList.add(0L);
        }
        return shopClassifyService.findAllShopByClassifyTags(tagBoolList);
    }

    @Transactional
    public List<ShopDto> findAllShopDtoByTagIdx(int idx) {

        ArrayList<Long> tagBoolList = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            tagBoolList.add(0L);
        }
        tagBoolList.add(1L);
        for (int i = idx + 1; i < 28; i++) {
            tagBoolList.add(0L);
        }
        return shopClassifyService.findAllShopByClassifyTags(tagBoolList).stream()
            .map(Shop::toDto)
            .collect(Collectors.toList());
    }

    //오버로딩: Integer.
    @Transactional
    public List<ShopDto> findAllShopDtoByTagIdx(Integer idx) {

        ArrayList<Long> tagBoolList = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            tagBoolList.add(0L);
        }
        tagBoolList.add(1L);
        for (int i = idx + 1; i < 28; i++) {
            tagBoolList.add(0L);
        }
        return shopClassifyService.findAllShopByClassifyTags(tagBoolList).stream()
            .map(Shop::toDto)
            .collect(Collectors.toList());
    }


    @Transactional
    public Long findShopId(Shop shop) {
        return shop.getId();
    }

    @Transactional
    public ShopDto findShopById(Long id) {
        return shopSearchService.findShopById(id).toDto();
    }


    public ShopDto findShopByName(String name) {
        return shopRepository.findByName(name).get().toDto();
    }

    @Transactional
    public List<ShopDto> findAllDtos() {
        List<ShopDto> shopDtoList = new ArrayList<>();
        List<Shop> shopList = shopRepository.findAll();
        for (Shop shop : shopList) {
            shopDtoList.add(shop.toDto());
        }
        return shopDtoList;
    }

    @Transactional
    public ShopCardResponse createShopCardResponseByShopDtoAndUserEmail(ShopDto shopDto,
        String userEmail) {
        ShopCardResponse shopCardResponse = new ShopCardResponse(shopDto);

        shopCardResponse.setTopTags(tagService.getTop5TagPairDtoByShopTag(shopDto.getTag()));
        shopCardResponse.setShopClipping(
            clippingService.findClippingByUserEmailAndShopId(userEmail, shopDto.getId()));

        return shopCardResponse;
    }

    @Transactional
    public ShopDetailResponse createShopDetailResponseByShopDto(ShopDto shopDto, String userEmail) {
        ShopDetailResponse shopDetailResponse = new ShopDetailResponse(shopDto);

        shopDetailResponse.setTopTags(tagService.getTop5TagPairDtoByShopTag(shopDto.getTag()));
        shopDetailResponse.setShopMenus(menuService.findAllMenuSimpleByShopDto(shopDto));
        shopDetailResponse.setShopMainPhotoURLs(
            shopPhotoService.findShopPhotoURLsByShopDto(shopDto));
        shopDetailResponse.setShopClipping(
            clippingService.findClippingByUserEmailAndShopId(userEmail, shopDto.getId()));

        return shopDetailResponse;
    }

    @Transactional
    public ShopSimple createShopSimpleByShopDto(ShopDto shopDto) {
        return ShopSimple.builder()
            .shopId(shopDto.getId())
            .shopName(shopDto.getName())
            .shopCategory("")
            .shopAddress(shopDto.getAddress())
            .operatingHours(shopDto.getOperatingHours())
            .mainPhotoUrl(shopDto.getMainPhotoUrl1())
            .build();
    }

    @Transactional
    public List<ShopSimple> createShopSimpleListByUserEmailResults(String userEmail) {
        User user = userSearchService.findUserByEmail(userEmail);
        List<Game> games = gameRepository.findAllByUser(user);
        List<ShopSimple> shopSimples = new ArrayList<>();

        for (Game game : games) {
            Result result = resultRepository.findByGame(game);
            if (result != null) {
                shopSimples.add(new ShopSimple(result.getShop(), result.getCreatedTime()));
            }
        }

//        // Set을 이용해서 중복 제거
//        // List를 Set으로 변경
//        Set<ShopSimple> set = new HashSet<ShopSimple>(shopSimples);
//        // Set을 List로 변경
//        List<ShopSimple> shopSimplesResult =new ArrayList<ShopSimple>(set);

//        return shopSimplesResult;
        return shopSimples;
    }

    @Transactional
    public List<ShopSimple> createShopSimpleListByUserEmailClippings(String userEmail) {
        User user = userSearchService.findUserByEmail(userEmail);
//        List<ShopDto> shopDtos = clippingService.findClippingShopByUser(user);
        List<Clipping> clippings = clippingService.findClippingByUser(user);
        List<ShopSimple> shopSimples = new ArrayList<>();

//        for (ShopDto shopDto : shopDtos) {
//            if (shopDto != null) {
//                shopSimples.add(new ShopSimple(shopDto, clippingService.));
//            }
//        }

        for (Clipping clipping : clippings) {
            if (clipping.getShop() != null) {
                shopSimples.add(new ShopSimple(clipping.getShop(), clipping.getCreatedTime()));
            }
        }

        // Set을 이용해서 중복 제거
        // List를 Set으로 변경
        Set<ShopSimple> set = new HashSet<ShopSimple>(shopSimples);
        // Set을 List로 변경
        List<ShopSimple> shopSimplesResult = new ArrayList<ShopSimple>(set);

        return shopSimplesResult;
    }
}
