package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "requestextensioncauses")
public class RequestExtensionCause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long causeId;

    @Column(nullable = false, length = 255)
    private String name;
}