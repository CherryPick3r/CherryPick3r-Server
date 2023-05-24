package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.user.dto.UserDeleteResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserDto;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameChangeResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    @Transactional
    public User loadUserByUserEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    @Transactional
    public User saveUserByUserEmail(String email, String nickname) {
        // 이미 존재하는 유저인지 확인
        //User user = userRepository.findByEmail(email).isEmpty();
        if (!userRepository.findByEmail(email).isEmpty())
            return userRepository.findByEmail(email).get();

        Tag tag = new Tag();
        tagRepository.save(tag);

        // 존재하지 않는다면 DB에 저장
        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth("USER")
                .tag(tag)
                .build();

        userRepository.save(user);

        return user;
    }

    @Transactional
    public UserNicknameResponse findUserNicknameByUserEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();

        UserNicknameResponse userNicknameResponse = UserNicknameResponse.builder()
                .userNickname(user.getNickname())
                .build();

        return userNicknameResponse;
    }

    @Transactional
    public UserNicknameChangeResponse changeUserNicknameByUserEmail(String userEmail, String changeUserNickname) {
        User user = userRepository.findByEmail(userEmail).get();

        String originUserNickname = user.getNickname();
        user.changeNickname(changeUserNickname);
        userRepository.save(user);

        UserNicknameChangeResponse userNicknameChangeResponse = UserNicknameChangeResponse.builder()
                .originalUserNickname(originUserNickname)
                .changedUserNickname(user.getNickname())
                .build();

        return userNicknameChangeResponse;
    }

    @Transactional
    public void unregisterUserByUserEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();

        userRepository.delete(user);
    }

    //public UserDto(String email, String nickname, String auth, Tag tag, UserClassify userClassify){

}
