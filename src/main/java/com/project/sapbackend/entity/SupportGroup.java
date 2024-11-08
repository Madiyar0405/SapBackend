package com.project.sapbackend.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "supportgroup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(nullable = false, length = 255)
    private String name;
}
