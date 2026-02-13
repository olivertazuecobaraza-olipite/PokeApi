package com.oliver.pokepractica.application.dto.response.auth;

import java.util.Set;

import com.oliver.pokepractica.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class RegisterResponse {
    private String username;
    private String email;
    private Set<Role> roles;
}
