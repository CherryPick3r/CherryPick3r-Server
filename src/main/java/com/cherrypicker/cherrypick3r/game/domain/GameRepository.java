package com.cherrypicker.cherrypick3r.game.domain;

import com.cherrypicker.cherrypick3r.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByUser(User user);
}
