package com.cherrypicker.cherrypick3r.domain.user;

import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassify;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassifyRepository;
import com.cherrypicker.cherrypick3r.userClassify.service.UserClassifyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserClassifyServiceTest {

    private UserRepository userRepository;

    private UserClassifyRepository userClassifyRepository;

    private TagRepository tagRepository;

    private UserClassifyService userClassifyService;

    @Autowired
    public UserClassifyServiceTest(UserRepository userRepository, UserClassifyRepository userClassifyRepository, TagRepository tagRepository, UserClassifyService userClassifyService) {
        this.userRepository = userRepository;
        this.userClassifyRepository = userClassifyRepository;
        this.tagRepository = tagRepository;
        this.userClassifyService = userClassifyService;
    }

    @Test
    public void UserClassifyServiceFindAllUserByClassifyTagsTest() {
        String email = "test@naver.com";
        String nickname = "테스트계정";
        String auth = "ROLE_ADMIN";

        Tag tag = new Tag();

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth(auth)
                .tag(tag)
                .build();

        tagRepository.save(tag);
        userRepository.save(user);

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

        userClassifyService.makeAllUserClassifyUsingTagValues(0.5);

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

        User user1 = userClassifyService.findAllUserByClassifyTags(classify1).get(0);
        long size = userClassifyService.findAllUserByClassifyTags(classify2).size();

        Assertions.assertEquals(user1.getEmail(), user.getEmail());
        Assertions.assertEquals(size, 0);
    }

}
