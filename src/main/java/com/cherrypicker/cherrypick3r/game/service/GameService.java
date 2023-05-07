package com.cherrypicker.cherrypick3r.game.service;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
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

        Game game = Game.builder()
                .totalRound(12L) // 임의의 라운드 12라운드로 설정, 3라운드씩 추천 (4번 후 종료)
                .curRound(0L) // 0라운드부터 시작
                .status(0L) // 게임은 시작하지 않은 상태
                .user(user) // 유저가 존재한다면 게임을 시작시킨 유저를 설정
                .tag(tag) // 새로운 게임 태그 외래키 연결
                .build();
        gameRepository.save(game);

        return (game.toDto());
    }

//    @Transactional
//    public GameDto swipeLeft(GameDto gameDto, ) {
//
//    }


}
