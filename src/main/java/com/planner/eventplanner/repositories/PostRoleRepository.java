package com.planner.eventplanner.repositories;

import com.planner.eventplanner.models.PostRole;
import com.planner.eventplanner.utils.enums.PostRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface PostRoleRepository extends JpaRepository<PostRole, UUID> {
    @Query("""
    select post_role from PostRole post_role
    join post_role.post
    where post_role.user.id = :userId and post_role.id = :postId
    """)
    public Set<PostRoleType> findRoleTypesByUserIdAndPostId(UUID userId, UUID postId);
}
