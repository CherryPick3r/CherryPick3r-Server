package com.cherrypicker.cherrypick3r.user.controller;

import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import com.cherrypicker.cherrypick3r.result.service.ResultService;
import com.cherrypicker.cherrypick3r.shop.dto.ShopSimple;
import com.cherrypicker.cherrypick3r.user.dto.UserAnalyzeResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserClassPair;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameChangeResponse;
import com.cherrypicker.cherrypick3r.user.dto.UserNicknameResponse;
import com.cherrypicker.cherrypick3r.user.service.UserAnalyzeService;
import com.cherrypicker.cherrypick3r.user.service.UserClassService;
import com.cherrypicker.cherrypick3r.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ResultService resultService;

    private final ClippingService clippingService;

    private final UserAnalyzeService userAnalyzeService;

    private final UserClassService userClassService;

    @GetMapping("/analyze")
    public ResponseEntity<UserAnalyzeResponse> composeUserAnalyze(
        @RequestParam("userEmail") String userEmail) {
        Long resultCount = resultService.findResultCountByUserEmail(userEmail);
        Long clippingCount = clippingService.findClippingCountByUserEmail(userEmail);
        List<ShopSimple> recentCherrypickShops = resultService.find3ShopSimpleByUserEmail(
            userEmail);
        List<ShopSimple> recentClippingShops = clippingService.find3ShopSimpleByUserEmail(
            userEmail);
        List<String> userTags = userAnalyzeService.findUserPreferenceTags(userEmail);
        Double userPercentile = userAnalyzeService.calcUserPercentile(userEmail);
        UserClassPair userClassPair = userClassService.findUserClass(userEmail);

        UserAnalyzeResponse userAnalyzeResponse = UserAnalyzeResponse.builder()
            .userNickname(
                userService.findUserNicknameByUserEmail(userEmail).getUserNickname()) // 유저 닉네임
            .userPercentile(userPercentile) // 유저 상위 퍼센트
            .userClass(userClassPair.getUserClass()) // 유저 분류
            .userAnalyzeValues(userClassPair.getUserClassValues()) // 유저 취향 값
            .cherrypickClippingTotalCount(resultCount + clippingCount) // 체리픽 횟수 + 클리핑 횟수
            .cherrypickCount(resultCount) // 체리픽 횟수
            .recentCherrypickShops(recentCherrypickShops) // 체리픽한 가게들의 심플정보 3개
            .clippingCount(clippingCount) // 클리핑 횟수
            .recentClippingShops(recentClippingShops) // 클리핑한 가게들의 심플정보 3개
            .userTags(userTags) // 한 주간 찾은 태그들 모음
            .build();

        return ResponseEntity.ok(userAnalyzeResponse);
    }

    @GetMapping("/nickname")
    public ResponseEntity<UserNicknameResponse> findUserNickname(
        @RequestParam("userEmail") String userEmail) {
        UserNicknameResponse userNicknameResponse = userService.findUserNicknameByUserEmail(
            userEmail);

        return ResponseEntity.ok(userNicknameResponse);
    }

    @PatchMapping("/nickname")
    public ResponseEntity<UserNicknameChangeResponse> changeUserNickname(
        @RequestParam("userEmail") String userEmail,
        @RequestParam("changeUserNickname") String changeUserNickname) {
        UserNicknameChangeResponse userNicknameChangeResponse = userService.changeUserNicknameByUserEmail(
            userEmail, changeUserNickname);

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
