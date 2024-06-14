package com.cherrypicker.cherrypick3r.result.service;

import com.cherrypicker.cherrypick3r.game.domain.Game;
import com.cherrypicker.cherrypick3r.game.domain.GameRepository;
import com.cherrypicker.cherrypick3r.game.dto.GameDto;
import com.cherrypicker.cherrypick3r.result.domain.Result;
import com.cherrypicker.cherrypick3r.result.domain.ResultRepository;
import com.cherrypicker.cherrypick3r.result.dto.ResultDto;
import com.cherrypicker.cherrypick3r.shop.domain.Shop;
import com.cherrypicker.cherrypick3r.shop.dto.ShopDto;
import com.cherrypicker.cherrypick3r.shop.dto.ShopSimple;
import com.cherrypicker.cherrypick3r.shop.service.ShopSearchService;
import com.cherrypicker.cherrypick3r.user.domain.User;
import com.cherrypicker.cherrypick3r.user.service.UserSearchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ResultService {

    private final ResultRepository resultRepository;

    private final ShopSearchService shopSearchService;

    private final GameRepository gameRepository;

    private final UserSearchService userSearchService;

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
    public ResultDto createResult(ShopDto shopDto, GameDto gameDto) {
        Shop shop = shopSearchService.findShopById(shopDto.getId());
        Game game = gameRepository.findById(gameDto.getId()).get();

        Result result = Result.builder()
                .shop(shop)
                .game(game)
                .build();

        resultRepository.save(result);

        return result.toDto();
    }

    @Transactional
    public void deleteResult(Long id) {
        Result result = resultRepository.findById(id).get();

        if (result == null) {
            return ; // TODO: ResultNotFountException
        }

        resultRepository.delete(result);

        return ;
    }
    @Transactional
    public void deleteResultByShopId(Long id) {
        Shop shop = shopSearchService.findShopById(id);

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

    @Transactional
    public Long findResultCountByUserEmail(String userEmail) {
        User user = userSearchService.findUserByEmail(userEmail);
        List<Game> games = gameRepository.findAllByUser(user);
        List<Result> results = new ArrayList<>();

        for (Game game : games) {
            Result result = resultRepository.findByGame(game);

            if (result != null)
                results.add(result);
        }

        return Long.valueOf(results.size());
    }

    @Transactional
    public List<ShopSimple> find3ShopSimpleByUserEmail(String userEmail) {
        User user = userSearchService.findUserByEmail(userEmail);
        List<Game> games = gameRepository.findAllByUser(user);
        List<ShopSimple> shopSimples = new ArrayList<>();
        int cnt = 0;

        Collections.reverse(games);
        for (Game game : games) {
            Result result = resultRepository.findByGame(game);

            if (result != null) {
                if (cnt >= 3)
                    break;
                shopSimples.add(new ShopSimple(result.getShop(), result.getCreatedTime()));
                cnt++;
            }
        }

        return shopSimples;
    }

}
