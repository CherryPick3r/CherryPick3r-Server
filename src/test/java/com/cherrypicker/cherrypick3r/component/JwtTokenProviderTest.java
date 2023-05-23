package com.cherrypicker.cherrypick3r.component;
import com.cherrypicker.cherrypick3r.component.JwtTokenProvider;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.user.service.UserDetailsService;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
@SpringBootTest
public class JwtTokenProviderTest {
//
//    private UserDetailsService userDetailService;
//    private UserRepository userRepository;
//
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    public JwtTokenProviderTest(UserDetailsService userDetailService, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
//        this.userDetailService = userDetailService;
//        this.userRepository = userRepository;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @AfterEach
//    public void AfterEach(){
//        userRepository.deleteAll();
//    }
//    //토큰 잘 만들어지는 지 확인 , 잘 인증되는지 확인
//    @Test
//    public void createTokenTest(){
//        //given
//        String user1 = "user1";
//        List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
////        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(userDetailService);
//
////        when
//        String token = jwtTokenProvider.createToken(user1, roles);
//        //then
//        System.out.println(token);
//        assertThat(token).isNotNull();
//        boolean isValid = jwtTokenProvider.validateToken(token);
//        assertTrue(isValid);
//    }
}
