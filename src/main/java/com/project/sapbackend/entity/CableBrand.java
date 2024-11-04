package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CableBrands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CableBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cableId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 50)
    private String cableType;
}
