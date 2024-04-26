package com.planner.eventplanner.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @OneToMany(fetch = LAZY, mappedBy = "user", cascade = PERSIST)
    private List<CommunityRole> communityRoles = new ArrayList<>();

    @OneToMany(fetch = LAZY, mappedBy = "user", cascade = PERSIST)
    private List<PostRole> postRoles = new ArrayList<>();
}
