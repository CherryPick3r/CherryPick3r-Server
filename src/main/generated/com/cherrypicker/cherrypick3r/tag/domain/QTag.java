package com.cherrypicker.cherrypick3r.tag.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTag is a Querydsl query type for Tag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTag extends EntityPathBase<Tag> {

    private static final long serialVersionUID = -675512545L;

    public static final QTag tag = new QTag("tag");

    public final com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity _super = new com.cherrypicker.cherrypick3r.global.aop.baseTimeEntity.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Double> tagValue1 = createNumber("tagValue1", Double.class);

    public final NumberPath<Double> tagValue10 = createNumber("tagValue10", Double.class);

    public final NumberPath<Double> tagValue11 = createNumber("tagValue11", Double.class);

    public final NumberPath<Double> tagValue12 = createNumber("tagValue12", Double.class);

    public final NumberPath<Double> tagValue13 = createNumber("tagValue13", Double.class);

    public final NumberPath<Double> tagValue14 = createNumber("tagValue14", Double.class);

    public final NumberPath<Double> tagValue15 = createNumber("tagValue15", Double.class);

    public final NumberPath<Double> tagValue16 = createNumber("tagValue16", Double.class);

    public final NumberPath<Double> tagValue17 = createNumber("tagValue17", Double.class);

    public final NumberPath<Double> tagValue18 = createNumber("tagValue18", Double.class);

    public final NumberPath<Double> tagValue19 = createNumber("tagValue19", Double.class);

    public final NumberPath<Double> tagValue2 = createNumber("tagValue2", Double.class);

    public final NumberPath<Double> tagValue20 = createNumber("tagValue20", Double.class);

    public final NumberPath<Double> tagValue21 = createNumber("tagValue21", Double.class);

    public final NumberPath<Double> tagValue22 = createNumber("tagValue22", Double.class);

    public final NumberPath<Double> tagValue23 = createNumber("tagValue23", Double.class);

    public final NumberPath<Double> tagValue24 = createNumber("tagValue24", Double.class);

    public final NumberPath<Double> tagValue25 = createNumber("tagValue25", Double.class);

    public final NumberPath<Double> tagValue26 = createNumber("tagValue26", Double.class);

    public final NumberPath<Double> tagValue27 = createNumber("tagValue27", Double.class);

    public final NumberPath<Double> tagValue28 = createNumber("tagValue28", Double.class);

    public final NumberPath<Double> tagValue3 = createNumber("tagValue3", Double.class);

    public final NumberPath<Double> tagValue4 = createNumber("tagValue4", Double.class);

    public final NumberPath<Double> tagValue5 = createNumber("tagValue5", Double.class);

    public final NumberPath<Double> tagValue6 = createNumber("tagValue6", Double.class);

    public final NumberPath<Double> tagValue7 = createNumber("tagValue7", Double.class);

    public final NumberPath<Double> tagValue8 = createNumber("tagValue8", Double.class);

    public final NumberPath<Double> tagValue9 = createNumber("tagValue9", Double.class);

    public QTag(String variable) {
        super(Tag.class, forVariable(variable));
    }

    public QTag(Path<? extends Tag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTag(PathMetadata metadata) {
        super(Tag.class, metadata);
    }

}

