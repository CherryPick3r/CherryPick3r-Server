package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSearchService {

    private final UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
