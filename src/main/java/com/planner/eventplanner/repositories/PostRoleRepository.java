package com.planner.eventplanner.repositories;

import com.planner.eventplanner.models.PostRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRoleRepository extends JpaRepository<PostRole, UUID> {
}
