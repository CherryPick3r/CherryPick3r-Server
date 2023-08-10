package com.cherrypicker.cherrypick3r.clipping.controller;

import com.cherrypicker.cherrypick3r.clipping.dto.ClippingDoResponse;
import com.cherrypicker.cherrypick3r.clipping.dto.ClippingUndoResponse;
import com.cherrypicker.cherrypick3r.clipping.service.ClippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clipping")
@RequiredArgsConstructor
public class ClippingController {

    private final ClippingService clippingService;

    @PostMapping("/do")
    public ResponseEntity<ClippingDoResponse> doClipping(@RequestParam("userEmail") String userEmail,
                                                         @RequestParam("shopId") Long shopId) {

        return ResponseEntity.ok(clippingService.createClipping(shopId, userEmail));
    }

    @DeleteMapping("/undo")
    public ResponseEntity<ClippingUndoResponse> undoClipping(@RequestParam("userEmail") String userEmail,
                                                             @RequestParam("shopId") Long shopId) {

        return ResponseEntity.ok(clippingService.deleteClipping(shopId, userEmail));
    }
}
