package com.example.gradle.service;

import com.example.gradle.model.request.CreateUserRequest;
import com.example.gradle.model.response.IdResponse;

public interface UserService {
    IdResponse createUser(CreateUserRequest input);
}
