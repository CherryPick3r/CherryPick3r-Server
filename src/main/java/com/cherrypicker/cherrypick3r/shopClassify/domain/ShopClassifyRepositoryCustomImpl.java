package com.cherrypicker.cherrypick3r.shopClassify.domain;

import static com.cherrypicker.cherrypick3r.shopClassify.domain.QShopClassify.shopClassify;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ShopClassifyRepositoryCustomImpl implements ShopClassifyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ShopClassify> findByShopClassifyTags(List<Long> tags) {
        return queryFactory.selectFrom(shopClassify)
            .where(conditionWhenTagIsNotZero(tags))
            .fetch();
    }

    private BooleanBuilder conditionWhenTagIsNotZero(List<Long> tags) {
        BooleanBuilder builder = new BooleanBuilder();

        if (tags.get(0) != 0) {
            builder.or(shopClassify.shopClassifyTag1.eq(tags.get(0)));
        }
        if (tags.get(1) != 0) {
            builder.or(shopClassify.shopClassifyTag2.eq(tags.get(1)));
        }
        if (tags.get(2) != 0) {
            builder.or(shopClassify.shopClassifyTag3.eq(tags.get(2)));
        }
        if (tags.get(3) != 0) {
            builder.or(shopClassify.shopClassifyTag4.eq(tags.get(3)));
        }
        if (tags.get(4) != 0) {
            builder.or(shopClassify.shopClassifyTag5.eq(tags.get(4)));
        }
        if (tags.get(5) != 0) {
            builder.or(shopClassify.shopClassifyTag6.eq(tags.get(5)));
        }
        if (tags.get(6) != 0) {
            builder.or(shopClassify.shopClassifyTag7.eq(tags.get(6)));
        }
        if (tags.get(7) != 0) {
            builder.or(shopClassify.shopClassifyTag8.eq(tags.get(7)));
        }
        if (tags.get(8) != 0) {
            builder.or(shopClassify.shopClassifyTag9.eq(tags.get(8)));
        }
        if (tags.get(9) != 0) {
            builder.or(shopClassify.shopClassifyTag10.eq(tags.get(9)));
        }
        if (tags.get(10) != 0) {
            builder.or(shopClassify.shopClassifyTag11.eq(tags.get(10)));
        }
        if (tags.get(11) != 0) {
            builder.or(shopClassify.shopClassifyTag12.eq(tags.get(11)));
        }
        if (tags.get(12) != 0) {
            builder.or(shopClassify.shopClassifyTag13.eq(tags.get(12)));
        }
        if (tags.get(13) != 0) {
            builder.or(shopClassify.shopClassifyTag14.eq(tags.get(13)));
        }
        if (tags.get(14) != 0) {
            builder.or(shopClassify.shopClassifyTag15.eq(tags.get(14)));
        }
        if (tags.get(15) != 0) {
            builder.or(shopClassify.shopClassifyTag16.eq(tags.get(15)));
        }
        if (tags.get(16) != 0) {
            builder.or(shopClassify.shopClassifyTag17.eq(tags.get(16)));
        }
        if (tags.get(17) != 0) {
            builder.or(shopClassify.shopClassifyTag18.eq(tags.get(17)));
        }
        if (tags.get(18) != 0) {
            builder.or(shopClassify.shopClassifyTag19.eq(tags.get(18)));
        }
        if (tags.get(19) != 0) {
            builder.or(shopClassify.shopClassifyTag20.eq(tags.get(19)));
        }
        if (tags.get(20) != 0) {
            builder.or(shopClassify.shopClassifyTag21.eq(tags.get(20)));
        }
        if (tags.get(21) != 0) {
            builder.or(shopClassify.shopClassifyTag22.eq(tags.get(21)));
        }
        if (tags.get(22) != 0) {
            builder.or(shopClassify.shopClassifyTag23.eq(tags.get(22)));
        }
        if (tags.get(23) != 0) {
            builder.or(shopClassify.shopClassifyTag24.eq(tags.get(23)));
        }
        if (tags.get(24) != 0) {
            builder.or(shopClassify.shopClassifyTag25.eq(tags.get(24)));
        }
        if (tags.get(25) != 0) {
            builder.or(shopClassify.shopClassifyTag26.eq(tags.get(25)));
        }
        if (tags.get(26) != 0) {
            builder.or(shopClassify.shopClassifyTag27.eq(tags.get(26)));
        }
        if (tags.get(27) != 0) {
            builder.or(shopClassify.shopClassifyTag28.eq(tags.get(27)));
        }
        return builder;
    }
}
