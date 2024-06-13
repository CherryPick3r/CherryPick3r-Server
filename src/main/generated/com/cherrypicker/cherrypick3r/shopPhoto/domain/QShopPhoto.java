package com.cherrypicker.cherrypick3r.shopPhoto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopPhoto is a Querydsl query type for ShopPhoto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopPhoto extends EntityPathBase<ShopPhoto> {

    private static final long serialVersionUID = 1411595103L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopPhoto shopPhoto = new QShopPhoto("shopPhoto");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath photoUrl = createString("photoUrl");

    public final com.cherrypicker.cherrypick3r.shop.domain.QShop shop;

    public QShopPhoto(String variable) {
        this(ShopPhoto.class, forVariable(variable), INITS);
    }

    public QShopPhoto(Path<? extends ShopPhoto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopPhoto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopPhoto(PathMetadata metadata, PathInits inits) {
        this(ShopPhoto.class, metadata, inits);
    }

    public QShopPhoto(Class<? extends ShopPhoto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new com.cherrypicker.cherrypick3r.shop.domain.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

