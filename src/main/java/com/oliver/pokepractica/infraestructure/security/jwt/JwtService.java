package com.oliver.pokepractica.infraestructure.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oliver.pokepractica.domain.enty.user.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    

    // Generate token
    public String generateToken(Usuario usuario) {
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", usuario.getUsername());
        claims.put("roles", usuario.getRoles().stream().map(Enum::name).toList());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(key)
                .compact();
    }

    // Extract username
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    // Extrarct Roles
    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        return (List<String>) parseClaims(token).get("roles");
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    // Validar token
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // Verificar si el token ha expirado
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
