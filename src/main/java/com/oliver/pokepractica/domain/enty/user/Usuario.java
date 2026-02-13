package com.oliver.pokepractica.domain.enty.user;

import java.util.Set;

import com.oliver.pokepractica.domain.enums.Role;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    private String nombre;
    private String email;
    private String username;
    private String password;

    @ElementCollection(fetch= FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    Set<Role> roles;
    
}
