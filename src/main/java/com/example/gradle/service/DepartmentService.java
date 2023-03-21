package com.example.gradle.service;

import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.request.CreateUserDepartmentRequest;
import com.example.gradle.model.response.IdResponse;

public interface DepartmentService {
    IdResponse createDepartment(CreateDegreeRequest input);

    IdResponse createDepartmentUser(CreateUserDepartmentRequest input);

    IdResponse updateUserDepartment(Integer id, CreateUserDepartmentRequest input);
}
