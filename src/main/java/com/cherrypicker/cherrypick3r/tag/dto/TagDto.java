package com.cherrypicker.cherrypick3r.tag.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class TagDto {
    Long id;

    List<Double> tagValues;

    @Builder
    public TagDto(Long id, List<Double> tagValues) {
        this.id = id;
        this.tagValues = tagValues;
    }
}
