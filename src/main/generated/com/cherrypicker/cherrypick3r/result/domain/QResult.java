package com.cherrypicker.cherrypick3r.result.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResult is a Querydsl query type for Result
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResult extends EntityPathBase<Result> {

    private static final long serialVersionUID = 965379409L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResult result = new QResult("result");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final com.cherrypicker.cherrypick3r.game.domain.QGame game;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Double> score = createNumber("score", Double.class);

    public final com.cherrypicker.cherrypick3r.shop.domain.QShop shop;

    public final NumberPath<Double> similarity = createNumber("similarity", Double.class);

    public QResult(String variable) {
        this(Result.class, forVariable(variable), INITS);
    }

    public QResult(Path<? extends Result> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResult(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResult(PathMetadata metadata, PathInits inits) {
        this(Result.class, metadata, inits);
    }

    public QResult(Class<? extends Result> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new com.cherrypicker.cherrypick3r.game.domain.QGame(forProperty("game"), inits.get("game")) : null;
        this.shop = inits.isInitialized("shop") ? new com.cherrypicker.cherrypick3r.shop.domain.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

