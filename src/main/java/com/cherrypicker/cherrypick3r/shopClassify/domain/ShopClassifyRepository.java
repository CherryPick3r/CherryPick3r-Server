package com.cherrypicker.cherrypick3r.shopClassify.domain;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopClassifyRepository extends JpaRepository<ShopClassify, Long> {
    List<ShopClassify> findByShopClassifyTag1OrShopClassifyTag2OrShopClassifyTag3OrShopClassifyTag4OrShopClassifyTag5OrShopClassifyTag6OrShopClassifyTag7OrShopClassifyTag8OrShopClassifyTag9OrShopClassifyTag10OrShopClassifyTag11OrShopClassifyTag12OrShopClassifyTag13OrShopClassifyTag14OrShopClassifyTag15OrShopClassifyTag16OrShopClassifyTag17OrShopClassifyTag18OrShopClassifyTag19OrShopClassifyTag20OrShopClassifyTag21OrShopClassifyTag22OrShopClassifyTag23OrShopClassifyTag24OrShopClassifyTag25OrShopClassifyTag26OrShopClassifyTag27OrShopClassifyTag28(
            Long tag1, Long tag2, Long tag3, Long tag4, Long tag5, Long tag6, Long tag7, Long tag8, Long tag9, Long tag10, Long tag11, Long tag12, Long tag13, Long tag14, Long tag15, Long tag16, Long tag17, Long tag18, Long tag19, Long tag20, Long tag21, Long tag22, Long tag23, Long tag24, Long tag25, Long tag26, Long tag27, Long tag28);

}
