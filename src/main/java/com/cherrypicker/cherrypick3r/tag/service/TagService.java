package com.cherrypicker.cherrypick3r.tag.service;

import com.cherrypicker.cherrypick3r.component.TagType;
import com.cherrypicker.cherrypick3r.shop.service.ShopSearchService;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.tag.dto.TagDescriptionDto;
import com.cherrypicker.cherrypick3r.tag.dto.TagDto;
import com.cherrypicker.cherrypick3r.tag.dto.TagPairDto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagService {

    private final TagSearchService tagSearchService;

    private final TagRepository tagRepository;

    private final ShopSearchService shopSearchService;

    @Transactional
    public Tag createTag() {
        Tag tag = new Tag();

        tag = tagRepository.save(tag);

        return tag;
    }

    @Transactional
    public TagDto findTagByTagId(Long id) {
        Tag tag = tagSearchService.findTagById(id);

        return tag.toDto();
    }

    @Transactional
    public void deleteTagByTagId(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    public TagDto updateTagByTagId(Long id, List<Double> tagValues) {
        Tag tag = tagSearchService.findTagById(id);

        tag.setTagsByList(tagValues);
        tagRepository.save(tag);

        return findTagByTagId(id);
    }

    // 태그를 받아서 가게의 태그를 TagDescriptionDto로 바꿔주는 메서드
    @Transactional
    public TagDescriptionDto getTagDescriptionDtoListByTag(Tag tag) {
        List<Double> tagValues = tag.getTagsByList();

        List<TagPairDto> tagPairDtos = new ArrayList<>();
        int i = 0;
        // 열거형 상수 순회하기
        TagType[] tagTypes = TagType.values();
        for (TagType tagType : tagTypes) {
            tagPairDtos.add(TagPairDto.builder()
                .description(tagType.getDescription())
                .value(tagValues.get(i++))
                .build());
        }

        return new TagDescriptionDto(tagPairDtos);
    }

    // Tag의 상위 5개 태그값을 (설명, 값) 쌍으로 반환해주는 메서드
    @Transactional
    public List<TagPairDto> getTop5TagPairDtoByShopTag(Tag tag) {
        TagDescriptionDto tagDescriptionDto = getTagDescriptionDtoListByTag(tag);
        List<TagPairDto> tagPairDtos = new ArrayList<>();

        // Double형 태그 값을 기준으로 내림차순 정렬
        tagDescriptionDto.getTagPairDtos()
            .sort(Comparator.comparing(TagPairDto::getValue).reversed());

        for (int i = 0; i < 5; i++) {
            tagPairDtos.add(tagDescriptionDto.getTagPairDtos().get(i));
        }

        return tagPairDtos;
    }

}