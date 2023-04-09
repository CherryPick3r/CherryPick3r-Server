package com.cherrypicker.cherrypick3r.auth.service;

import com.cherrypicker.cherrypick3r.auth.dto.SocialDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthServise {

    private final KakaoService kakaoService;
    private final ObjectMapper objectMapper;

    public SocialDto verificationKakao(String code){

        // 결과를 담아 반환할 DTO(DataTransferObject) 객체 생성
        SocialDto socialDto = new SocialDto();
        // 코드를 이용하여 accessToken 추출
        String accessToken = kakaoService.getAccessTokenByCode(code);
        // accessToken을 이용하여 사용자 정보 추출
        String userInfo = kakaoService.getUserInfoByAccessToken(accessToken);

        try {
            // objectMapper를 이용한 역직렬화
            JsonNode jsonNode = objectMapper.readTree(userInfo);
            // String.valueOf == toString()
            String email = String.valueOf(jsonNode.get("kakao_account").get("email"));
            socialDto.setEmail("kakao_" + email.substring(1, email.length() - 1));
            String name = String.valueOf(jsonNode.get("kakao_account").get("profile").get("nickname"));
            socialDto.setName(name.substring(1, name.length() - 1));
            String imageUrl = String.valueOf(jsonNode.get("kakao_account").get("profile").get("profile_image_url"));
            socialDto.setImageUrl(imageUrl.substring(1, imageUrl.length() - 1));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // access_token으로 받은 사용자 정보를 JsonNode로 변경하여 필요한 데이터만 추출하여 Dto로 담아 반환
        return socialDto;
    }

}
