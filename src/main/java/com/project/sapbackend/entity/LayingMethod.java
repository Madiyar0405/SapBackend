package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LayingMethods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LayingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long methodId;

    @Column(nullable = false, length = 255)
    private String name;
}

