package com.cherrypicker.cherrypick3r.component;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TagType {
    CTAG001(1L, "이색맛집"),
    CTAG002(2L, "컨셉이 독특해요"),
    CTAG003(3L, "술집"),
    CTAG004(4L, "혼술맛집"),
    CTAG005(5L, "코스요리 맛집"),
    CTAG006(6L, "차분한 분위기"),
    CTAG007(7L, "아늑한 분위기"),
    CTAG008(8L, "오래 있기 좋아요"),
    CTAG009(9L, "술집"),
    CTAG010(10L, "주차하기 편해요"),
    CTAG011(11L, "단체모임"),
    CTAG012(12L, "로컬맛집"),
    CTAG013(13L, "음식이 빨리 나와요"),
    CTAG014(14L, "특별한 날 가기 좋아요"),
    CTAG015(15L, "신선해요"),
    CTAG016(16L, "혼밥하기 좋아요"),
    CTAG017(17L, "푸짐해요"),
    CTAG018(18L, "단체모임"),
    CTAG019(19L, "특별메뉴"),
    CTAG020(20L, "감성사진"),
    CTAG021(21L, "가성비 맛집"),
    CTAG022(22L, "쾌적한 공간"),
    CTAG023(23L, "카공맛집"),
    CTAG024(24L, "친절해요"),
    CTAG025(25L, "카페"),
    CTAG026(26L, "커피맛집"),
    CTAG027(27L, "맛있는 디저트"),
    CTAG028(28L, "맛있는 음료");

    private final Long idx;
    private final String description;
    private TagType(Long idx, String description) {
        this.idx = idx;
        this.description = description;
    }

}
