package com.cherrypicker.cherrypick3r.game.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
