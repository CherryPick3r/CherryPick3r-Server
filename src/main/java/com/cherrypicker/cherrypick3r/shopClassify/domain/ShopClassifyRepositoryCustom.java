package com.cherrypicker.cherrypick3r.shopClassify.domain;

import java.util.List;

public interface ShopClassifyRepositoryCustom {

    List<ShopClassify> findByShopClassifyTags(List<Long> tags);

}
