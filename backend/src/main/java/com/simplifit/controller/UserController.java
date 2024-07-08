package com.simplifit.controller;

import com.simplifit.model.BodyMeasurements;
import com.simplifit.model.HealthMetrics;
import com.simplifit.model.PersonalEvaluation;
import com.simplifit.model.UserInfo;
import com.simplifit.service.UnifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UnifiedService unifiedService;

    @Autowired
    public UserController(UnifiedService unifiedService) {
        this.unifiedService = unifiedService;
    }

    @GetMapping("/users")
    public List<UserInfo> getAllUsers() {
        return unifiedService.getAllUsers();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Spring Boot application is running!";
    }

    @GetMapping("/users/{userId}")
    public UserInfo getUserById(@PathVariable int userId) {
        return unifiedService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserInfo saveUser(@RequestBody UserInfo user) {
        return unifiedService.saveUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        unifiedService.deleteUser(userId);
    }

    @GetMapping("/healthmetrics")
    public ResponseEntity<List<HealthMetrics>> getAllHealthMetrics() {
        List<HealthMetrics> metrics = unifiedService.getAllHealthMetrics();
        return ResponseEntity.ok(metrics);
    }

    @GetMapping("/bodymeasurements")
    public ResponseEntity<List<BodyMeasurements>> getAllBodyMeasurements() {
        List<BodyMeasurements> measurements = unifiedService.getAllBodyMeasurements();
        return ResponseEntity.ok(measurements);
    }

    @GetMapping("/personalevaluations")
    public ResponseEntity<List<PersonalEvaluation>> getAllPersonalEvaluations() {
        List<PersonalEvaluation> evaluations = unifiedService.getAllPersonalEvaluations();
        return ResponseEntity.ok(evaluations);
    }
}
