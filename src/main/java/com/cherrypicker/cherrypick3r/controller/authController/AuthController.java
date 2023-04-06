package com.cherrypicker.cherrypick3r.controller.authController;

import com.cherrypicker.cherrypick3r.component.KakaoKey;
import com.cherrypicker.cherrypick3r.domain.user.User;
import com.cherrypicker.cherrypick3r.domain.user.UserRepository;
import com.cherrypicker.cherrypick3r.dto.KakaoAccessTokenDto;
import com.cherrypicker.cherrypick3r.dto.SocialDto;
import com.cherrypicker.cherrypick3r.jwt.JwtTokenProvider;
import com.cherrypicker.cherrypick3r.service.KakaoService;
import com.cherrypicker.cherrypick3r.service.OAuthServise;
import com.cherrypicker.cherrypick3r.service.SocialService;
import com.cherrypicker.cherrypick3r.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final Environment env;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final SocialService socialService;
    private final KakaoService kakaoService;
    private final KakaoKey kakaoKey;

    @GetMapping("/kakao/login")
    public ResponseEntity<String> kakaoLogin() {
        // 로그인 링크 생성
        String kakaoLoginUrl =  "https://kauth.kakao.com/oauth/authorize?client_id=" + kakaoKey.getClientId() + "&redirect_uri=" + kakaoKey.getRedirectUri() + "&response_type=code";

        // 로그
        System.out.println(kakaoLoginUrl);

        // 로그인 링크 반환
        return new ResponseEntity<>(kakaoLoginUrl, HttpStatus.OK);
    }

    @GetMapping("/kakao/callback")
    public ResponseEntity kakaoCallback(@RequestParam String code,
                                                HttpServletResponse response) {
        // 코드로 유저 불러오기
        SocialDto socialDto = socialService.verificationKakao(code);
        // 유저 등록
        User user = userService.saveUserByUserEmail(socialDto.getEmail(), socialDto.getName());

        // JWT 토큰 생성
        List<String> list = new ArrayList<>();
        list.add(user.getAuth());
        String token = jwtTokenProvider.createToken(socialDto.getEmail(), list);

        // JWT 토큰 헤더에 담아 전달
//        response.addHeader(env.getProperty("oauth-key.header"), env.getProperty("oauth-key.prefix") + token);
        response.setHeader("Authorization", "bearer " + token);

        return new ResponseEntity(HttpStatus.OK);
    }
}
