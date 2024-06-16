package com.cherrypicker.cherrypick3r.user.service;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameChangeResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameResponse;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserSearchService userSearchService;

    private final UserRepository userRepository;

    private final TagRepository tagRepository;

    @Transactional
    public User saveUserByUserEmail(String email, String nickname) {
        // 이미 존재하는 유저인지 확인
        Optional<User> existUser = userRepository.findByEmail(email);
        if (existUser.isPresent())
            return existUser.get();

        Tag tag = new Tag();
        tagRepository.save(tag);

        // 존재하지 않는다면 DB에 저장
        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .auth("USER")
                .tag(tag)
                .build();

        return userRepository.save(user);
    }

    @Transactional
    public UserNicknameResponse findUserNicknameByUserEmail(String userEmail) {
        User user = userSearchService.findUserByEmail(userEmail);

        return UserNicknameResponse.builder()
                .userNickname(user.getNickname())
                .build();
    }

    @Transactional
    public UserNicknameChangeResponse changeUserNicknameByUserEmail(String userEmail, String changeUserNickname) {
        User user = userSearchService.findUserByEmail(userEmail);

        String originUserNickname = user.getNickname();
        user.changeNickname(changeUserNickname);
        userRepository.save(user);

        return UserNicknameChangeResponse.builder()
                .originalUserNickname(originUserNickname)
                .changedUserNickname(user.getNickname())
                .build();
    }

    @Transactional
    public void unregisterUserByUserEmail(String userEmail) {
        User user = userSearchService.findUserByEmail(userEmail);

        userRepository.delete(user);
    }

}
