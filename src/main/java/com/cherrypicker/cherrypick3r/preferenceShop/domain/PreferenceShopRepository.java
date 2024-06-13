package com.cherrypicker.cherrypick3r.preferenceShop.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PreferenceShopRepository extends JpaRepository<PreferenceShop, Long> {

    // 랜덤한 5개의 가게를 뽑는다.
    @Query(value = "SELECT * FROM preference_shop_table ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<PreferenceShop> findRandomPreferenceShops();

}
