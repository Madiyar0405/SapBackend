package com.project.sapbackend.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "optical_fiber_lines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OpticalFiberLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "administrative_object_id")
    private AdministrativeObject administrativeObject;
}