package com.cherrypicker.cherrypick3r.preferenceShop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferenceShop is a Querydsl query type for PreferenceShop
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferenceShop extends EntityPathBase<PreferenceShop> {

    private static final long serialVersionUID = -1472418823L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferenceShop preferenceShop = new QPreferenceShop("preferenceShop");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final com.cherrypicker.cherrypick3r.tag.domain.QTag tag;

    public QPreferenceShop(String variable) {
        this(PreferenceShop.class, forVariable(variable), INITS);
    }

    public QPreferenceShop(Path<? extends PreferenceShop> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferenceShop(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferenceShop(PathMetadata metadata, PathInits inits) {
        this(PreferenceShop.class, metadata, inits);
    }

    public QPreferenceShop(Class<? extends PreferenceShop> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tag = inits.isInitialized("tag") ? new com.cherrypicker.cherrypick3r.tag.domain.QTag(forProperty("tag")) : null;
    }

}

