package com.example.gradle.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {
}
