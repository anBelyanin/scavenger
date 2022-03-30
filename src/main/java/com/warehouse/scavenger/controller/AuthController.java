package com.warehouse.scavenger.controller;

import com.warehouse.scavenger.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class AuthController {

    AuthService authService;

    @GetMapping("/auth")
    @PermitAll
    public String getAuthPage() {
        return "login";
    }

    @GetMapping("/authProcess")
    @CrossOrigin(origins = "http://localhost:8080/scavenger/")
    public ResponseEntity processAuth() {
        return ResponseEntity.ok().body("Authorized");
    }
}
