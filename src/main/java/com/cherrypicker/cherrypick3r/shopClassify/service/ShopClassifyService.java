package com.cherrypicker.cherrypick3r.shopClassify.service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopClassifyService {

    private final ShopClassifyRepository shopClassifyRepository;

    private final ShopRepository shopRepository;

    // 가게를 받아서 가게의 태그 값을 이용해서 가게 태그 분류 테이블의 엔티티를 생성하고 값을 채워넣는 함수, n(0~1)의 값을 기준으로 이하는 0, 이상은 1로 만들어서 태그 유무를 분리한다.
    @Transactional
    public ShopClassify makeShopClassifyUsingTagValues(Shop shop, Double n) {
        Tag tag = shop.getTag();

        if (tag == null) {
            return null; // TODO: TagNotFoundException
        }

        List<Double> tags = tag.getTagsByList();
        List<Long> classifys = new ArrayList<>();
        int tagsLen = tags.size();

        ShopClassify shopClassify = new ShopClassify(shop);
        shop.mappingShopClassify(shopClassify);

        for (int i=0;i<tagsLen;i++) {
            if (tags.get(i) <= n) {
                classifys.add(0L);
            }
            else {
                classifys.add(1L);
            }
        }

        shopClassify.setShopClassifyByList(classifys);

        shopClassifyRepository.save(shopClassify);
        return shopClassify;
    }

    // 가게를 받아서 결정치 n(0~1)에 따라서 '모든' 가게 태그 분류 테이블의 엔티티를 만드는 함수 (batchJob)
    @Transactional
    public List<ShopClassify> makeAllShopClassifyUsingTagValues(Double n) {
        List<Shop> shops = shopRepository.findAll();
        List<ShopClassify> shopClassifies = new ArrayList<>();

        for (Shop shop : shops) {
            shopClassifies.add(makeShopClassifyUsingTagValues(shop, n));
        }
        return shopClassifies;
    }

    // 특정 태그들에 해당하는 모든 가게를 반환하는 함수
    // 0L을 null로 바꿔서 넣는 이유: 0L을 null로 만들어서 넣으면 쿼리를 생성할 때, 해당 값은 신경쓰지 않고 넘어감
//    주어진 함수는 특정 태그들에 해당하는 모든 가게를 반환하는 기능을 수행합니다.
//    함수 내부에서는 shopClassifyRepository를 사용하여 findByShopClassifyTag1OrShopClassifyTag2OrShopClassifyTag3Or... 등의 메서드를 호출하여 태그 조건에 맞는 ShopClassify 엔티티를 검색합니다.
//    그 후, ShopClassify 엔티티의 shop 속성을 통해 해당 가게를 가져와 shops 리스트에 추가합니다.
//    최종적으로 shops 리스트를 반환합니다.
//
//    함수는 tags 리스트의 크기에 따라 findByShopClassifyTag1OrShopClassifyTag2OrShopClassifyTag3Or... 메서드의 호출 개수가 결정됩니다.
//    각 태그의 값이 0L인 경우 해당 태그를 무시하기 위해 null로 변환하여 메서드에 전달합니다.
    @Transactional
    public List<Shop> findAllShopByClassifyTags(List<Long> tags) {
        List<Shop> shops = new ArrayList<>();

        List<ShopClassify> shopClassifies = shopClassifyRepository.findByShopClassifyTag1OrShopClassifyTag2OrShopClassifyTag3OrShopClassifyTag4OrShopClassifyTag5OrShopClassifyTag6OrShopClassifyTag7OrShopClassifyTag8OrShopClassifyTag9OrShopClassifyTag10OrShopClassifyTag11OrShopClassifyTag12OrShopClassifyTag13OrShopClassifyTag14OrShopClassifyTag15OrShopClassifyTag16OrShopClassifyTag17OrShopClassifyTag18OrShopClassifyTag19OrShopClassifyTag20OrShopClassifyTag21OrShopClassifyTag22OrShopClassifyTag23OrShopClassifyTag24OrShopClassifyTag25OrShopClassifyTag26OrShopClassifyTag27OrShopClassifyTag28(
                tags.get(0) == 0L ? null : tags.get(0),tags.get(1) == 0L ? null : tags.get(1),tags.get(2) == 0L ? null : tags.get(2),tags.get(3) == 0L ? null : tags.get(3),tags.get(4) == 0L ? null : tags.get(4),
                tags.get(5) == 0L ? null : tags.get(5),tags.get(6) == 0L ? null : tags.get(6),tags.get(7) == 0L ? null : tags.get(7),tags.get(8) == 0L ? null : tags.get(8),tags.get(9) == 0L ? null : tags.get(9),
                tags.get(10) == 0L ? null : tags.get(10),tags.get(11) == 0L ? null : tags.get(11),tags.get(12) == 0L ? null : tags.get(12),tags.get(13) == 0L ? null : tags.get(13),tags.get(14) == 0L ? null : tags.get(14),
                tags.get(15) == 0L ? null : tags.get(15),tags.get(16) == 0L ? null : tags.get(16),tags.get(17) == 0L ? null : tags.get(17),tags.get(18) == 0L ? null : tags.get(18),tags.get(19) == 0L ? null : tags.get(19),
                tags.get(20) == 0L ? null : tags.get(20),tags.get(21) == 0L ? null : tags.get(21),tags.get(22) == 0L ? null : tags.get(22),tags.get(23) == 0L ? null : tags.get(23),tags.get(24) == 0L ? null : tags.get(24),
                tags.get(25) == 0L ? null : tags.get(25),tags.get(26) == 0L ? null : tags.get(26),tags.get(27) == 0L ? null : tags.get(27)
        );

        for (ShopClassify shopClassify : shopClassifies) {
            shops.add(shopClassify.getShop());
        }

        return shops;
    }

    @Transactional
    public List<ShopDto> findAllShopDtoByClassifyTags(List<Long> tags) {
        List<ShopDto> shops = new ArrayList<>();

        List<ShopClassify> shopClassifies = shopClassifyRepository.findByShopClassifyTag1OrShopClassifyTag2OrShopClassifyTag3OrShopClassifyTag4OrShopClassifyTag5OrShopClassifyTag6OrShopClassifyTag7OrShopClassifyTag8OrShopClassifyTag9OrShopClassifyTag10OrShopClassifyTag11OrShopClassifyTag12OrShopClassifyTag13OrShopClassifyTag14OrShopClassifyTag15OrShopClassifyTag16OrShopClassifyTag17OrShopClassifyTag18OrShopClassifyTag19OrShopClassifyTag20OrShopClassifyTag21OrShopClassifyTag22OrShopClassifyTag23OrShopClassifyTag24OrShopClassifyTag25OrShopClassifyTag26OrShopClassifyTag27OrShopClassifyTag28(
                tags.get(0) == 0L ? null : tags.get(0),tags.get(1) == 0L ? null : tags.get(1),tags.get(2) == 0L ? null : tags.get(2),tags.get(3) == 0L ? null : tags.get(3),tags.get(4) == 0L ? null : tags.get(4),
                tags.get(5) == 0L ? null : tags.get(5),tags.get(6) == 0L ? null : tags.get(6),tags.get(7) == 0L ? null : tags.get(7),tags.get(8) == 0L ? null : tags.get(8),tags.get(9) == 0L ? null : tags.get(9),
                tags.get(10) == 0L ? null : tags.get(10),tags.get(11) == 0L ? null : tags.get(11),tags.get(12) == 0L ? null : tags.get(12),tags.get(13) == 0L ? null : tags.get(13),tags.get(14) == 0L ? null : tags.get(14),
                tags.get(15) == 0L ? null : tags.get(15),tags.get(16) == 0L ? null : tags.get(16),tags.get(17) == 0L ? null : tags.get(17),tags.get(18) == 0L ? null : tags.get(18),tags.get(19) == 0L ? null : tags.get(19),
                tags.get(20) == 0L ? null : tags.get(20),tags.get(21) == 0L ? null : tags.get(21),tags.get(22) == 0L ? null : tags.get(22),tags.get(23) == 0L ? null : tags.get(23),tags.get(24) == 0L ? null : tags.get(24),
                tags.get(25) == 0L ? null : tags.get(25),tags.get(26) == 0L ? null : tags.get(26),tags.get(27) == 0L ? null : tags.get(27)
        );

        for (ShopClassify shopClassify : shopClassifies) {
            shops.add(shopClassify.getShop().toDto());
        }
        return shops;
    }

}
