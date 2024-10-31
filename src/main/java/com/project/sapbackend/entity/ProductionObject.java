package com.project.sapbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "productionobjects")
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
    @JsonIgnore
    private List<Horizon> horizons;
}
