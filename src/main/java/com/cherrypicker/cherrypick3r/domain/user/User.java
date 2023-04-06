package com.cherrypicker.cherrypick3r.domain.user;

import com.cherrypicker.cherrypick3r.domain.baseTimeEntity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Getter
@NoArgsConstructor
@Table(name="USER_TABLE")
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String auth;

    @Builder
    public User(String email, String nickname, String auth) {
        this.email = email;
        this.nickname = nickname;
        this.auth = auth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(auth));
        return authorities;
    }

    // DATABASE에서의 Password
    @Override
    public String getPassword() {
        return null;
    }

    // DATABASE에서의 PK
    @Override
    public String getUsername() {
        return email;
    }

    // 사용자 계정 만료 없음
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠금 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 계정 만료 없음
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 사용자 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
