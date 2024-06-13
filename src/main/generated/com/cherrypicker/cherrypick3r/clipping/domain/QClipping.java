package com.cherrypicker.cherrypick3r.clipping.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClipping is a Querydsl query type for Clipping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClipping extends EntityPathBase<Clipping> {

    private static final long serialVersionUID = 1894577371L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClipping clipping = new QClipping("clipping");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final com.cherrypicker.cherrypick3r.shop.domain.QShop shop;

    public final com.cherrypicker.cherrypick3r.user.domain.QUser user;

    public QClipping(String variable) {
        this(Clipping.class, forVariable(variable), INITS);
    }

    public QClipping(Path<? extends Clipping> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClipping(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClipping(PathMetadata metadata, PathInits inits) {
        this(Clipping.class, metadata, inits);
    }

    public QClipping(Class<? extends Clipping> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new com.cherrypicker.cherrypick3r.shop.domain.QShop(forProperty("shop"), inits.get("shop")) : null;
        this.user = inits.isInitialized("user") ? new com.cherrypicker.cherrypick3r.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

