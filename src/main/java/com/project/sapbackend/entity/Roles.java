package com.project.sapbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
        // not used
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, length = 50)
    private String roleName;

}
