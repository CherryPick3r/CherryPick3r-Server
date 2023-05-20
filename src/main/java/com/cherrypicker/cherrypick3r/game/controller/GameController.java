package com.cherrypicker.cherrypick3r.game.controller;

import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.game.service.GameService;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.result.service.ResultService;
import com.cherrypicker.cherrypick3r.shop.Service.ShopService;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shopClassify.service.ShopClassifyService;
import com.cherrypicker.cherrypick3r.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

//    private final UserService userService;
//    private final ShopService shopService;
//    private final GameService gameService;
//    private final ResultService resultService;
//    private final ShopClassifyService shopClassifyService;
//
//    // 임시
//    private final ShopRepository shopRepository;

    // 여기서 RequestBody로 태그 리스트를 받는게 맞는지 잘 모르겠음.
//    @PostMapping("/start-game")
//    public ResponseEntity<GameDto> startGame(@RequestParam("userEmail") String userEmail, @RequestBody List<Long> tags) {
//        GameDto gameDto = gameService.makeGame(userEmail);
//        if (gameDto == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(gameDto);
//    }
//
//    @PostMapping("/swipe-left")
//    public ResponseEntity<?> swipeLeft(@RequestParam("gameId") Long gameId, @RequestParam("shopId") Long shopId) {
//        GameDto gameDto = gameService.swipeLeft(gameService.findGameDtoById(gameId), shopService.findShopByShopId(shopId));
//
//        if (gameDto == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        if (gameDto.getCurRound() == gameDto.getTotalRound()) {
//            // 게임의 끝에 도달
//
//            // 결과 생성
//            // TODO: 태그에 해당하는 가게로 해야함
//            // ShopDto를 어떻게 뽑아서 List로 넣을지 생각해봐야함
//            ResultDto resultDto = resultService.createResult(gameService.findShopBySimilarity(gameDto, ?), gameDto);
//
//            //
//
//            return ResponseEntity.ok(gameDto);
//        }
//        else {
//            // 게임 아직 진행중
//            return ResponseEntity.ok(gameDto);
//        }
//    }
}
