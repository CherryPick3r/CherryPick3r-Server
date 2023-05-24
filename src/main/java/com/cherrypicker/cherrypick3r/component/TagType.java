package com.cherrypicker.cherrypick3r.component;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TagType {
    CTAG001(0, "이색맛집"),
    CTAG002(1, "컨셉이 독특해요"),
    CTAG003(2, "술집"),
    CTAG004(3, "혼술맛집"),
    CTAG005(4, "코스요리 맛집"),
    CTAG006(5, "차분한 분위기"),
    CTAG007(6, "아늑한 분위기"),
    CTAG008(7, "오래 있기 좋아요"),
    CTAG009(8, "술집"),
    CTAG010(9, "주차하기 편해요"),
    CTAG011(10, "단체모임"),
    CTAG012(11, "로컬맛집"),
    CTAG013(12, "음식이 빨리 나와요"),
    CTAG014(13, "특별한 날 가기 좋아요"),
    CTAG015(14, "신선해요"),
    CTAG016(15, "혼밥하기 좋아요"),
    CTAG017(16, "푸짐해요"),
    CTAG018(17, "단체모임"),
    CTAG019(18, "특별메뉴"),
    CTAG020(19, "감성사진"),
    CTAG021(20, "가성비 맛집"),
    CTAG022(21, "쾌적한 공간"),
    CTAG023(22, "카공맛집"),
    CTAG024(23, "친절해요"),
    CTAG025(24, "카페"),
    CTAG026(25, "커피맛집"),
    CTAG027(26, "맛있는 디저트"),
    CTAG028(27, "맛있는 음료");

    private final int idx;
    private final String description;
    private TagType(int idx, String description) {
        this.idx = idx;
        this.description = description;
    }

}
