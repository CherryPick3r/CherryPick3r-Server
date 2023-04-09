package com.cherrypicker.cherrypick3r.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class GoogleKey {
    @Value("${client.id.google}")
    private String clientId;

    @Value("${redirect.uri.google}")
    private String redirectUri;

    @Value("${secret.google}")
    private String secret;
}
