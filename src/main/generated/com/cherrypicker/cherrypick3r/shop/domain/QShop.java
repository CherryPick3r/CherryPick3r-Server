package com.cherrypicker.cherrypick3r.shop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShop is a Querydsl query type for Shop
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShop extends EntityPathBase<Shop> {

    private static final long serialVersionUID = -188183229L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShop shop = new QShop("shop");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Double> addressPointX = createNumber("addressPointX", Double.class);

    public final NumberPath<Double> addressPointY = createNumber("addressPointY", Double.class);

    public final NumberPath<Long> clippingCount = createNumber("clippingCount", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> kakaoId = createNumber("kakaoId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath mainPhotoUrl1 = createString("mainPhotoUrl1");

    public final StringPath mainPhotoUrl2 = createString("mainPhotoUrl2");

    public final StringPath name = createString("name");

    public final NumberPath<Long> naverId = createNumber("naverId", Long.class);

    public final StringPath onelineReview = createString("onelineReview");

    public final StringPath operatingHours = createString("operatingHours");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> pickedCount = createNumber("pickedCount", Long.class);

    public final com.cherrypicker.cherrypick3r.shopClassify.domain.QShopClassify shopClassify;

    public final com.cherrypicker.cherrypick3r.tag.domain.QTag tag;

    public QShop(String variable) {
        this(Shop.class, forVariable(variable), INITS);
    }

    public QShop(Path<? extends Shop> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShop(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShop(PathMetadata metadata, PathInits inits) {
        this(Shop.class, metadata, inits);
    }

    public QShop(Class<? extends Shop> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shopClassify = inits.isInitialized("shopClassify") ? new com.cherrypicker.cherrypick3r.shopClassify.domain.QShopClassify(forProperty("shopClassify"), inits.get("shopClassify")) : null;
        this.tag = inits.isInitialized("tag") ? new com.cherrypicker.cherrypick3r.tag.domain.QTag(forProperty("tag")) : null;
    }

}

