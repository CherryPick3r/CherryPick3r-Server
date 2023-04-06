package com.cherrypicker.cherrypick3r.service;

import com.cherrypicker.cherrypick3r.domain.user.User;
import com.cherrypicker.cherrypick3r.domain.user.UserRepository;
import com.cherrypicker.cherrypick3r.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User loadUserByUserEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    public User saveUserByUserEmail(String email, String nickname) {
        // 이미 존재하는 유저인지 확인
        //User user = userRepository.findByEmail(email).isEmpty();
        if (!userRepository.findByEmail(email).isEmpty())
            return userRepository.findByEmail(email).get();

        // 존재하지 않는다면 DB에 저장
        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth("USER")
                .build();

        userRepository.save(user);

        return user;
    }
}
