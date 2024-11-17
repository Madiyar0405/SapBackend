package com.project.sapbackend.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "IncidentCauses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "causeId")
public class IncidentCause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cause_id")
    private Long causeId;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToMany(mappedBy = "incidentCauses", fetch = FetchType.LAZY)
//    @JsonBackReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "causeId")
    @JsonIgnoreProperties("incidentCauses") // Prevents serialization of the owning side
    private Set<IncidentRequest> incidentRequests;

}
