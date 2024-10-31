package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "requeststatus")
public class RequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @Column(nullable = false, length = 255)
    private String name;

    // Constructors, getters, setters
}
