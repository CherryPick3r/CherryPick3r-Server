package com.cherrypicker.cherrypick3r.userClassify.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserClassify is a Querydsl query type for UserClassify
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserClassify extends EntityPathBase<UserClassify> {

    private static final long serialVersionUID = -1328728139L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserClassify userClassify = new QUserClassify("userClassify");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final com.cherrypicker.cherrypick3r.user.domain.QUser user;

    public final NumberPath<Long> userClassifyTag1 = createNumber("userClassifyTag1", Long.class);

    public final NumberPath<Long> userClassifyTag10 = createNumber("userClassifyTag10", Long.class);

    public final NumberPath<Long> userClassifyTag11 = createNumber("userClassifyTag11", Long.class);

    public final NumberPath<Long> userClassifyTag12 = createNumber("userClassifyTag12", Long.class);

    public final NumberPath<Long> userClassifyTag13 = createNumber("userClassifyTag13", Long.class);

    public final NumberPath<Long> userClassifyTag14 = createNumber("userClassifyTag14", Long.class);

    public final NumberPath<Long> userClassifyTag15 = createNumber("userClassifyTag15", Long.class);

    public final NumberPath<Long> userClassifyTag16 = createNumber("userClassifyTag16", Long.class);

    public final NumberPath<Long> userClassifyTag17 = createNumber("userClassifyTag17", Long.class);

    public final NumberPath<Long> userClassifyTag18 = createNumber("userClassifyTag18", Long.class);

    public final NumberPath<Long> userClassifyTag19 = createNumber("userClassifyTag19", Long.class);

    public final NumberPath<Long> userClassifyTag2 = createNumber("userClassifyTag2", Long.class);

    public final NumberPath<Long> userClassifyTag20 = createNumber("userClassifyTag20", Long.class);

    public final NumberPath<Long> userClassifyTag21 = createNumber("userClassifyTag21", Long.class);

    public final NumberPath<Long> userClassifyTag22 = createNumber("userClassifyTag22", Long.class);

    public final NumberPath<Long> userClassifyTag23 = createNumber("userClassifyTag23", Long.class);

    public final NumberPath<Long> userClassifyTag24 = createNumber("userClassifyTag24", Long.class);

    public final NumberPath<Long> userClassifyTag25 = createNumber("userClassifyTag25", Long.class);

    public final NumberPath<Long> userClassifyTag26 = createNumber("userClassifyTag26", Long.class);

    public final NumberPath<Long> userClassifyTag27 = createNumber("userClassifyTag27", Long.class);

    public final NumberPath<Long> userClassifyTag28 = createNumber("userClassifyTag28", Long.class);

    public final NumberPath<Long> userClassifyTag3 = createNumber("userClassifyTag3", Long.class);

    public final NumberPath<Long> userClassifyTag4 = createNumber("userClassifyTag4", Long.class);

    public final NumberPath<Long> userClassifyTag5 = createNumber("userClassifyTag5", Long.class);

    public final NumberPath<Long> userClassifyTag6 = createNumber("userClassifyTag6", Long.class);

    public final NumberPath<Long> userClassifyTag7 = createNumber("userClassifyTag7", Long.class);

    public final NumberPath<Long> userClassifyTag8 = createNumber("userClassifyTag8", Long.class);

    public final NumberPath<Long> userClassifyTag9 = createNumber("userClassifyTag9", Long.class);

    public QUserClassify(String variable) {
        this(UserClassify.class, forVariable(variable), INITS);
    }

    public QUserClassify(Path<? extends UserClassify> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserClassify(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserClassify(PathMetadata metadata, PathInits inits) {
        this(UserClassify.class, metadata, inits);
    }

    public QUserClassify(Class<? extends UserClassify> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.cherrypicker.cherrypick3r.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

