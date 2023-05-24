package com.cherrypicker.cherrypick3r.tag.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDescriptionDto {

    public List<TagPairDto> tagPairDtos;

    public TagDescriptionDto(List<TagPairDto> tagPairDtos) {
        this.tagPairDtos = tagPairDtos;
    }
}
