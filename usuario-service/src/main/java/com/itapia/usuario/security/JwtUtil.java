package com.itapia.usuario.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "claveSecreta123"; // simple para estudio
    private final long EXPIRATION = 1000 * 60 * 60; // 1 hora

    public String generarToken(String username, Set<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles.stream().collect(Collectors.joining(",")))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String obtenerUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public Set<String> obtenerRoles(String token) {
        String roles = (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("roles");
        return Set.of(roles.split(","));
    }
}
