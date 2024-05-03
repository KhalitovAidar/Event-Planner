package com.planner.eventplanner.repositories;

import com.planner.eventplanner.models.CommunityRole;
import com.planner.eventplanner.utils.enums.CommunityRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CommunityRoleRepository extends JpaRepository<CommunityRole, UUID> {
    public Set<CommunityRoleType> findCommunityRolesByUserId(UUID userId);
}
