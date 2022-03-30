package com.warehouse.scavenger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
public class HealthCheckController {

    @GetMapping("/healthCheck")
    @PermitAll
    public ResponseEntity getHealthCheck() {
        return ResponseEntity.ok().body("Service alive");
    }
}
