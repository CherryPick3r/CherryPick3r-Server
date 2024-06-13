package com.cherrypicker.cherrypick3r.shopClassify.service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepositoryCustom;
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

    private final ShopClassifyRepositoryCustom shopClassifyRepositoryCustom;

    private final ShopRepository shopRepository;

    // 가게를 받아서 가게의 태그 값을 이용해서 가게 태그 분류 테이블의 엔티티를 생성하고 값을 채워넣는 함수, n(0~1)의 값을 기준으로 이하는 0, 이상은 1로 만들어서 태그 유무를 분리한다.
    @Transactional
    public ShopClassify makeShopClassifyUsingTagValues(Shop shop, Double n) {
        Tag tag = shop.getTag();

        if (tag == null) {
            throw new IllegalArgumentException("가게에 태그가 없습니다.");
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
    @Transactional
    public List<Shop> findAllShopByClassifyTags(List<Long> tags) {
        List<Shop> shops = new ArrayList<>();

        List<ShopClassify> shopClassifies = shopClassifyRepositoryCustom.findByShopClassifyTags(tags);

        for (ShopClassify shopClassify : shopClassifies) {
            shops.add(shopClassify.getShop());
        }

        return shops;
    }

}
