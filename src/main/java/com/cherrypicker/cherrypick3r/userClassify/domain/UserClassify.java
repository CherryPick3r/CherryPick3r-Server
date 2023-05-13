package com.cherrypicker.cherrypick3r.userClassify.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.userClassify.dto.UserClassifyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="USER_CLASSIFY_TABLE")
public class UserClassify extends BaseTimeEntity {

    @Id
    @Column(name = "user_classify_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_classify_tag_1")
    private Long userClassifyTag1;

    @Column(name = "user_classify_tag_2")
    private Long userClassifyTag2;

    @Column(name = "user_classify_tag_3")
    private Long userClassifyTag3;

    @Column(name = "user_classify_tag_4")
    private Long userClassifyTag4;

    @Column(name = "user_classify_tag_5")
    private Long userClassifyTag5;

    @Column(name = "user_classify_tag_6")
    private Long userClassifyTag6;

    @Column(name = "user_classify_tag_7")
    private Long userClassifyTag7;

    @Column(name = "user_classify_tag_8")
    private Long userClassifyTag8;

    @Column(name = "user_classify_tag_9")
    private Long userClassifyTag9;

    @Column(name = "user_classify_tag_10")
    private Long userClassifyTag10;

    @Column(name = "user_classify_tag_11")
    private Long userClassifyTag11;

    @Column(name = "user_classify_tag_12")
    private Long userClassifyTag12;

    @Column(name = "user_classify_tag_13")
    private Long userClassifyTag13;

    @Column(name = "user_classify_tag_14")
    private Long userClassifyTag14;

    @Column(name = "user_classify_tag_15")
    private Long userClassifyTag15;

    @Column(name = "user_classify_tag_16")
    private Long userClassifyTag16;

    @Column(name = "user_classify_tag_17")
    private Long userClassifyTag17;

    @Column(name = "user_classify_tag_18")
    private Long userClassifyTag18;

    @Column(name = "user_classify_tag_19")
    private Long userClassifyTag19;

    @Column(name = "user_classify_tag_20")
    private Long userClassifyTag20;

    @Column(name = "user_classify_tag_21")
    private Long userClassifyTag21;

    @Column(name = "user_classify_tag_22")
    private Long userClassifyTag22;

    @Column(name = "user_classify_tag_23")
    private Long userClassifyTag23;

    @Column(name = "user_classify_tag_24")
    private Long userClassifyTag24;

    @Column(name = "user_classify_tag_25")
    private Long userClassifyTag25;

    @Column(name = "user_classify_tag_26")
    private Long userClassifyTag26;

    @Column(name = "user_classify_tag_27")
    private Long userClassifyTag27;

    @Column(name = "user_classify_tag_28")
    private Long userClassifyTag28;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_email")
    private User user;

    @Builder
    public UserClassify(Long userClassifyTag1, Long userClassifyTag2, Long userClassifyTag3, Long userClassifyTag4, Long userClassifyTag5,
                        Long userClassifyTag6, Long userClassifyTag7, Long userClassifyTag8, Long userClassifyTag9, Long userClassifyTag10,
                        Long userClassifyTag11, Long userClassifyTag12, Long userClassifyTag13, Long userClassifyTag14, Long userClassifyTag15,
                        Long userClassifyTag16, Long userClassifyTag17, Long userClassifyTag18, Long userClassifyTag19, Long userClassifyTag20,
                        Long userClassifyTag21, Long userClassifyTag22, Long userClassifyTag23, Long userClassifyTag24, Long userClassifyTag25,
                        Long userClassifyTag26, Long userClassifyTag27, Long userClassifyTag28, User user)  {
        this.userClassifyTag1 = userClassifyTag1;
        this.userClassifyTag2 = userClassifyTag2;
        this.userClassifyTag3 = userClassifyTag3;
        this.userClassifyTag4 = userClassifyTag4;
        this.userClassifyTag5 = userClassifyTag5;
        this.userClassifyTag6 = userClassifyTag6;
        this.userClassifyTag7 = userClassifyTag7;
        this.userClassifyTag8 = userClassifyTag8;
        this.userClassifyTag9 = userClassifyTag9;
        this.userClassifyTag10 = userClassifyTag10;
        this.userClassifyTag11 = userClassifyTag11;
        this.userClassifyTag12 = userClassifyTag12;
        this.userClassifyTag13 = userClassifyTag13;
        this.userClassifyTag14 = userClassifyTag14;
        this.userClassifyTag15 = userClassifyTag15;
        this.userClassifyTag16 = userClassifyTag16;
        this.userClassifyTag17 = userClassifyTag17;
        this.userClassifyTag18 = userClassifyTag18;
        this.userClassifyTag19 = userClassifyTag19;
        this.userClassifyTag20 = userClassifyTag20;
        this.userClassifyTag21 = userClassifyTag21;
        this.userClassifyTag22 = userClassifyTag22;
        this.userClassifyTag23 = userClassifyTag23;
        this.userClassifyTag24 = userClassifyTag24;
        this.userClassifyTag25 = userClassifyTag25;
        this.userClassifyTag26 = userClassifyTag26;
        this.userClassifyTag27 = userClassifyTag27;
        this.userClassifyTag28 = userClassifyTag28;
        this.user = user;
    }

