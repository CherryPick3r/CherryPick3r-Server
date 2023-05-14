package com.cherrypicker.cherrypick3r.config;

import com.cherrypicker.cherrypick3r.component.JwtAuthenticationFilter;
import com.cherrypicker.cherrypick3r.component.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig{

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // csrf 보안 해제 (REST API 서버는 stateless 하기 때문에 csrf 공격에 안전함)
        httpSecurity.csrf().disable();

        // 시큐리티 링크별 권한 설정
        httpSecurity.httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/**").permitAll()
                .antMatchers("/**").permitAll()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);

        // 세션을 사용하지 않는다고 설정
        // SessionCreationPolicy.STATELESS 로 세션정책을 설정한다는것은 인증 처리 관점에서 스프링 시큐리티가 더 이상 세션쿠키 방식의 인증 메카니즘으로 인증처리를 하지 않겠다는 의미
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 필터 체인을 설정해서 필터 체인 객체 리턴
        return httpSecurity.build();
    }
}
