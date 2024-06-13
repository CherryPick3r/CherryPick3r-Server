package com.cherrypicker.cherrypick3r.clipping.controller;

import com.cherrypicker.cherrypick3r.clipping.dto.ClippingDoResponse;
import com.cherrypicker.cherrypick3r.clipping.dto.ClippingUndoResponse;
import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clipping")
@RequiredArgsConstructor
public class ClippingController {

    private final ClippingService clippingService;

    @PostMapping("/do")
    public ResponseEntity<ClippingDoResponse> doClipping(@RequestParam("userEmail") String userEmail,
                                                         @RequestParam("shopId") Long shopId) {

        ClippingDoResponse clippingDoResponse = clippingService.createClipping(shopId, userEmail);

        return ResponseEntity.ok(clippingDoResponse);
    }

    @DeleteMapping("/undo")
    public ResponseEntity<ClippingUndoResponse> undoClipping(@RequestParam("userEmail") String userEmail,
                                                             @RequestParam("shopId") Long shopId) {

        ClippingUndoResponse clippingUndoResponse = clippingService.deleteClipping(shopId, userEmail);

        return ResponseEntity.ok(clippingUndoResponse);
    }
}
