package com.project.sapbackend.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "it_service_catalog")
public class ITServiceCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    private String serviceName;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List <RequestType> requestTypes;

}
