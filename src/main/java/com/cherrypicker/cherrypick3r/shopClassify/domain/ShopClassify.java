package com.cherrypicker.cherrypick3r.shopClassify.domain;

import com.cherrypicker.cherrypick3r.global.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shopClassify.dto.ShopClassifyDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
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
@Table(name="SHOP_CLASSIFY_TABLE")
public class ShopClassify extends BaseTimeEntity {

    @Id
    @Column(name = "shop_classify_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_classify_tag_1")
    private Long shopClassifyTag1;

    @Column(name = "shop_classify_tag_2")
    private Long shopClassifyTag2;

    @Column(name = "shop_classify_tag_3")
    private Long shopClassifyTag3;

    @Column(name = "shop_classify_tag_4")
    private Long shopClassifyTag4;

    @Column(name = "shop_classify_tag_5")
    private Long shopClassifyTag5;

    @Column(name = "shop_classify_tag_6")
    private Long shopClassifyTag6;

    @Column(name = "shop_classify_tag_7")
    private Long shopClassifyTag7;

    @Column(name = "shop_classify_tag_8")
    private Long shopClassifyTag8;

    @Column(name = "shop_classify_tag_9")
    private Long shopClassifyTag9;

    @Column(name = "shop_classify_tag_10")
    private Long shopClassifyTag10;

    @Column(name = "shop_classify_tag_11")
    private Long shopClassifyTag11;

    @Column(name = "shop_classify_tag_12")
    private Long shopClassifyTag12;

    @Column(name = "shop_classify_tag_13")
    private Long shopClassifyTag13;

    @Column(name = "shop_classify_tag_14")
    private Long shopClassifyTag14;

    @Column(name = "shop_classify_tag_15")
    private Long shopClassifyTag15;

    @Column(name = "shop_classify_tag_16")
    private Long shopClassifyTag16;

    @Column(name = "shop_classify_tag_17")
    private Long shopClassifyTag17;

    @Column(name = "shop_classify_tag_18")
    private Long shopClassifyTag18;

    @Column(name = "shop_classify_tag_19")
    private Long shopClassifyTag19;

    @Column(name = "shop_classify_tag_20")
    private Long shopClassifyTag20;

    @Column(name = "shop_classify_tag_21")
    private Long shopClassifyTag21;

    @Column(name = "shop_classify_tag_22")
    private Long shopClassifyTag22;

    @Column(name = "shop_classify_tag_23")
    private Long shopClassifyTag23;

    @Column(name = "shop_classify_tag_24")
    private Long shopClassifyTag24;

    @Column(name = "shop_classify_tag_25")
    private Long shopClassifyTag25;

    @Column(name = "shop_classify_tag_26")
    private Long shopClassifyTag26;

    @Column(name = "shop_classify_tag_27")
    private Long shopClassifyTag27;

    @Column(name = "shop_classify_tag_28")
    private Long shopClassifyTag28;

    @OneToOne
    @JoinColumn(name = "shop_id")
    @JsonBackReference
    private Shop shop;

    @Builder
    public ShopClassify(Long shopClassifyTag1, Long shopClassifyTag2, Long shopClassifyTag3, Long shopClassifyTag4, Long shopClassifyTag5,
               Long shopClassifyTag6, Long shopClassifyTag7, Long shopClassifyTag8, Long shopClassifyTag9, Long shopClassifyTag10,
               Long shopClassifyTag11, Long shopClassifyTag12, Long shopClassifyTag13, Long shopClassifyTag14, Long shopClassifyTag15,
               Long shopClassifyTag16, Long shopClassifyTag17, Long shopClassifyTag18, Long shopClassifyTag19, Long shopClassifyTag20,
               Long shopClassifyTag21, Long shopClassifyTag22, Long shopClassifyTag23, Long shopClassifyTag24, Long shopClassifyTag25,
               Long shopClassifyTag26, Long shopClassifyTag27, Long shopClassifyTag28, Shop shop)  {
        this.shopClassifyTag1 = shopClassifyTag1;
        this.shopClassifyTag2 = shopClassifyTag2;
        this.shopClassifyTag3 = shopClassifyTag3;
        this.shopClassifyTag4 = shopClassifyTag4;
        this.shopClassifyTag5 = shopClassifyTag5;
        this.shopClassifyTag6 = shopClassifyTag6;
        this.shopClassifyTag7 = shopClassifyTag7;
        this.shopClassifyTag8 = shopClassifyTag8;
        this.shopClassifyTag9 = shopClassifyTag9;
        this.shopClassifyTag10 = shopClassifyTag10;
        this.shopClassifyTag11 = shopClassifyTag11;
        this.shopClassifyTag12 = shopClassifyTag12;
        this.shopClassifyTag13 = shopClassifyTag13;
        this.shopClassifyTag14 = shopClassifyTag14;
        this.shopClassifyTag15 = shopClassifyTag15;
        this.shopClassifyTag16 = shopClassifyTag16;
        this.shopClassifyTag17 = shopClassifyTag17;
        this.shopClassifyTag18 = shopClassifyTag18;
        this.shopClassifyTag19 = shopClassifyTag19;
        this.shopClassifyTag20 = shopClassifyTag20;
        this.shopClassifyTag21 = shopClassifyTag21;
        this.shopClassifyTag22 = shopClassifyTag22;
        this.shopClassifyTag23 = shopClassifyTag23;
        this.shopClassifyTag24 = shopClassifyTag24;
        this.shopClassifyTag25 = shopClassifyTag25;
        this.shopClassifyTag26 = shopClassifyTag26;
        this.shopClassifyTag27 = shopClassifyTag27;
        this.shopClassifyTag28 = shopClassifyTag28;
        this.shop = shop;
    }

