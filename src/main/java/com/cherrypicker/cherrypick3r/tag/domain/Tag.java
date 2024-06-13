package com.cherrypicker.cherrypick3r.tag.domain;

import com.cherrypicker.cherrypick3r.global.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.tag.dto.TagDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name="TAG_TABLE")
public class Tag extends BaseTimeEntity {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_value_1")
    private Double tagValue1;

    @Column(name = "tag_value_2")
    private Double tagValue2;

    @Column(name = "tag_value_3")
    private Double tagValue3;

    @Column(name = "tag_value_4")
    private Double tagValue4;

    @Column(name = "tag_value_5")
    private Double tagValue5;

    @Column(name = "tag_value_6")
    private Double tagValue6;

    @Column(name = "tag_value_7")
    private Double tagValue7;

    @Column(name = "tag_value_8")
    private Double tagValue8;

    @Column(name = "tag_value_9")
    private Double tagValue9;

    @Column(name = "tag_value_10")
    private Double tagValue10;

    @Column(name = "tag_value_11")
    private Double tagValue11;

    @Column(name = "tag_value_12")
    private Double tagValue12;

    @Column(name = "tag_value_13")
    private Double tagValue13;

    @Column(name = "tag_value_14")
    private Double tagValue14;

    @Column(name = "tag_value_15")
    private Double tagValue15;

    @Column(name = "tag_value_16")
    private Double tagValue16;

    @Column(name = "tag_value_17")
    private Double tagValue17;

    @Column(name = "tag_value_18")
    private Double tagValue18;

    @Column(name = "tag_value_19")
    private Double tagValue19;

    @Column(name = "tag_value_20")
    private Double tagValue20;

    @Column(name = "tag_value_21")
    private Double tagValue21;

    @Column(name = "tag_value_22")
    private Double tagValue22;

    @Column(name = "tag_value_23")
    private Double tagValue23;

    @Column(name = "tag_value_24")
    private Double tagValue24;

    @Column(name = "tag_value_25")
    private Double tagValue25;

    @Column(name = "tag_value_26")
    private Double tagValue26;

    @Column(name = "tag_value_27")
    private Double tagValue27;

    @Column(name = "tag_value_28")
    private Double tagValue28;

    @Builder
    public Tag(Double tagValue1, Double tagValue2, Double tagValue3, Double tagValue4, Double tagValue5,
               Double tagValue6, Double tagValue7, Double tagValue8, Double tagValue9, Double tagValue10,
               Double tagValue11, Double tagValue12, Double tagValue13, Double tagValue14, Double tagValue15,
               Double tagValue16, Double tagValue17, Double tagValue18, Double tagValue19, Double tagValue20,
               Double tagValue21, Double tagValue22, Double tagValue23, Double tagValue24, Double tagValue25,
               Double tagValue26, Double tagValue27, Double tagValue28)  {
        this.tagValue1 = tagValue1;
        this.tagValue2 = tagValue2;
        this.tagValue3 = tagValue3;
        this.tagValue4 = tagValue4;
        this.tagValue5 = tagValue5;
        this.tagValue6 = tagValue6;
        this.tagValue7 = tagValue7;
        this.tagValue8 = tagValue8;
        this.tagValue9 = tagValue9;
        this.tagValue10 = tagValue10;
        this.tagValue11 = tagValue11;
        this.tagValue12 = tagValue12;
        this.tagValue13 = tagValue13;
        this.tagValue14 = tagValue14;
        this.tagValue15 = tagValue15;
        this.tagValue16 = tagValue16;
        this.tagValue17 = tagValue17;
        this.tagValue18 = tagValue18;
        this.tagValue19 = tagValue19;
        this.tagValue20 = tagValue20;
        this.tagValue21 = tagValue21;
        this.tagValue22 = tagValue22;
        this.tagValue23 = tagValue23;
        this.tagValue24 = tagValue24;
        this.tagValue25 = tagValue25;
        this.tagValue26 = tagValue26;
        this.tagValue27 = tagValue27;
        this.tagValue28 = tagValue28;
    }

