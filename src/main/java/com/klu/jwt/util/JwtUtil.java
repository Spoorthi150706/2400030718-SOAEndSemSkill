package com.klu.jwt.util;

import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    SecretKey key = Keys.hmacShaKeyFor(
        "0123456789abcdef0123456789abcdef"
        .getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username, String role) {
        return Jwts.builder()
            .subject(username)
            .claim("role", role)
            .signWith(key)
            .compact();
    }
}