    public ShopClassify(Shop shop) {
        this.shopClassifyTag1 = 0L;
        this.shopClassifyTag2 = 0L;
        this.shopClassifyTag3 = 0L;
        this.shopClassifyTag4 = 0L;
        this.shopClassifyTag5 = 0L;
        this.shopClassifyTag6 = 0L;
        this.shopClassifyTag7 = 0L;
        this.shopClassifyTag8 = 0L;
        this.shopClassifyTag9 = 0L;
        this.shopClassifyTag10 = 0L;
        this.shopClassifyTag11 = 0L;
        this.shopClassifyTag12 = 0L;
        this.shopClassifyTag13 = 0L;
        this.shopClassifyTag14 = 0L;
        this.shopClassifyTag15 = 0L;
        this.shopClassifyTag16 = 0L;
        this.shopClassifyTag17 = 0L;
        this.shopClassifyTag18 = 0L;
        this.shopClassifyTag19 = 0L;
        this.shopClassifyTag20 = 0L;
        this.shopClassifyTag21 = 0L;
        this.shopClassifyTag22 = 0L;
        this.shopClassifyTag23 = 0L;
        this.shopClassifyTag24 = 0L;
        this.shopClassifyTag25 = 0L;
        this.shopClassifyTag26 = 0L;
        this.shopClassifyTag27 = 0L;
        this.shopClassifyTag28 = 0L;
        this.shop = shop;
    }

    public List<Long> getShopClassifyByList() {
        List<Long> shopClassify = new ArrayList<>();

        shopClassify.add(this.shopClassifyTag1);
        shopClassify.add(this.shopClassifyTag2);
        shopClassify.add(this.shopClassifyTag3);
        shopClassify.add(this.shopClassifyTag4);
        shopClassify.add(this.shopClassifyTag5);
        shopClassify.add(this.shopClassifyTag6);
        shopClassify.add(this.shopClassifyTag7);
        shopClassify.add(this.shopClassifyTag8);
        shopClassify.add(this.shopClassifyTag9);
        shopClassify.add(this.shopClassifyTag10);
        shopClassify.add(this.shopClassifyTag11);
        shopClassify.add(this.shopClassifyTag12);
        shopClassify.add(this.shopClassifyTag13);
        shopClassify.add(this.shopClassifyTag14);
        shopClassify.add(this.shopClassifyTag15);
        shopClassify.add(this.shopClassifyTag16);
        shopClassify.add(this.shopClassifyTag17);
        shopClassify.add(this.shopClassifyTag18);
        shopClassify.add(this.shopClassifyTag19);
        shopClassify.add(this.shopClassifyTag20);
        shopClassify.add(this.shopClassifyTag21);
        shopClassify.add(this.shopClassifyTag22);
        shopClassify.add(this.shopClassifyTag23);
        shopClassify.add(this.shopClassifyTag24);
        shopClassify.add(this.shopClassifyTag25);
        shopClassify.add(this.shopClassifyTag26);
        shopClassify.add(this.shopClassifyTag27);
        shopClassify.add(this.shopClassifyTag28);

        return (shopClassify);
    }

    public void setShopClassifyByList(List<Long> shopClassify) {
        this.shopClassifyTag1 = shopClassify.get(0);
        this.shopClassifyTag2 = shopClassify.get(1);
        this.shopClassifyTag3 = shopClassify.get(2);
        this.shopClassifyTag4 = shopClassify.get(3);
        this.shopClassifyTag5 = shopClassify.get(4);
        this.shopClassifyTag6 = shopClassify.get(5);
        this.shopClassifyTag7 = shopClassify.get(6);
        this.shopClassifyTag8 = shopClassify.get(7);
        this.shopClassifyTag9 = shopClassify.get(8);
        this.shopClassifyTag10 = shopClassify.get(9);
        this.shopClassifyTag11 = shopClassify.get(10);
        this.shopClassifyTag12 = shopClassify.get(11);
        this.shopClassifyTag13 = shopClassify.get(12);
        this.shopClassifyTag14 = shopClassify.get(13);
        this.shopClassifyTag15 = shopClassify.get(14);
        this.shopClassifyTag16 = shopClassify.get(15);
        this.shopClassifyTag17 = shopClassify.get(16);
        this.shopClassifyTag18 = shopClassify.get(17);
        this.shopClassifyTag19 = shopClassify.get(18);
        this.shopClassifyTag20 = shopClassify.get(19);
        this.shopClassifyTag21 = shopClassify.get(20);
        this.shopClassifyTag22 = shopClassify.get(21);
        this.shopClassifyTag23 = shopClassify.get(22);
        this.shopClassifyTag24 = shopClassify.get(23);
        this.shopClassifyTag25 = shopClassify.get(24);
        this.shopClassifyTag26 = shopClassify.get(25);
        this.shopClassifyTag27 = shopClassify.get(26);
        this.shopClassifyTag28 = shopClassify.get(27);

        return ;
    }

    public ShopClassifyDto toDto() {
        return ShopClassifyDto.builder()
                .id(this.id)
                .shopClassifyTags(this.getShopClassifyByList())
                .build();
    }

}
