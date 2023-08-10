package com.cherrypicker.cherrypick3r.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserMappingRepository extends JpaRepository<User, String> {

    Optional<UserMapping> findByEmail(String email);
}
