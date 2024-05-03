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
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = LAZY, mappedBy = "post", cascade = PERSIST)
    private List<PostRole> postRoles = new ArrayList<>();

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "community_id", updatable = false)
//    private Community community;
}
