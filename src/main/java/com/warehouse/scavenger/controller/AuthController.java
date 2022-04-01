package com.warehouse.scavenger.controller;

import com.warehouse.scavenger.common.pojo.AuthRequest;
import com.warehouse.scavenger.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.security.PermitAll;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/auth")
    @PermitAll
    public String getAuthPage() {
        return "login";
    }

    @PostMapping(path = "/authProcess", consumes = "application/json")
    public ResponseEntity processAuth(@RequestBody AuthRequest request) {
        String response = authService.processAuth(request.getLogin(), request.getPassword());
        return ResponseEntity.ok().body(response);
    }
}
