package com.example.gradle.controller;

import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.request.CreateUserDepartmentRequest;
import com.example.gradle.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/api/department", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;
    @PostMapping("/create")
    public ResponseEntity<?> createDepartment(@RequestBody @Valid CreateDegreeRequest input){
        return ResponseEntity.ok(service.createDepartment(input));
    }
    @PostMapping("/create-department-user")
    public ResponseEntity<?> createDepartmentUser(@RequestBody @Valid CreateUserDepartmentRequest input){
        return ResponseEntity.ok(service.createDepartmentUser(input));
    }
}
