package com.project.sapbackend.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CRUDPermission {
    CREATE("C"),
    READ("R"),
    UPDATE("U"),
    DELETE("D");

    @Getter
    private final String permissionCode;
}