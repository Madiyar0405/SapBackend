package com.project.sapbackend.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "supportgroup")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "supportgroup_employee",
            joinColumns = @JoinColumn(name = "support_group_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> employees;


}
