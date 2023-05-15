package com.cherrypicker.cherrypick3r.result.service;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.domain.ShopRepository;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final ShopRepository shopRepository;
    private final GameRepository gameRepository;

    @Transactional
    public Result createResult(Shop shop, Game game) {
        Result result = Result.builder()
                .shop(shop)
                .game(game)
                .build();

        resultRepository.save(result);

        return result;
    }

    @Transactional
    public void deleteResult(Long id) {
        Result result = resultRepository.findById(id).get();

        if (result == null) {
            return ; // ResultNotFountException
        }

        resultRepository.delete(result);

        return ;
    }

    @Transactional
    public List<ResultDto> findResultListByShopId(Long id) {
        List<Result> results = resultRepository.findByShop(shopRepository.findById(id).get());
        List<ResultDto> resultDtos = new ArrayList<>();

        for(Result result : results) {
            resultDtos.add(result.toDto());
        }

        return resultDtos;
    }

    @Transactional
    public ResultDto findResultByGameId(Long id) {
        Result result = resultRepository.findByGame(gameRepository.findById(id).get()).get(0);

        if (result == null) {
            return null; // ResultNotFoundException
        }

        return result.toDto();
    }

    @Transactional
    public void deleteResultByShopId(Long id) {
        Shop shop = shopRepository.findById(id).get();

        // PickedCount를 1줄인다.
        shop.decreasePickedCount();

        resultRepository.deleteByShop(shop);

        return ;
    }

    @Transactional
    public void deleteResultByGameId(Long id) {
        Game game = gameRepository.findById(id).get();

        resultRepository.deleteByGame(game);

        return ;
    }
}
