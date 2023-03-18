package com.example.gradle.controller;

import com.example.gradle.model.request.CreateUserRequest;
import com.example.gradle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest input){
        return ResponseEntity.ok(userService.createUser(input));
    }

}
