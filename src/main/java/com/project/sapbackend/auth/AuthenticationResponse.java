package com.project.sapbackend.auth;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sapbackend.entity.Employee;
import com.project.sapbackend.entity.User;
import com.project.sapbackend.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    private String username;

    private User user;

    private Employee employee;

    private Role role;
}
