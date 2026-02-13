package com.oliver.pokepractica.infraestructure.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliver.pokepractica.domain.enty.user.Usuario;

@Repository
public interface UsuarioRepository extends  JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