    public Tag() {
        this.tagValue1 = 0D;
        this.tagValue2 = 0D;
        this.tagValue3 = 0D;
        this.tagValue4 = 0D;
        this.tagValue5 = 0D;
        this.tagValue6 = 0D;
        this.tagValue7 = 0D;
        this.tagValue8 = 0D;
        this.tagValue9 = 0D;
        this.tagValue10 = 0D;
        this.tagValue11 = 0D;
        this.tagValue12 = 0D;
        this.tagValue13 = 0D;
        this.tagValue14 = 0D;
        this.tagValue15 = 0D;
        this.tagValue16 = 0D;
        this.tagValue17 = 0D;
        this.tagValue18 = 0D;
        this.tagValue19 = 0D;
        this.tagValue20 = 0D;
        this.tagValue21 = 0D;
        this.tagValue22 = 0D;
        this.tagValue23 = 0D;
        this.tagValue24 = 0D;
        this.tagValue25 = 0D;
        this.tagValue26 = 0D;
        this.tagValue27 = 0D;
        this.tagValue28 = 0D;
    }

    public List<Double> getTagsByList() {
        List<Double> tags = new ArrayList<>();

        tags.add(this.tagValue1);
        tags.add(this.tagValue2);
        tags.add(this.tagValue3);
        tags.add(this.tagValue4);
        tags.add(this.tagValue5);
        tags.add(this.tagValue6);
        tags.add(this.tagValue7);
        tags.add(this.tagValue8);
        tags.add(this.tagValue9);
        tags.add(this.tagValue10);
        tags.add(this.tagValue11);
        tags.add(this.tagValue12);
        tags.add(this.tagValue13);
        tags.add(this.tagValue14);
        tags.add(this.tagValue15);
        tags.add(this.tagValue16);
        tags.add(this.tagValue17);
        tags.add(this.tagValue18);
        tags.add(this.tagValue19);
        tags.add(this.tagValue20);
        tags.add(this.tagValue21);
        tags.add(this.tagValue22);
        tags.add(this.tagValue23);
        tags.add(this.tagValue24);
        tags.add(this.tagValue25);
        tags.add(this.tagValue26);
        tags.add(this.tagValue27);
        tags.add(this.tagValue28);

        return (tags);
    }

    public void setTagsByList(List<Double> tags) {
        this.tagValue1 = tags.get(0);
        this.tagValue2 = tags.get(1);
        this.tagValue3 = tags.get(2);
        this.tagValue4 = tags.get(3);
        this.tagValue5 = tags.get(4);
        this.tagValue6 = tags.get(5);
        this.tagValue7 = tags.get(6);
        this.tagValue8 = tags.get(7);
        this.tagValue9 = tags.get(8);
        this.tagValue10 = tags.get(9);
        this.tagValue11 = tags.get(10);
        this.tagValue12 = tags.get(11);
        this.tagValue13 = tags.get(12);
        this.tagValue14 = tags.get(13);
        this.tagValue15 = tags.get(14);
        this.tagValue16 = tags.get(15);
        this.tagValue17 = tags.get(16);
        this.tagValue18 = tags.get(17);
        this.tagValue19 = tags.get(18);
        this.tagValue20 = tags.get(19);
        this.tagValue21 = tags.get(20);
        this.tagValue22 = tags.get(21);
        this.tagValue23 = tags.get(22);
        this.tagValue24 = tags.get(23);
        this.tagValue25 = tags.get(24);
        this.tagValue26 = tags.get(25);
        this.tagValue27 = tags.get(26);
        this.tagValue28 = tags.get(27);

        return ;
    }

    public TagDto toDto() {
        return TagDto.builder()
                .id(this.id)
                .tagValues(this.getTagsByList())
                .build();
    }
}
