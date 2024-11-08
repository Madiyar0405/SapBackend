package com.project.sapbackend.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    ENGINEER(
            Set.of(CRUDPermission.CREATE, CRUDPermission.READ, CRUDPermission.UPDATE, CRUDPermission.DELETE),
            Set.of(RACIPermission.RESPONSIBLE, RACIPermission.ACCOUNTABLE)
    ),
    ADMIN(
            Set.of(CRUDPermission.CREATE, CRUDPermission.READ, CRUDPermission.UPDATE, CRUDPermission.DELETE),
            Set.of(RACIPermission.RESPONSIBLE, RACIPermission.ACCOUNTABLE)
    ),
    USER(
            Set.of(CRUDPermission.CREATE, CRUDPermission.READ),
            Set.of(RACIPermission.INFORMED)
    ),
    ANALYST(
            Set.of(CRUDPermission.READ),
            Set.of(RACIPermission.INFORMED)
    );

    @Getter
    private final Set<CRUDPermission> crudPermissions;
    @Getter
    private final Set<RACIPermission> raciPermissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getCrudPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority("CRUD_" + permission.getPermissionCode()))
                .collect(Collectors.toList());

        authorities.addAll(
                getRaciPermissions()
                        .stream()
                        .map(permission -> new SimpleGrantedAuthority("RACI_" + permission.getPermissionCode()))
                        .collect(Collectors.toList())
//                        .toList()
        );

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
