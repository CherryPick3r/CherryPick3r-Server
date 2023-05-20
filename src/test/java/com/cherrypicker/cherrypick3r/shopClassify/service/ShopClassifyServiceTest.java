package com.cherrypicker.cherrypick3r.shopClassify.service;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassify;
import com.cherrypicker.cherrypick3r.shopClassify.domain.ShopClassifyRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ShopClassifyServiceTest {

    private ShopClassifyRepository shopClassifyRepository;
    private ShopRepository shopRepository;
    private TagRepository tagRepository;

    private ShopClassifyService shopClassifyService;

    @Autowired
    public ShopClassifyServiceTest(ShopClassifyRepository shopClassifyRepository, ShopRepository shopRepository, TagRepository tagRepository, ShopClassifyService shopClassifyService) {
        this.shopClassifyRepository = shopClassifyRepository;
        this.shopRepository = shopRepository;
        this.tagRepository = tagRepository;
        this.shopClassifyService = shopClassifyService;
    }

    @BeforeEach
    public void beforeEach(){
        shopClassifyRepository.deleteAll();
        shopRepository.deleteAll();
        tagRepository.deleteAll();
    }

    @Test
    public void shopCreate() {
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag)
                .build();

        tagRepository.save(tag);
        shopRepository.save(shop);

        Shop shop1 = shopRepository.findAll().get(0);

        Assertions.assertEquals(shop1.getPhone(), phone);
        Assertions.assertEquals(shop1.getName(), name);
        Assertions.assertEquals(shop1.getAddress(), address);
        Assertions.assertEquals(shop1.getAddressPointX(), addressPointX);
        Assertions.assertEquals(shop1.getAddressPointY(), addressPointY);
        Assertions.assertEquals(shop1.getClippingCount(), clippingCount);
        Assertions.assertEquals(shop1.getPickedCount(), pickedCount);
        Assertions.assertEquals(shop1.getOperatingHours(), operatingHours);
        Assertions.assertEquals(shop1.getOnelineReview(), onelineReview);
        Assertions.assertEquals(shop1.getMainPhotoUrl1(), mainPhotoUrl1);
        Assertions.assertEquals(shop1.getMainPhotoUrl2(), mainPhotoUrl2);
        Assertions.assertEquals(shop1.getTag().getId(), tag.getId());
    }

    @Test
    public void ShopClassifyCreate() {
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag = new Tag();
        tagRepository.save(tag);

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag)
                .build();

        shopRepository.save(shop);

        ShopClassify shopClassify = new ShopClassify(shop);

        shopClassifyRepository.save(shopClassify);

        ShopClassify shopClassify1 = shopClassifyRepository.findAll().get(0);

        Assertions.assertEquals(shopClassify1.getId(), shopClassify.getId());
    }

    @Test
    public void ShopClassifyServiceMakeShopClassifyUsingTagValuesTest() {
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag)
                .build();

        tagRepository.save(tag);
        shopRepository.save(shop);

        // 인덱스가 홀수는 0.1, 짝수는 0.6으로 넣은 28개의 값의 List
        List<Double> tagValues = new ArrayList<>();

        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                tagValues.add(0.6D);
            }
            else {
                tagValues.add(0.1D);
            }
        }

        tag.setTagsByList(tagValues);
        tagRepository.save(tag);

        shopClassifyService.makeShopClassifyUsingTagValues(shop, 0.5);

        ShopClassify shopClassify = shopClassifyRepository.findAll().get(0);
        List<Long> shopClassifyValues = shopClassify.getShopClassifyByList();

        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                Assertions.assertEquals(shopClassifyValues.get(i), 1L);
            }
            else {
                Assertions.assertEquals(shopClassifyValues.get(i), 0L);
            }
        }
    }

    @Test
    public void ShopClassifyServiceMakeAllShopClassifyUsingTagValuesTest() {
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag)
                .build();

        tagRepository.save(tag);
        shopRepository.save(shop);

        // 인덱스가 홀수는 0.1, 짝수는 0.6으로 넣은 28개의 값의 List
        List<Double> tagValues = new ArrayList<>();

        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                tagValues.add(0.6D);
            }
            else {
                tagValues.add(0.1D);
            }
        }

        tag.setTagsByList(tagValues);
        tagRepository.save(tag);

        shopClassifyService.makeAllShopClassifyUsingTagValues(0.5);

        ShopClassify shopClassify = shopClassifyRepository.findAll().get(0);
        List<Long> shopClassifyValues = shopClassify.getShopClassifyByList();

        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                Assertions.assertEquals(shopClassifyValues.get(i), 1L);
            }
            else {
                Assertions.assertEquals(shopClassifyValues.get(i), 0L);
            }
        }
    }

    @Test
    public void ShopClassifyServiceFindAllShopByClassifyTagsTest() {
        String phone = "010-1234-1234";
        String name = "깍뚝";
        String address = "경기도 시흥시 수인로3325번길 12-2";
        Double addressPointY = 1.1234D;
        Double addressPointX = -1.1234D;
        Long clippingCount = 0L;
        Long pickedCount = 0L;
        String operatingHours = "하루종일";
        String onelineReview = "너무 맛있어요~";
        String mainPhotoUrl1 = "https://testlink1";
        String mainPhotoUrl2 = "https://testlink2";
        Tag tag = new Tag();

        Shop shop = Shop.builder()
                .phone(phone)
                .name(name)
                .address(address)
                .addressPointY(addressPointY)
                .addressPointX(addressPointX)
                .clippingCount(clippingCount)
                .pickedCount(pickedCount)
                .operatingHours(operatingHours)
                .onelineReview(onelineReview)
                .mainPhotoUrl1(mainPhotoUrl1)
                .mainPhotoUrl2(mainPhotoUrl2)
                .tag(tag)
                .build();

        tagRepository.save(tag);
        shopRepository.save(shop);

        // 인덱스가 홀수는 0.1, 짝수는 0.6으로 넣은 28개의 값의 List
        List<Double> tagValues = new ArrayList<>();

        for (int i=0;i<28;i++) {
            if (i % 2 == 0) {
                tagValues.add(0.6D);
            }
            else {
                tagValues.add(0.1D);
            }
        }

        tag.setTagsByList(tagValues);
        tagRepository.save(tag);

        shopClassifyService.makeAllShopClassifyUsingTagValues(0.5);

        List<Long> classify1 = new ArrayList<>();
        List<Long> classify2 = new ArrayList<>();

        for (int i=0;i<28;i++) {
            if (i % 2 == 0 && i % 4 == 0) {
                classify1.add(1L);
            }
            else {
                classify1.add(0L);
            }
        }

        for (int i=0;i<28;i++) {
            if (i % 2 != 0 && i % 4 != 0) {
                classify2.add(1L);
            }
            else {
                classify2.add(0L);
            }
        }

        Shop shop1 = shopClassifyService.findAllShopByClassifyTags(classify1).get(0);
        long size = shopClassifyService.findAllShopByClassifyTags(classify2).size();

        Assertions.assertEquals(shop1.getId(), shop.getId());
        Assertions.assertEquals(size, 0);
    }
}
