package com.cherrypicker.cherrypick3r.user.domain;

import com.cherrypicker.cherrypick3r.baseTimeEntity.domain.BaseTimeEntity;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.user.dto.UserDto;
import com.cherrypicker.cherrypick3r.userClassify.domain.UserClassify;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Getter
@NoArgsConstructor
@Table(name="USER_TABLE")
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @Column(name = "user_email")
    private String email;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_auth")
    private String auth;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToOne(mappedBy = "user", cascade = CascadeType.DETACH)
    private UserClassify userClassify;

    @Builder
    public User(String email, String nickname, String auth, Tag tag) {
        this.email = email;
        this.nickname = nickname;
        this.auth = auth;
        this.tag = tag;
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

    public void mappingUserClassify(UserClassify userClassify) {
        this.userClassify = userClassify;
        return ;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .email(this.email)
                .nickname(this.nickname)
                .auth(this.auth)
                .tag(this.tag)
                .userClassify(this.userClassify)
                .build();
    }
}
