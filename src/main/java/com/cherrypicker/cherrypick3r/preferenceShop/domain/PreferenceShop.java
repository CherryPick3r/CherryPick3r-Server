package com.cherrypicker.cherrypick3r.preferenceShop.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="PREFERENCE_SHOP_TABLE")
public class PreferenceShop extends BaseTimeEntity {

    @Id
    @Column(name = "preference_shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    public PreferenceShop(Tag tag) {
        this.tag = tag;
    }

    public PreferenceShop(Double tagV1, Double tagV2, Double tagV3, Double tagV4, Double tagV5, Double tagV6, Double tagV7, Double tagV8, Double tagV9, Double tagV10, Double tagV11, Double tagV12, Double tagV13, Double tagV14, Double tagV15, Double tagV16, Double tagV17, Double tagV18, Double tagV19, Double tagV20, Double tagV21, Double tagV22, Double tagV23, Double tagV24, Double tagV25, Double tagV26, Double tagV27, Double tagV28) {
        List<Double> tagValues = new ArrayList<>();
        tagValues.add(tagV1);
        tagValues.add(tagV2);
        tagValues.add(tagV3);
        tagValues.add(tagV4);
        tagValues.add(tagV5);
        tagValues.add(tagV6);
        tagValues.add(tagV7);
        tagValues.add(tagV8);
        tagValues.add(tagV9);
        tagValues.add(tagV10);
        tagValues.add(tagV11);
        tagValues.add(tagV12);
        tagValues.add(tagV13);
        tagValues.add(tagV14);
        tagValues.add(tagV15);
        tagValues.add(tagV16);
        tagValues.add(tagV17);
        tagValues.add(tagV18);
        tagValues.add(tagV19);
        tagValues.add(tagV20);
        tagValues.add(tagV21);
        tagValues.add(tagV22);
        tagValues.add(tagV23);
        tagValues.add(tagV24);
        tagValues.add(tagV25);
        tagValues.add(tagV26);
        tagValues.add(tagV27);
        tagValues.add(tagV28);
        this.tag = new Tag();
        this.tag.setTagsByList(tagValues);
    }
}
