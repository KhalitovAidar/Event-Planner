package com.planner.eventplanner.repositories;

import com.planner.eventplanner.models.CommunityRole;
import com.planner.eventplanner.utils.enums.CommunityRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface CommunityRoleRepository extends JpaRepository<CommunityRole, UUID> {
    public Set<CommunityRoleType> findCommunityRoleByUserId(UUID userId);
}
