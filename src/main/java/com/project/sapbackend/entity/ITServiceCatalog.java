package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "it_service_catalog")
public class ITServiceCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @OneToMany(mappedBy = "itServiceCatalog", cascade = CascadeType.ALL)
    private Set<RequestType> requestTypes;

}
