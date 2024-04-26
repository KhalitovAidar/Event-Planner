package com.planner.eventplanner.utils;

import com.planner.eventplanner.utils.enums.CommunityRoleType;

import java.util.Set;

public interface Role {
    boolean includes(Role role);

    static Set<Role> roots() {
        return Set.of(CommunityRoleType.ADMIN);
    }
}