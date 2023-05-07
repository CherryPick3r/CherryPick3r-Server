package com.cherrypicker.cherrypick3r.game.service;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class GameService {

    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    private final TagRepository tagRepository;

    private final ShopRepository shopRepository;

    private final ResultRepository resultRepository;

    @Transactional
    public GameDto makeGame(String userEmail) {
        User user = userRepository.findByEmail(userEmail).get();
        Tag tag;

        if (user == null) {
            return null; // UserNotFound 에러 핸들링으로 바꿔야함
        }

        // 새로운 게임 태그 생성 및 영속성 등록
        tag = new Tag();
        tagRepository.save(tag);

        // TODO: 유저의 기본 태그를 반영해서 태그 초기값을 설정해야함

        Game game = Game.builder()
                .totalRound(12L) // 임의의 라운드 12라운드로 설정, 3라운드씩 추천 (4번 후 종료)
                .curRound(0L) // 0라운드부터 시작
                .status(0L) // 게임은 시작하지 않은 상태
                .user(user) // 유저가 존재한다면 게임을 시작시킨 유저를 설정
                .tag(tag) // 새로운 게임 태그 외래키 연결
                .build();
        gameRepository.save(game);

        // 게임 시작
        game.setStatusStart();

        return (game.toDto());
    }

    @Transactional
    public GameDto swipeLeft(GameDto gameDto, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        Game game = gameRepository.findById(gameDto.getId()).get();

        if (shop == null) {
            return null; // ShopNotFoundException
        }
        if (game == null) {
            return null; // GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // EndedGameException
        }

        // TODO: 선택한 가게과 게임의 태그 값을 수식을 이용해서 싫어요에 대한 반영 수식을 적용한다.

        // TODO: 만약 게임이 끝에 도달했다면 결과를 도출한다. (다른 함수로 뺼 것)
        gameRepository.save(game);
        return game.toDto();
    }

    @Transactional
    public GameDto swipeRight(GameDto gameDto, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        Game game = gameRepository.findById(gameDto.getId()).get();

        if (shop == null) {
            return null; // ShopNotFoundException
        }
        if (game == null) {
            return null; // GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // EndedGameException
        }

        // TODO: 선택한 가게과 게임의 태그 값을 수식을 이용해서 일부 유사하게 만든다.

        // TODO: 만약 게임이 끝에 도달했다면 결과를 도출한다. (다른 함수로 뺼 것)
        gameRepository.save(game);
        return game.toDto();
    }

    @Transactional
    public ShopDto endGame(GameDto gameDto, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        Game game = gameRepository.findById(gameDto.getId()).get();
        Result result;

        if (shop == null) {
            return null; // ShopNotFoundException
        }
        if (game == null) {
            return null; // GameNotFoundException
        }
        if (game.getStatus() == 3L) {
            return null; // EndedGameException
        }

        // 게임의 상태를 종료로 만든다.
        game.setStatusEnd();

        // 결과(체리픽)를 만든다.
        result = Result.builder()
                .shop(shop)
                .game(game)
                .build();
        resultRepository.save(result);

        // 가게의 picked_count를 1늘린다.
        shop.increasePickedCount();
        shopRepository.save(shop);

        // 결과 가게의 DTO를 반환
        return shop.toDto();
    }

}
