package com.planner.eventplanner.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

//@Entity
//@Table
//@Data
public class Community {
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
//    private UUID id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @OneToMany(fetch = LAZY, mappedBy = "community")
//    private List<Post> post = new ArrayList<>();
}
