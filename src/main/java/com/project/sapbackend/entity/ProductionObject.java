package com.project.sapbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
