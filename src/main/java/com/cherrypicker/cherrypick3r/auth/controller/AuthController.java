package com.cherrypicker.cherrypick3r.auth.controller;

import com.cherrypicker.cherrypick3r.auth.dto.SocialDto;
import com.cherrypicker.cherrypick3r.auth.service.SocialService;
import com.cherrypicker.cherrypick3r.component.GoogleKey;
import com.cherrypicker.cherrypick3r.component.JwtTokenProvider;
import com.cherrypicker.cherrypick3r.component.KakaoKey;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.dto.LoginResponse;
import com.cherrypicker.cherrypick3r.user.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final SocialService socialService;
    private final KakaoKey kakaoKey;
    private final GoogleKey googleKey;

    @GetMapping("/kakao/login")
    public ResponseEntity<LoginResponse> kakaoLogin() {
        // 로그인 링크 생성
        String kakaoLoginUrl =
            "https://kauth.kakao.com/oauth/authorize?client_id=" + kakaoKey.getClientId()
                + "&redirect_uri=" + kakaoKey.getRedirectUri() + "&response_type=code";

        // 로그
        log.info(kakaoLoginUrl);

        // 결과 생성
        LoginResponse loginResponse = new LoginResponse(kakaoLoginUrl);

        // 로그인 링크 반환
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
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
        response.setHeader("UserEmail", socialDto.getEmail());
        response.setHeader("AccessToken", "bearer " + socialDto.getAccessToken());

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/google/login")
    public ResponseEntity<LoginResponse> googleLogin() {
        // 로그인 링크 생성
        String googleLoginUrl = "https://accounts.google.com/o/oauth2/v2/auth?" +
            "scope=https%3A//www.googleapis.com/auth/userinfo.email https%3A//www.googleapis.com/auth/userinfo.profile&"
            +
            "access_type=offline&" +
            "include_granted_scopes=true&" +
            "response_type=code&" +
            "state=state_parameter_passthrough_value" +
            "&redirect_uri=" + googleKey.getRedirectUri() +
            "&client_id=" + googleKey.getClientId();

        // 로그
        log.info(googleLoginUrl);

        // 결과 생성
        LoginResponse loginResponse = new LoginResponse(googleLoginUrl);

        // 로그인 링크 반환
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @GetMapping("/google/callback")
    public ResponseEntity googleCallback(@RequestParam String code,
        HttpServletResponse response) {
        // 코드로 유저 불러오기
        SocialDto socialDto = socialService.verificationGoogle(code);
        // 유저 등록
        User user = userService.saveUserByUserEmail(socialDto.getEmail(), socialDto.getName());

        // JWT 토큰 생성
        List<String> list = new ArrayList<>();
        list.add(user.getAuth());
        String token = jwtTokenProvider.createToken(socialDto.getEmail(), list);

        // JWT 토큰 헤더에 담아 전달
//        response.addHeader(env.getProperty("oauth-key.header"), env.getProperty("oauth-key.prefix") + token);
        response.setHeader("Authorization", "bearer " + token);
        response.setHeader("UserEmail", socialDto.getEmail());
        response.setHeader("AccessToken", "bearer " + socialDto.getAccessToken());

//        System.out.println("JWT Token : " + token);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/apple/login")
    public ResponseEntity appleLogin(@RequestParam("userEmail") String userEmail,
        @RequestParam("nickname") String nickname,
        HttpServletResponse response) {

        // 유저 생성
        User user = userService.saveUserByUserEmail(userEmail, nickname);

        // JWT 토큰 생성
        List<String> list = new ArrayList<>();
        list.add(user.getAuth());
        String token = jwtTokenProvider.createToken(user.getEmail(), list);

        // JWT 토큰 헤더에 담아 전달
        response.setHeader("Authorization", "bearer " + token);
        response.setHeader("UserEmail", userEmail);

        // 로그인 링크 반환
        return new ResponseEntity(HttpStatus.OK);
    }
}
