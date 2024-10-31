package com.project.sapbackend.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RACIPermission {
    RESPONSIBLE("R"),
    ACCOUNTABLE("A"),
    CONSULTED("C"),
    INFORMED("I");

    @Getter
    private final String permissionCode;
}
