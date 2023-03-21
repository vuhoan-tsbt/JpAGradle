package com.example.gradle.service;

import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.request.CreateUserDegreeRequest;
import com.example.gradle.model.response.IdResponse;

public interface DegreeService {
    IdResponse createDegree(CreateDegreeRequest input);

    IdResponse createUserDegree(CreateUserDegreeRequest input);

    IdResponse updateUserDegree(Integer id, CreateUserDegreeRequest input);
}
