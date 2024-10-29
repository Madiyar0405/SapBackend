package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "production_objects")
public class ProductionObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_object_id")
    private Long productionObjectId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_object_id")
    private AdministrativeObject administrativeObject;

    @OneToMany(mappedBy = "productionObject", cascade = CascadeType.ALL)
    private Set<Horizon> horizons;

}