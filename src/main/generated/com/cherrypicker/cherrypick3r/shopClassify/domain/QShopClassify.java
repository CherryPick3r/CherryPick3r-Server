package com.cherrypicker.cherrypick3r.shopClassify.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopClassify is a Querydsl query type for ShopClassify
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopClassify extends EntityPathBase<ShopClassify> {

    private static final long serialVersionUID = 1537842315L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopClassify shopClassify = new QShopClassify("shopClassify");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final com.cherrypicker.cherrypick3r.shop.domain.QShop shop;

    public final NumberPath<Long> shopClassifyTag1 = createNumber("shopClassifyTag1", Long.class);

    public final NumberPath<Long> shopClassifyTag10 = createNumber("shopClassifyTag10", Long.class);

    public final NumberPath<Long> shopClassifyTag11 = createNumber("shopClassifyTag11", Long.class);

    public final NumberPath<Long> shopClassifyTag12 = createNumber("shopClassifyTag12", Long.class);

    public final NumberPath<Long> shopClassifyTag13 = createNumber("shopClassifyTag13", Long.class);

    public final NumberPath<Long> shopClassifyTag14 = createNumber("shopClassifyTag14", Long.class);

    public final NumberPath<Long> shopClassifyTag15 = createNumber("shopClassifyTag15", Long.class);

    public final NumberPath<Long> shopClassifyTag16 = createNumber("shopClassifyTag16", Long.class);

    public final NumberPath<Long> shopClassifyTag17 = createNumber("shopClassifyTag17", Long.class);

    public final NumberPath<Long> shopClassifyTag18 = createNumber("shopClassifyTag18", Long.class);

    public final NumberPath<Long> shopClassifyTag19 = createNumber("shopClassifyTag19", Long.class);

    public final NumberPath<Long> shopClassifyTag2 = createNumber("shopClassifyTag2", Long.class);

    public final NumberPath<Long> shopClassifyTag20 = createNumber("shopClassifyTag20", Long.class);

    public final NumberPath<Long> shopClassifyTag21 = createNumber("shopClassifyTag21", Long.class);

    public final NumberPath<Long> shopClassifyTag22 = createNumber("shopClassifyTag22", Long.class);

    public final NumberPath<Long> shopClassifyTag23 = createNumber("shopClassifyTag23", Long.class);

    public final NumberPath<Long> shopClassifyTag24 = createNumber("shopClassifyTag24", Long.class);

    public final NumberPath<Long> shopClassifyTag25 = createNumber("shopClassifyTag25", Long.class);

    public final NumberPath<Long> shopClassifyTag26 = createNumber("shopClassifyTag26", Long.class);

    public final NumberPath<Long> shopClassifyTag27 = createNumber("shopClassifyTag27", Long.class);

    public final NumberPath<Long> shopClassifyTag28 = createNumber("shopClassifyTag28", Long.class);

    public final NumberPath<Long> shopClassifyTag3 = createNumber("shopClassifyTag3", Long.class);

    public final NumberPath<Long> shopClassifyTag4 = createNumber("shopClassifyTag4", Long.class);

    public final NumberPath<Long> shopClassifyTag5 = createNumber("shopClassifyTag5", Long.class);

    public final NumberPath<Long> shopClassifyTag6 = createNumber("shopClassifyTag6", Long.class);

    public final NumberPath<Long> shopClassifyTag7 = createNumber("shopClassifyTag7", Long.class);

    public final NumberPath<Long> shopClassifyTag8 = createNumber("shopClassifyTag8", Long.class);

    public final NumberPath<Long> shopClassifyTag9 = createNumber("shopClassifyTag9", Long.class);

    public QShopClassify(String variable) {
        this(ShopClassify.class, forVariable(variable), INITS);
    }

    public QShopClassify(Path<? extends ShopClassify> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopClassify(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopClassify(PathMetadata metadata, PathInits inits) {
        this(ShopClassify.class, metadata, inits);
    }

    public QShopClassify(Class<? extends ShopClassify> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new com.cherrypicker.cherrypick3r.shop.domain.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

