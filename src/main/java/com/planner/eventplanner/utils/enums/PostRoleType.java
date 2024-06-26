package com.planner.eventplanner.utils.enums;

import com.planner.eventplanner.utils.Role;

import java.util.HashSet;
import java.util.Set;

public enum PostRoleType implements Role {
    VIEWER, EDITOR, REPORTER;

    private final Set<Role> children = new HashSet<>();

    static {
        REPORTER.children.add(VIEWER);
        EDITOR.children.add(VIEWER);
    }

    @Override
    public boolean includes(Role role) {
        return this.equals(role) || children.stream().anyMatch(r -> r.includes(role));
    }
}