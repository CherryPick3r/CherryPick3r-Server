package com.cherrypicker.cherrypick3r.user.controller;

import com.cherrypicker.cherrypick3r.user.dto.UserDeleteResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserDto;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameChangeResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameResponse;
import com.cherrypicker.cherrypick3r.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/nickname")
    public ResponseEntity<UserNicknameResponse> findUserNickname(@RequestParam("userEmail") String userEmail) {
        UserNicknameResponse userNicknameResponse = userService.findUserNicknameByUserEmail(userEmail);

        return ResponseEntity.ok(userNicknameResponse);
    }

    @PatchMapping("/nickname")
    public ResponseEntity<UserNicknameChangeResponse> changeUserNickname(@RequestParam("userEmail") String userEmail,
                                                                         @RequestParam("changeUserNickname") String changeUserNickname) {
        UserNicknameChangeResponse userNicknameChangeResponse = userService.changeUserNicknameByUserEmail(userEmail, changeUserNickname);

        return ResponseEntity.ok(userNicknameChangeResponse);
    }

    // TODO: 인증받고 인증 성공하면 유저 인증 해제하고 유저 삭제 로직 작성
//    @DeleteMapping("unregister")
//    public ResponseEntity<UserDeleteResponse> unregisterUser(@RequestParam("userEmail") String userEmail) {
//
//        UserDeleteResponse userDeleteResponse = UserDeleteResponse.builder()
//                .loginURL() // 이메일 첫글자보고 카카오 or 구글 or 애플 로그인 주소 반환
//                .build();
//
//        return ResponseEntity<uesrDeleteResponse>;
//    }
}
