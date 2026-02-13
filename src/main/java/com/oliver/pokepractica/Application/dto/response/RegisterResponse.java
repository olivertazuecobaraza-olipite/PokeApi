package com.oliver.pokepractica.Application.dto.response;

import java.util.Set;

import com.oliver.pokepractica.domain.enums.Role;

import lombok.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class RegisterResponse {
    private String username;
    private String email;
    private Set<Role> roles;
}
