package com.cherrypicker.cherrypick3r.game.controller;

import com.cherrypicker.cherrypick3r.component.TestComponent;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.game.dto.GameResponse;
import com.cherrypicker.cherrypick3r.game.dto.GameSimple;
import com.cherrypicker.cherrypick3r.game.service.GameService;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.result.service.ResultService;
import com.cherrypicker.cherrypick3r.shop.Service.ShopService;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
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
    private final ResultService resultService;
    private final ShopRepository shopRepository;
    private final TestComponent testComponent;

    @GetMapping("/make-test-data")
    public ResponseEntity<?> makeTestData() {
        testComponent.makeShopTestData();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/start-game")
    public ResponseEntity<GameSimple> startGame(@RequestParam("userEmail") String userEmail) {
        GameDto gameDto = gameService.makeGame(userEmail);
        if (gameDto == null) {
            return ResponseEntity.badRequest().build();
        }

        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameDto(gameDto);

        // TODO: 태그에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
        // TODO: ShopDto를 ShopService에서 리스트로 반환해줄 수 있는 메서드가 생기면 그 메서드로 치환할 것
        List<ShopDto> shopDtos = new ArrayList<>();
        List<Shop> shops = shopRepository.findAll();
        for (Shop shop : shops) {
            shopDtos.add(shop.toDto());
        }

//                // 유사도를 기반으로 추천 가게 리스트를 만든다.
//                List<ShopDto> recommendedShopDtos = gameService.findShopsBySimilarity(gameDto, shopDtos, 3L);

        // 스코어를 기반으로 추천 가게 리스트를 만든다.
        List<ShopDto> recommendedShopDtos = gameService.findShopsByScore(gameDto, shopDtos, 3L);

        // 추천한 가게를 저장한다.
        gameService.saveRecommendedShopsByList(gameDto, recommendedShopDtos);

        // 결과 세팅
        gameResponse.setShopDtos(recommendedShopDtos);
//        return ResponseEntity.ok(gameResponse);
        return ResponseEntity.ok(new GameSimple(gameResponse));
    }

    @PostMapping("/swipe-left")
    public ResponseEntity<GameSimple> swipeLeft(@RequestParam("gameId") Long gameId, @RequestParam("shopId") Long shopId) {
        GameDto gameDto = gameService.swipeLeft(gameService.findGameDtoById(gameId), shopService.findShopByShopId(shopId));
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameDto(gameDto);

        if (gameDto == null) {
            return ResponseEntity.badRequest().build();
        }

        if (gameDto.getCurRound() == gameDto.getTotalRound()) {
            // 게임의 끝에 도달

            // 결과 생성
            // TODO: 태그에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
            // TODO: ShopDto를 ShopService에서 리스트로 반환해줄 수 있는 메서드가 생기면 그 메서드로 치환할 것
            List<ShopDto> shopDtos = new ArrayList<>();
            List<Shop> shops = shopRepository.findAll();
            for (Shop shop : shops) {
                shopDtos.add(shop.toDto());
            }

            // 게임을 종료상태로 만든다. : 유사도를 이용한 결과 도출
//            ResultDto resultDto = gameService.endGame(gameDto, gameService.findShopBySimilarity(gameDto, shopDtos));

            // 게임을 종료상태로 만든다. : 스코어를 이용한 결과 도출
            ResultDto resultDto = gameService.endGame(gameDto, gameService.findShopByScore(gameDto, shopDtos));

            // 결과 세팅
            gameResponse.setResultDto(resultDto);
//            return ResponseEntity.ok(gameResponse);
            return ResponseEntity.ok(new GameSimple(gameResponse));
        }
        else {
            // 게임 아직 진행중

            if (gameDto.getCurRound() % 3 == 0) {
                // 게임의 3번째 스탭마다 다음 3개의 가게를 다시 뽑아서 추천해준다.

                // TODO: 태그에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
                // TODO: ShopDto를 ShopService에서 리스트로 반환해줄 수 있는 메서드가 생기면 그 메서드로 치환할 것
                List<ShopDto> shopDtos = new ArrayList<>();
                List<Shop> shops = shopRepository.findAll();
                for (Shop shop : shops) {
                    shopDtos.add(shop.toDto());
                }

//                // 유사도를 기반으로 추천 가게 리스트를 만든다.
//                List<ShopDto> recommendedShopDtos = gameService.findShopsBySimilarity(gameDto, shopDtos, 3L);

                // 스코어를 기반으로 추천 가게 리스트를 만든다.
                List<ShopDto> recommendedShopDtos = gameService.findShopsByScore(gameDto, shopDtos, 3L);

                // 추천한 가게를 저장한다.
                gameService.saveRecommendedShopsByList(gameDto, recommendedShopDtos);

                // 추천할 가게 3개를 세팅
                gameResponse.setShopDtos(recommendedShopDtos);
            }

//            return ResponseEntity.ok(gameResponse);
            return ResponseEntity.ok(new GameSimple(gameResponse));
        }
    }

    @PostMapping("/swipe-right")
    public ResponseEntity<GameSimple> swipeRight(@RequestParam("gameId") Long gameId, @RequestParam("shopId") Long shopId) {
        GameDto gameDto = gameService.swipeRight(gameService.findGameDtoById(gameId), shopService.findShopByShopId(shopId));
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameDto(gameDto);

        if (gameDto == null) {
            return ResponseEntity.notFound().build();
        }

        if (gameDto.getCurRound() == gameDto.getTotalRound()) {
            // 게임의 끝에 도달

            // 결과 생성
            // TODO: 태그에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
            // TODO: ShopDto를 ShopService에서 리스트로 반환해줄 수 있는 메서드가 생기면 그 메서드로 치환할 것
            List<ShopDto> shopDtos = new ArrayList<>();
            List<Shop> shops = shopRepository.findAll();
            for (Shop shop : shops) {
                shopDtos.add(shop.toDto());
            }

            // 게임을 종료상태로 만든다. : 유사도를 이용한 결과 도출
//            ResultDto resultDto = gameService.endGame(gameDto, gameService.findShopBySimilarity(gameDto, shopDtos));

            // 게임을 종료상태로 만든다. : 스코어를 이용한 결과 도출
            ResultDto resultDto = gameService.endGame(gameDto, gameService.findShopByScore(gameDto, shopDtos));

            // 결과 세팅
            gameResponse.setResultDto(resultDto);
//            return ResponseEntity.ok(gameResponse);
            return ResponseEntity.ok(new GameSimple(gameResponse));
        }
        else {
            // 게임 아직 진행중

            if (gameDto.getCurRound() % 3 == 0) {
                // 게임의 3번째 스탭마다 다음 3개의 가게를 다시 뽑아서 추천해준다.

                // TODO: 태그에 해당하는 가게로 해야함, 일단 설계의 한계로 모든 가게에 대해서 하게 구현
                // TODO: ShopDto를 ShopService에서 리스트로 반환해줄 수 있는 메서드가 생기면 그 메서드로 치환할 것
                List<ShopDto> shopDtos = new ArrayList<>();
                List<Shop> shops = shopRepository.findAll();
                for (Shop shop : shops) {
                    shopDtos.add(shop.toDto());
                }

//                // 유사도를 기반으로 추천 가게 리스트를 만든다.
//                List<ShopDto> recommendedShopDtos = gameService.findShopsBySimilarity(gameDto, shopDtos, 3L);

                // 스코어를 기반으로 추천 가게 리스트를 만든다.
                List<ShopDto> recommendedShopDtos = gameService.findShopsByScore(gameDto, shopDtos, 3L);

                // 추천한 가게를 저장한다.
                gameService.saveRecommendedShopsByList(gameDto, recommendedShopDtos);

                // 추천할 가게 3개를 세팅
                gameResponse.setShopDtos(recommendedShopDtos);
            }

//            return ResponseEntity.ok(gameResponse);
            return ResponseEntity.ok(new GameSimple(gameResponse));
        }
    }
}
