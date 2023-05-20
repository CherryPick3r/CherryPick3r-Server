package com.cherrypicker.cherrypick3r.menu;

import com.cherrypicker.cherrypick3r.menu.domain.Menu;
import com.cherrypicker.cherrypick3r.menu.domain.MenuRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class menuServiceTest {
    private  MenuRepository menuRepository;

    private ShopRepository shopRepository;


    private TagRepository tagRepository;

    @Autowired
    public menuServiceTest(MenuRepository menuRepository, ShopRepository shopRepository, TagRepository tagRepository){
        this.menuRepository = menuRepository;
        this.shopRepository = shopRepository;
        this.tagRepository = tagRepository;
    }

    @Test
    @Transactional
    public void 메뉴만들어서저장(){
        // 음식점 생성
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
        Tag tag2 = new Tag();
        tagRepository.save(tag2);

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
                .tag(tag2)
                .build();


        shopRepository.save(shop);
        Menu menu = new Menu("닭볶음탕", 12000L, shop);
        menuRepository.save(menu);
        List<Optional<Menu>> result = menuRepository.findAllByShop(shop);
        Menu m;
        for (Optional <Menu> Om : result){
            m = Om.get();
            assertThat(m).isNotNull();
            System.out.println(m.getId());
            System.out.println(m.getName());
            System.out.println(m.getPrice());
            System.out.println(m.getShop().getName());

        }
    }
}
