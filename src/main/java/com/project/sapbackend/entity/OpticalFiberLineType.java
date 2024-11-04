package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "optical_fiber_line_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OpticalFiberLineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;
}
