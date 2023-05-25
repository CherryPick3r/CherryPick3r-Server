package com.cherrypicker.cherrypick3r.game.controller;

import com.cherrypicker.cherrypick3r.component.TestComponent;
import com.cherrypicker.cherrypick3r.game.dto.*;
import com.cherrypicker.cherrypick3r.game.service.GameService;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.result.service.ResultService;
import com.cherrypicker.cherrypick3r.shop.Service.ShopService;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopCardResponse;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final ShopService shopService;

    private final GameService gameService;

    private final TestComponent testComponent;

    @GetMapping("/make-test-data")
    public ResponseEntity<?> makeTestData() {
        testComponent.makeShopTestData();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/start-game")
    public ResponseEntity<GameStartResponse> startGame(@RequestParam("userEmail") String userEmail,
                                                @RequestParam("gameMode") Long gameMode) {

        GameDto gameDto = gameService.makeGame(userEmail);
        if (gameDto == null) {
            return ResponseEntity.badRequest().build(); // MakeGameFailure
        }

//        // TODO: 게임 모드에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
//        List<ShopDto> shopDtos = shopService.findAllDtos();
//
//        // 스코어를 기반으로 추천 가게 리스트를 만든다.
//        List<ShopDto> recommendedShopDtos = gameService.findShopsByScore(gameDto, shopDtos, 3L);
        // 랜덤하게 3개의 추천 가게 리스트를 만든다.
        List<ShopDto> recommendedShopDtos = gameService.find3ShopByRandom(gameDto);
        List<Long> recommendedShopIds = new ArrayList<>();
        List<ShopCardResponse> shopCardResponses = new ArrayList<>();
        for (int i=0;i<3;i++) {
            recommendedShopIds.add(recommendedShopDtos.get(i).getId());
            shopCardResponses.add(shopService.createShopCardResponseByShopDtoAndUserEmail(recommendedShopDtos.get(i), userEmail));
        }


        // 추천한 가게를 저장한다.
        gameService.saveRecommendedShopsByList(gameDto, recommendedShopDtos);

        // 결과 세팅
        GameStartResponse gameStartResponse = GameStartResponse.builder()
                .gameId(gameDto.getId())
                .totalRound(gameDto.getTotalRound())
                .curRound(gameDto.getCurRound())
                .gameStatus(gameDto.getStatus())
                .recommendShopIds(recommendedShopIds)
                .recommendShops(shopCardResponses)
                .build();

        return ResponseEntity.ok(gameStartResponse);
    }

    @PostMapping("/swipe-left")
    public ResponseEntity<?> swipeLeft(@RequestParam("gameId") Long gameId,
                                       @RequestParam("shopId") Long shopId) {
        GameDto gameDto = gameService.swipeLeft(gameService.findGameDtoById(gameId), shopService.findShopByShopId(shopId));

        if (gameDto == null) {
            return ResponseEntity.badRequest().build();
        }

        if (gameDto.getCurRound() == gameDto.getTotalRound()) {
            // CASE1: 게임의 끝에 도달

            // 결과 생성
            // TODO: 게임 모드에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
            List<ShopDto> shopDtos = shopService.findAllDtos();

            // 게임을 종료상태로 만든다. : 스코어를 이용한 결과 도출
            ResultDto resultDto = gameService.endGame(gameDto, gameService.findShopByScore(gameDto, shopDtos));

            // 결과 세팅
            GameEndResponse gameResponse = GameEndResponse.builder()
                    .gameId(gameDto.getId())
                    .totalRound(gameDto.getTotalRound())
                    .curRound(gameDto.getCurRound())
                    .gameStatus(gameDto.getStatus())
                    .recommendedShopId(resultDto.getShop().getId())
                    .recommendedShopDetail(shopService.createShopDetailResponseByShopDto(resultDto.getShop().toDto(), gameDto.getUser().getEmail())).build();
            return ResponseEntity.ok(gameResponse);
        }
        else {
            // CASE2: 게임 아직 진행중

            // 게임 결과를 생성
            GameResponse gameResponse = GameResponse.builder()
                    .gameId(gameDto.getId())
                    .totalRound(gameDto.getTotalRound())
                    .curRound(gameDto.getCurRound())
                    .gameStatus(gameDto.getStatus())
                    .build();

            if (gameDto.getCurRound() % 3 == 0) {
                // 게임의 3번째 스탭마다 다음 3개의 가게를 다시 뽑아서 추천해준다.

//                // TODO: 게임 모드에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
//                List<ShopDto> shopDtos = shopService.findAllDtos();
//
//                // 스코어를 기반으로 추천 가게 리스트를 만든다.
//                List<ShopDto> recommendedShopDtos = gameService.findShopsByScore(gameDto, shopDtos, 3L);
                // 랜덤하게 3개의 추천 가게 리스트를 만든다.
                List<ShopDto> recommendedShopDtos = gameService.find3ShopByRandom(gameDto);
                List<Long> recommendedShopIds = new ArrayList<>();
                List<ShopCardResponse> shopCardResponses = new ArrayList<>();
                for (int i=0;i<3;i++) {
                    recommendedShopIds.add(recommendedShopDtos.get(i).getId());
                    shopCardResponses.add(shopService.createShopCardResponseByShopDtoAndUserEmail(recommendedShopDtos.get(i), gameDto.getUser().getEmail()));
                }

                // 추천한 가게를 저장한다.
                gameService.saveRecommendedShopsByList(gameDto, recommendedShopDtos);

                // 추천할 가게 3개를 세팅
                gameResponse.setRecommendShopIds(recommendedShopIds);
                gameResponse.setRecommendShops(shopCardResponses);
            }

            return ResponseEntity.ok(gameResponse);
        }
    }
    @PostMapping("/swipe-right")
    public ResponseEntity<?> swipeRight(@RequestParam("gameId") Long gameId,
                                        @RequestParam("shopId") Long shopId) {
        GameDto gameDto = gameService.swipeRight(gameService.findGameDtoById(gameId), shopService.findShopByShopId(shopId));

        if (gameDto == null) {
            return ResponseEntity.badRequest().build();
        }

        if (gameDto.getCurRound() == gameDto.getTotalRound()) {
            // CASE1: 게임의 끝에 도달

            // 결과 생성
            // TODO: 게임 모드에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
            List<ShopDto> shopDtos = shopService.findAllDtos();

            // 게임을 종료상태로 만든다. : 스코어를 이용한 결과 도출
            ResultDto resultDto = gameService.endGame(gameDto, gameService.findShopByScore(gameDto, shopDtos));

            // 결과 세팅
            GameEndResponse gameResponse = GameEndResponse.builder()
                    .gameId(gameDto.getId())
                    .totalRound(gameDto.getTotalRound())
                    .curRound(gameDto.getCurRound())
                    .gameStatus(gameDto.getStatus())
                    .recommendedShopId(resultDto.getShop().getId())
                    .recommendedShopDetail(shopService.createShopDetailResponseByShopDto(resultDto.getShop().toDto(), gameDto.getUser().getEmail())).build();
            return ResponseEntity.ok(gameResponse);
        }
        else {
            // CASE2: 게임 아직 진행중

            // 게임 결과를 생성
            GameResponse gameResponse = GameResponse.builder()
                    .gameId(gameDto.getId())
                    .totalRound(gameDto.getTotalRound())
                    .curRound(gameDto.getCurRound())
                    .gameStatus(gameDto.getStatus())
                    .build();

            if (gameDto.getCurRound() % 3 == 0) {
                // 게임의 3번째 스탭마다 다음 3개의 가게를 다시 뽑아서 추천해준다.

//                // TODO: 게임 모드에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
//                List<ShopDto> shopDtos = shopService.findAllDtos();
//
//                // 스코어를 기반으로 추천 가게 리스트를 만든다.
//                List<ShopDto> recommendedShopDtos = gameService.findShopsByScore(gameDto, shopDtos, 3L);
                // 랜덤하게 3개의 추천 가게 리스트를 만든다.
                List<ShopDto> recommendedShopDtos = gameService.find3ShopByRandom(gameDto);
                List<Long> recommendedShopIds = new ArrayList<>();
                List<ShopCardResponse> shopCardResponses = new ArrayList<>();
                for (int i=0;i<3;i++) {
                    recommendedShopIds.add(recommendedShopDtos.get(i).getId());
                    shopCardResponses.add(shopService.createShopCardResponseByShopDtoAndUserEmail(recommendedShopDtos.get(i), gameDto.getUser().getEmail()));
                }

                // 추천한 가게를 저장한다.
                gameService.saveRecommendedShopsByList(gameDto, recommendedShopDtos);

                // 추천할 가게 3개를 세팅
                gameResponse.setRecommendShopIds(recommendedShopIds);
                gameResponse.setRecommendShops(shopCardResponses);
            }

            return ResponseEntity.ok(gameResponse);
        }
    }
}
