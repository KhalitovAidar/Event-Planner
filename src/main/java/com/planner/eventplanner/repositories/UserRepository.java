package com.planner.eventplanner.repositories;

import com.planner.eventplanner.models.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Id> {
    Optional<User> findByUsername(String username);
}
