package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "production_objects")
public class ProductionObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_object_id")
    private Integer productionObjectId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_object_id")
    private AdministrativeObject administrativeObject;


    @OneToMany(mappedBy = "productionObject", cascade = CascadeType.ALL)
    private List<Horizon> horizons;
}
