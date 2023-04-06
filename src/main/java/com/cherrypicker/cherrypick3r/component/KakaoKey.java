package com.cherrypicker.cherrypick3r.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KakaoKey {
    @Value("${client-id}")
    private String clientId;

    @Value("${redirect-uri}")
    private String redirectUri;
}
