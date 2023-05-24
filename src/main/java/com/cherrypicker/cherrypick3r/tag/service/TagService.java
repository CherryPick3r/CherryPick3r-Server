package com.cherrypicker.cherrypick3r.tag.service;

import com.cherrypicker.cherrypick3r.component.TagType;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.tag.dto.TagDescriptionDto;
import com.cherrypicker.cherrypick3r.tag.dto.TagDto;
import com.cherrypicker.cherrypick3r.tag.dto.TagPairDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService {
    private final TagRepository tagRepository;
    private final ShopRepository shopRepository;

    private final ShopClassifyRepository shopClassifyRepository;

    @Transactional
    public Tag createTag() {
        Tag tag = new Tag();

        tag = tagRepository.save(tag);

        return tag;
    }

    @Transactional
    public TagDto findTagByTagId(Long id) {
        Tag tag = tagRepository.findById(id).get();

        return tag.toDto();
    }

    @Transactional
    public void deleteTagByTagId(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    public TagDto updateTagByTagId(Long id, List<Double> tagValues) {
        Tag tag = tagRepository.findById(id).get();

        if (tag == null) {
            return null; // TODO: TagNotFound 에러 핸들링 해야함
        }
        tag.setTagsByList(tagValues);
        tagRepository.save(tag);

        return findTagByTagId(id);
    }

    // 가게를 받아서 가게의 태그를 TagDescriptionDto로 바꿔주는 메서드
    @Transactional
    public TagDescriptionDto getTagDescriptionDtoListByShop(Shop shop) {
        Tag tag = shop.getTag();
        List<Double> tagValues = tag.getTagsByList();

        List<TagPairDto> tagPairDtos = new ArrayList<>();
        int i = 0;
        // 열거형 상수 순회하기
        for (TagType tagType : TagType.values()) {
            tagPairDtos.add(TagPairDto.builder()
                    .description(tagType.getDescription())
                    .value(tagValues.get(i++))
                    .build());
        }
        TagDescriptionDto tagDescriptionDto = new TagDescriptionDto(tagPairDtos);

        return tagDescriptionDto;
    }

    // shop의 상위 5개 태그값을 (설명, 값) 쌍으로 반환해주는 메서드
    @Transactional
    public List<TagPairDto> getTop5TagPairDtoByShop(Shop shop) {
        TagDescriptionDto tagDescriptionDto = getTagDescriptionDtoListByShop(shop);
        List<TagPairDto> tagPairDtos = new ArrayList<>();

        // Double형 태그 값을 기준으로 내림차순 정렬
        Collections.sort(tagDescriptionDto.getTagPairDtos(), Comparator.comparing(TagPairDto::getValue).reversed());

        for (int i=0;i<5;i++) {
            tagPairDtos.add(tagDescriptionDto.getTagPairDtos().get(i));
        }

        return tagPairDtos;
    }

    // shop의 상위 5개 태그값을 (설명, 값) 쌍으로 반환해주는 메서드
    @Transactional
    public List<TagPairDto> getTop5TagPairDtoByShop(ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();

        TagDescriptionDto tagDescriptionDto = getTagDescriptionDtoListByShop(shop);
        List<TagPairDto> tagPairDtos = new ArrayList<>();

        // Double형 태그 값을 기준으로 내림차순 정렬
        Collections.sort(tagDescriptionDto.getTagPairDtos(), Comparator.comparing(TagPairDto::getValue).reversed());

        for (int i=0;i<5;i++) {
            tagPairDtos.add(tagDescriptionDto.getTagPairDtos().get(i));
        }

        return tagPairDtos;
    }

}