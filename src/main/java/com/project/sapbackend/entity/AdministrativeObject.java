package com.project.sapbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "administrativeobjects")
public class AdministrativeObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer objectId;

    @Column(name = "name", nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


    @OneToMany(mappedBy = "administrativeObject", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductionObject> productionObjects;
}