package com.planner.eventplanner.models;

import com.planner.eventplanner.utils.enums.CommunityRoleType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

// TODO: maybe delete this entity
@Entity
@Table(name = "community_role")
public class CommunityRole {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private CommunityRoleType type;
}
