package com.oliver.pokepractica.infraestructure.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.pokepractica.infraestructure.service.auth.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.oliver.pokepractica.Application.dto.request.LoginRequest;
import com.oliver.pokepractica.Application.dto.request.RegisterRequest;
import com.oliver.pokepractica.Application.dto.response.LoginResponse;
import com.oliver.pokepractica.Application.dto.response.RegisterResponse;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;


    // login
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
    
    // register
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
    
}
