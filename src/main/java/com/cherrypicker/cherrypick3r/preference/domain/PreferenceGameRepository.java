package com.cherrypicker.cherrypick3r.preference.domain;

import com.cherrypicker.cherrypick3r.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenceGameRepository extends JpaRepository<PreferenceGame, Long> {
    List<PreferenceGame> findAllByUser(User user);
}
