package com.planner.eventplanner.services;

import com.planner.eventplanner.repositories.CommunityRoleRepository;
import com.planner.eventplanner.repositories.PostRoleRepository;
import com.planner.eventplanner.security.MainAuthentication;
import com.planner.eventplanner.utils.Role;
import com.planner.eventplanner.utils.enums.CommunityRoleType;
import com.planner.eventplanner.utils.enums.PostRoleType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final CommunityRoleRepository communityRoleRepository;
    private final PostRoleRepository postRoleRepository;

    @Transactional
    public boolean hasAnyRoleInPost(UUID postId, Role... roles) {
        final UUID userId = (UUID) ((MainAuthentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        final Set<CommunityRoleType> communityRoleTypes = communityRoleRepository.findCommunityRoleByUserId(userId);

        for(Role role: roles) {
            if (communityRoleTypes.stream().anyMatch(roleType -> roleType.includes(role))) {
                return true;
            }
        }

        final Set<PostRoleType> postRoleTypes = postRoleRepository.findRoleTypesByUserIdAndPostId(userId, postId);

        for(Role role: roles) {
            if (postRoleTypes.stream().anyMatch(roleType -> roleType.includes(role))) {
                return true;
            }
        }

        return false;
    }
}
