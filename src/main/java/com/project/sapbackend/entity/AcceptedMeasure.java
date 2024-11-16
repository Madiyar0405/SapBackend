package com.project.sapbackend.entity;

import javax.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "acceptedmeasures")
public class AcceptedMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measure_id")
    private Long measureId;

    @Column(nullable = false, length = 255)
    private String name;

    // Constructors, getters, setters
}