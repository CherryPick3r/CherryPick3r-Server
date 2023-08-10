package com.cherrypicker.cherrypick3r.shop.controller;

import com.cherrypicker.cherrypick3r.clipping.dto.ClippingsSimpleResponse;
import com.cherrypicker.cherrypick3r.game.service.GameService;
import com.cherrypicker.cherrypick3r.result.dto.ResultsSimpleResponse;
import com.cherrypicker.cherrypick3r.result.service.ResultService;
import com.cherrypicker.cherrypick3r.shop.Service.ShopSearchService;
import com.cherrypicker.cherrypick3r.shop.Service.ShopService;
import com.cherrypicker.cherrypick3r.shop.dto.ShopCardResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDetailResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop")
@RequiredArgsConstructor
public class ShopController {

    private final GameService gameService;

    private final ShopService shopService;

    private final ShopSearchService shopSearchService;

    private final ResultService resultService;

    @GetMapping("/card")
    public ResponseEntity<ShopCardResponse> getShopCard(@RequestParam("shopId") Long shopId,
                                                        @RequestParam("userEmail") String userEmail) {
        ShopDto shopDto = shopSearchService.findShopByShopId(shopId);

        ShopCardResponse shopCardResponse = shopService.createShopCardResponseByShopDtoAndUserEmail(shopDto, userEmail);

        return ResponseEntity.ok(shopCardResponse);
    }

    @GetMapping("/detail")
    public ResponseEntity<ShopDetailResponse> getShopDetail(@RequestParam("shopId") Long shopId,
                                                            @RequestParam("userEmail") String userEmail) {
        ShopDto shopDto = shopSearchService.findShopByShopId(shopId);

        ShopDetailResponse shopDetailResponse = shopService.createShopDetailResponseByShopDto(shopDto, userEmail);

        return ResponseEntity.ok(shopDetailResponse);
    }

    @GetMapping("/results-simple")
    public ResponseEntity<ResultsSimpleResponse> getResultsSimple(@RequestParam("userEmail") String userEmail,
                                                                  @RequestParam("gameCategory") Long gameCategory) {

        ResultsSimpleResponse resultsSimpleResponse = ResultsSimpleResponse.builder()
                .shopSimpleDtos(shopService.createShopSimpleListByUserEmailResults(userEmail))
                .build();

        return ResponseEntity.ok(resultsSimpleResponse);
    }

    @GetMapping("/clippings-simple")
    public ResponseEntity<ClippingsSimpleResponse> getClippingsSimple(@RequestParam("userEmail") String userEmail,
                                                                    @RequestParam("gameCategory") Long gameCategory) {

        ClippingsSimpleResponse clippingsSimpleResponse = ClippingsSimpleResponse.builder()
                .shopSimpleDtos(shopService.createShopSimpleListByUserEmailClippings(userEmail))
                .build();

        return ResponseEntity.ok(clippingsSimpleResponse);
    }











}