    public UserClassify(User user) {
        this.userClassifyTag1 = 0L;
        this.userClassifyTag2 = 0L;
        this.userClassifyTag3 = 0L;
        this.userClassifyTag4 = 0L;
        this.userClassifyTag5 = 0L;
        this.userClassifyTag6 = 0L;
        this.userClassifyTag7 = 0L;
        this.userClassifyTag8 = 0L;
        this.userClassifyTag9 = 0L;
        this.userClassifyTag10 = 0L;
        this.userClassifyTag11 = 0L;
        this.userClassifyTag12 = 0L;
        this.userClassifyTag13 = 0L;
        this.userClassifyTag14 = 0L;
        this.userClassifyTag15 = 0L;
        this.userClassifyTag16 = 0L;
        this.userClassifyTag17 = 0L;
        this.userClassifyTag18 = 0L;
        this.userClassifyTag19 = 0L;
        this.userClassifyTag20 = 0L;
        this.userClassifyTag21 = 0L;
        this.userClassifyTag22 = 0L;
        this.userClassifyTag23 = 0L;
        this.userClassifyTag24 = 0L;
        this.userClassifyTag25 = 0L;
        this.userClassifyTag26 = 0L;
        this.userClassifyTag27 = 0L;
        this.userClassifyTag28 = 0L;
        this.user = user;
    }

    public List<Long> getUserClassifyByList() {
        List<Long> userClassify = new ArrayList<>();

        userClassify.add(this.userClassifyTag1);
        userClassify.add(this.userClassifyTag2);
        userClassify.add(this.userClassifyTag3);
        userClassify.add(this.userClassifyTag4);
        userClassify.add(this.userClassifyTag5);
        userClassify.add(this.userClassifyTag6);
        userClassify.add(this.userClassifyTag7);
        userClassify.add(this.userClassifyTag8);
        userClassify.add(this.userClassifyTag9);
        userClassify.add(this.userClassifyTag10);
        userClassify.add(this.userClassifyTag11);
        userClassify.add(this.userClassifyTag12);
        userClassify.add(this.userClassifyTag13);
        userClassify.add(this.userClassifyTag14);
        userClassify.add(this.userClassifyTag15);
        userClassify.add(this.userClassifyTag16);
        userClassify.add(this.userClassifyTag17);
        userClassify.add(this.userClassifyTag18);
        userClassify.add(this.userClassifyTag19);
        userClassify.add(this.userClassifyTag20);
        userClassify.add(this.userClassifyTag21);
        userClassify.add(this.userClassifyTag22);
        userClassify.add(this.userClassifyTag23);
        userClassify.add(this.userClassifyTag24);
        userClassify.add(this.userClassifyTag25);
        userClassify.add(this.userClassifyTag26);
        userClassify.add(this.userClassifyTag27);
        userClassify.add(this.userClassifyTag28);

        return (userClassify);
    }

    public void setShopClassifyByList(List<Long> userClassify) {
        this.userClassifyTag1 = userClassify.get(0);
        this.userClassifyTag3 = userClassify.get(2);
        this.userClassifyTag4 = userClassify.get(3);
        this.userClassifyTag5 = userClassify.get(4);
        this.userClassifyTag6 = userClassify.get(5);
        this.userClassifyTag7 = userClassify.get(6);
        this.userClassifyTag8 = userClassify.get(7);
        this.userClassifyTag9 = userClassify.get(8);
        this.userClassifyTag10 = userClassify.get(9);
        this.userClassifyTag11 = userClassify.get(10);
        this.userClassifyTag12 = userClassify.get(11);
        this.userClassifyTag13 = userClassify.get(12);
        this.userClassifyTag14 = userClassify.get(13);
        this.userClassifyTag15 = userClassify.get(14);
        this.userClassifyTag16 = userClassify.get(15);
        this.userClassifyTag17 = userClassify.get(16);
        this.userClassifyTag18 = userClassify.get(17);
        this.userClassifyTag19 = userClassify.get(18);
        this.userClassifyTag20 = userClassify.get(19);
        this.userClassifyTag21 = userClassify.get(20);
        this.userClassifyTag22 = userClassify.get(21);
        this.userClassifyTag23 = userClassify.get(22);
        this.userClassifyTag24 = userClassify.get(23);
        this.userClassifyTag25 = userClassify.get(24);
        this.userClassifyTag26 = userClassify.get(25);
        this.userClassifyTag27 = userClassify.get(26);
        this.userClassifyTag28 = userClassify.get(27);

        return ;
    }

    public UserClassifyDto toDto() {
        return UserClassifyDto.builder()
                .id(this.id)
                .userClassifyTags(this.getUserClassifyByList())
                .user(this.user)
                .build();
    }
}
