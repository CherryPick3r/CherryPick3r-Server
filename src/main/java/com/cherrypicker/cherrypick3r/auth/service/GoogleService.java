package com.cherrypicker.cherrypick3r.auth.service;

import com.cherrypicker.cherrypick3r.auth.dto.GoogleAccessTokenDto;
import com.cherrypicker.cherrypick3r.auth.dto.GoogleUserInfoDto;
import com.cherrypicker.cherrypick3r.component.GoogleKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class GoogleService {

    private final GoogleKey googleKey;
    private final ObjectMapper objectMapper;

    @Transactional
    public String getAccessTokenByCode(String code) {

        // HttpHeader 생성 및 정보 추가
        HttpHeaders httpHeaders = new HttpHeaders();

        // Spring에서 RestTemplate를 이용하여 PUT 파라미터를 전송하게 될 경우 ContentType을 "MediaType.APPLICATION_FORM_URLENCODED"로 설정해줘야 값이 전송이 된다.
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Request에 담을 정보 추가
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", googleKey.getClientId());
        params.add("client_secret", googleKey.getSecret());
        params.add("redirect_uri", googleKey.getRedirectUri());
        params.add("grant_type", "authorization_code");

        // request를 하기위해 HttpEntity 객체에 헤더와 정보 조립
        HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(params, httpHeaders);

        // code에 대한 인증요청을 할 url
        String url = "https://oauth2.googleapis.com/token";

        RestTemplate restTemplate = new RestTemplate();

        // code에 대한 인증요청을 보낸뒤 결과를 받아 response 객체에 담아 받는다.
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        try {
            // 인증에 성공했다면 access_token을 반환
            return objectMapper.readValue(response.getBody(), GoogleAccessTokenDto.class).getAccess_token();
        } catch (JsonProcessingException e) {
            // code 인증에 실패한 경우
            e.printStackTrace();
        }
        // code 인증에 실패한 경우
        return null;
    }

    @Transactional
    public GoogleUserInfoDto getUserInfoByAccessToken(String accessToken) {

        System.out.println("accessToken in func : " + accessToken);

        // accessToken을 통해 유저 정보를 가져올 요청을 생성한다.
        HttpHeaders headers = new HttpHeaders();
        // google에서 요구한 폼대로 작성
//        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity request = new HttpEntity(headers);

        // 유저 정보를 받기위해 요청할 google 서버 url
        // 여기서 에러터짐
//        String url = "https://www.googleapis.com/oauth2/v2/userinfo?access_token=$" + accessToken;
        String url = "https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + accessToken;
//        String url = "https://www.googleapis.com/oauth2/v2/userinfo";

        RestTemplate restTemplate = new RestTemplate();

        // get 요청으로 유저 정보를 받아온다.
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println("결과:" + response.getBody());

        try {
            // 유저정보 요청에 성공했다면 유저 정보를 반환
            return objectMapper.readValue(response.getBody(), GoogleUserInfoDto.class);
        } catch (JsonProcessingException e) {
            // 유저 정보 요청에 실패한 경우
            e.printStackTrace();
        }
        // 유저 정보 요청에 실패한 경우
        return null;
    }
}