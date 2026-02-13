package com.oliver.pokepractica.Application.dto.request;

import lombok.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String email;
    private String username;
    private String password;
    private String confirmarPassword;
}
