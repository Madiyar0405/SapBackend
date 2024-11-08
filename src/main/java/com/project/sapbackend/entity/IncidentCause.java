package com.project.sapbackend.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "IncidentCauses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidentCause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long causeId;

    @Column(nullable = false, length = 255)
    private String name;
}
