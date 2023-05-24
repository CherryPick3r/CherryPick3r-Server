package com.cherrypicker.cherrypick3r.Tag.Service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.tag.dto.TagDescriptionDto;
import com.cherrypicker.cherrypick3r.tag.dto.TagPairDto;
import com.cherrypicker.cherrypick3r.tag.service.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagServiceTest {

    private ShopClassifyRepository shopClassifyRepository;
    private ShopRepository shopRepository;
    private TagRepository tagRepository;
    private TagService tagService;

    @Autowired
    public TagServiceTest(ShopClassifyRepository shopClassifyRepository, ShopRepository shopRepository, TagRepository tagRepository, TagService tagService) {
        this.shopClassifyRepository = shopClassifyRepository;
        this.shopRepository = shopRepository;
        this.tagRepository = tagRepository;
        this.tagService = tagService;
    }

    @BeforeEach
    public void beforeEach(){
    }

    @Test
    public void TagDescriptionTest() {
        Shop shop = shopRepository.findById(14L).get();

        List<TagPairDto> tagPairDtos = tagService.getTop5TagPairDtoByShop(shop);

        for (TagPairDto tagPairDto : tagPairDtos) {
            System.out.println("Description : " + tagPairDto.getDescription());
            System.out.println("Value : " + tagPairDto.getValue());
        }
    }
}
