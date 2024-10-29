package com.project.sapbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "support_group")
public class SupportGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "name", nullable = false)
    private String name;
}