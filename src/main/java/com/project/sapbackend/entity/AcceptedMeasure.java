package com.project.sapbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.Set;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "acceptedmeasures", schema = "DBADMIN")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "measureId", scope = AcceptedMeasure.class)
public class AcceptedMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measure_id")
    private Long measureId;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToMany(mappedBy = "acceptedMeasures", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("acceptedMeasures")
    private Set<RequestProcessing> requestProcessings;

    // Constructors, getters, setters
}