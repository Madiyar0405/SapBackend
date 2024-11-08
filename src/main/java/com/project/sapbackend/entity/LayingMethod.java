package com.project.sapbackend.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "layingmethods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LayingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long methodId;

    @Column(nullable = false, length = 255)
    private String name;
}

