package com.klu.jwt.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.*;
import com.klu.jwt.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class JwtController {

    private final JwtUtil jwt;

    public JwtController(JwtUtil jwt) {
        this.jwt = jwt;
    }

    @PostMapping("/generate")
    public String generate(@RequestBody Map<String,String> user) {
        return jwt.generateToken(
            user.get("username"), user.get("role"));
    }
}