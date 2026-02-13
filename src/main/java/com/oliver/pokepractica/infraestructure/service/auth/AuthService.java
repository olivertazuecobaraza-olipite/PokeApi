package com.oliver.pokepractica.infraestructure.service.auth;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oliver.pokepractica.application.dto.request.auth.LoginRequest;
import com.oliver.pokepractica.application.dto.request.auth.RegisterRequest;
import com.oliver.pokepractica.application.dto.response.auth.LoginResponse;
import com.oliver.pokepractica.application.dto.response.auth.RegisterResponse;
import com.oliver.pokepractica.domain.enty.user.Usuario;
import com.oliver.pokepractica.domain.enums.Role;
import com.oliver.pokepractica.infraestructure.repository.usuario.UsuarioRepository;
import com.oliver.pokepractica.infraestructure.security.jwt.JwtService;

@Service
public class AuthService {
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registro de usuario
    public RegisterResponse register(RegisterRequest request){
        if (!request.getPassword().equals(request.getConfirmarPassword())) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }
        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("El username ya existe");
        }
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El email ya existe");
        }

        Usuario user = new Usuario();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(Role.ROLE_TRAINER, Role.ROLE_USER)); 

        usuarioRepository.save(user);

        return new RegisterResponse(
            user.getUsername(),
            user.getEmail(),
            user.getRoles()
        );
    }

    // Login de usuario
    public LoginResponse login(LoginRequest request){
        Usuario user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(user);
        return new LoginResponse(token);
    }
}
