package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "horizons")
public class Horizon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horizon_id")
    private Integer horizonId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "production_object_id")
    private ProductionObject productionObject;

}
