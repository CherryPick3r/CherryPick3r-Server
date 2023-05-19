package com.cherrypicker.cherrypick3r.domain.user;

import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void save() {
        String email = "abcdef@naver.com";
        String nickname = "지나가는강아지";
        String auth = "ROLE_USER";

        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth(auth)
                .build();

        userRepository.save(user);
        List<User> users = userRepository.findAll();

        User user1 = users.get(0);

        Assertions.assertEquals(user1.getEmail(), email);
        Assertions.assertEquals(user1.getNickname(), nickname);
        Assertions.assertEquals(user1.getAuth(), auth);
    }
}
