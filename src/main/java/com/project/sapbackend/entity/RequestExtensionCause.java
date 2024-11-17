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
@Table(name = "requestextensioncauses")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "causeId", scope = RequestExtensionCause.class)
public class RequestExtensionCause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cause_id")
    private Long causeId;

    @Column(nullable = false, length = 255)
    private String name;


    @ManyToMany(mappedBy = "requestExtensionCauses",  fetch = FetchType.LAZY)
    @JsonIgnoreProperties("requestExtensionCauses")
    private Set<RequestProcessing> requestProcessings;
}