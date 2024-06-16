package com.cherrypicker.cherrypick3r.game.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGame is a Querydsl query type for Game
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGame extends EntityPathBase<Game> {

    private static final long serialVersionUID = -376449733L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGame game = new QGame("game");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> curRound = createNumber("curRound", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final ListPath<Long, NumberPath<Long>> recommendedShopIds = this.<Long, NumberPath<Long>>createList("recommendedShopIds", Long.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final com.cherrypicker.cherrypick3r.tag.domain.QTag tag;

    public final NumberPath<Long> totalRound = createNumber("totalRound", Long.class);

    public final com.cherrypicker.cherrypick3r.user.domain.QUser user;

    public QGame(String variable) {
        this(Game.class, forVariable(variable), INITS);
    }

    public QGame(Path<? extends Game> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGame(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGame(PathMetadata metadata, PathInits inits) {
        this(Game.class, metadata, inits);
    }

    public QGame(Class<? extends Game> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tag = inits.isInitialized("tag") ? new com.cherrypicker.cherrypick3r.tag.domain.QTag(forProperty("tag")) : null;
        this.user = inits.isInitialized("user") ? new com.cherrypicker.cherrypick3r.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

