package com.cherrypicker.cherrypick3r.preference.dto;

import com.cherrypicker.cherrypick3r.tag.dto.TagPairDto;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class PreferenceCard {

    public List<TagPairDto> topTags;

    @Builder
    public PreferenceCard(List<TagPairDto> topTags) {
        this.topTags = topTags;
    }

    public PreferenceCard() {
        this.topTags = null;
    }
}
