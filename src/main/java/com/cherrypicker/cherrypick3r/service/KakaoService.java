package com.cherrypicker.cherrypick3r.service;

import com.cherrypicker.cherrypick3r.component.KakaoKey;
import com.cherrypicker.cherrypick3r.dto.KakaoAccessTokenDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoKey kakaoKey;
    private final ObjectMapper objectMapper;

    @Transactional
    public String getAccessTokenByCode(String code) {

        // HttpHeader 생성 및 정보 추가
        HttpHeaders httpHeaders = new HttpHeaders();

        // Spring에서 RestTemplate를 이용하여 PUT 파라미터를 전송하게 될 경우 ContentType을 "MediaType.APPLICATION_FORM_URLENCODED"로 설정해줘야 값이 전송이 된다.
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Request에 담을 정보 추가
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoKey.getClientId());
        params.add("redirect_uri", kakaoKey.getRedirectUri());
        params.add("code", code);
        params.add("client_secret", "");

        // request를 하기위해 HttpEntity 객체에 헤더와 정보 조립
        HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(params, httpHeaders);

        // code에 대한 인증요청을 할 url
        String url = "https://kauth.kakao.com/oauth/token";

        RestTemplate restTemplate = new RestTemplate();

        // code에 대한 인증요청을 보낸뒤 결과를 받아 response 객체에 담아 받는다.
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        try {
            // 인증에 성공했다면 access_token을 반환
            return objectMapper.readValue(response.getBody(), KakaoAccessTokenDto.class).getAccess_token();
        } catch (JsonProcessingException e) {
            // code 인증에 실패한 경우
            e.printStackTrace();
        }
        // code 인증에 실패한 경우
        return null;
    }

    @Transactional
    public String getUserInfoByAccessToken(String accessToken) {

        System.out.println("accessToken in func : " + accessToken);

        // accessToken을 통해 유저 정보를 가져올 요청을 생성한다.
        HttpHeaders headers = new HttpHeaders();
        // kakao에서 요구한 폼대로 작성
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // 유저 정보를 받기위해 요청할 kakao 서버 url
        String url = "https://kapi.kakao.com/v2/user/me";

        RestTemplate restTemplate = new RestTemplate();

        // json 형식으로 리퀘스트 값을 반환한다.
        return restTemplate.postForObject(url, request, String.class);
    }

}
