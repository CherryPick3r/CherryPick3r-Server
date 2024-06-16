package com.cherrypicker.cherrypick3r.tag.dto;

import java.util.List;
import lombok.Data;

@Data
public class TagDescriptionDto {

    public List<TagPairDto> tagPairDtos;

    public TagDescriptionDto(List<TagPairDto> tagPairDtos) {
        this.tagPairDtos = tagPairDtos;
    }
}
