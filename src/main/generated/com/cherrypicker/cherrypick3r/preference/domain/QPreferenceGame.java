package com.cherrypicker.cherrypick3r.preference.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferenceGame is a Querydsl query type for PreferenceGame
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferenceGame extends EntityPathBase<PreferenceGame> {

    private static final long serialVersionUID = 947993951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferenceGame preferenceGame = new QPreferenceGame("preferenceGame");

    public final NumberPath<Long> curRound = createNumber("curRound", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Long, NumberPath<Long>> recommendedShopIds = this.<Long, NumberPath<Long>>createList("recommendedShopIds", Long.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Long> totalRound = createNumber("totalRound", Long.class);

    public final com.cherrypicker.cherrypick3r.user.domain.QUser user;

    public QPreferenceGame(String variable) {
        this(PreferenceGame.class, forVariable(variable), INITS);
    }

    public QPreferenceGame(Path<? extends PreferenceGame> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferenceGame(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferenceGame(PathMetadata metadata, PathInits inits) {
        this(PreferenceGame.class, metadata, inits);
    }

    public QPreferenceGame(Class<? extends PreferenceGame> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.cherrypicker.cherrypick3r.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

