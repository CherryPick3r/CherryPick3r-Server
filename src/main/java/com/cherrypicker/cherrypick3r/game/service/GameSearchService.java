package com.cherrypicker.cherrypick3r.game.service;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameSearchService {

    private final GameRepository gameRepository;

    public Game findGameById(Long id) {
        return gameRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게임이 존재하지 않습니다."));
    }

}
