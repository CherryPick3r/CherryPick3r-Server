package com.cherrypicker.cherrypick3r.preference.controller;

import com.cherrypicker.cherrypick3r.preference.dto.UserPreferenceResponse;
import com.cherrypicker.cherrypick3r.preference.dto.UserPreferenceStartResponse;
import com.cherrypicker.cherrypick3r.preference.service.PreferenceGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/preference")
@RequiredArgsConstructor
public class PreferenceGameController {

    private final PreferenceGameService preferenceGameService;

    @PostMapping("/start-game")
    public ResponseEntity<UserPreferenceStartResponse> gameStart(@RequestParam("userEmail") String userEmail) {
        UserPreferenceStartResponse userPreferenceStartResponse = preferenceGameService.makeGame(userEmail);

        return ResponseEntity.ok(userPreferenceStartResponse);
    }

    @PostMapping("/swipe-left")
    public ResponseEntity<UserPreferenceResponse> swipeLeft(@RequestParam("userEmail") String userEmail,
                                                            @RequestParam("preferenceGameId") Long preferenceGameId) {
        UserPreferenceResponse userPreferenceResponse = preferenceGameService.swipeLeft(userEmail, preferenceGameId);

        return ResponseEntity.ok(userPreferenceResponse);
    }

    @PostMapping("/swipe-right")
    public ResponseEntity<UserPreferenceResponse> swipeRight(@RequestParam("userEmail") String userEmail,
                                                             @RequestParam("preferenceGameId") Long preferenceGameId) {
        UserPreferenceResponse userPreferenceResponse = preferenceGameService.swipeRight(userEmail, preferenceGameId);

        return ResponseEntity.ok(userPreferenceResponse);
    }

}
