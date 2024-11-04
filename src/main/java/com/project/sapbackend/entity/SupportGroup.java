package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SupportGroup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(nullable = false, length = 255)
    private String name;
}
