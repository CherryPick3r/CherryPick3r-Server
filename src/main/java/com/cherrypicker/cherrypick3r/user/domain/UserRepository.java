package com.cherrypicker.cherrypick3r.user.domain;

import com.cherrypicker.cherrypick3r.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}