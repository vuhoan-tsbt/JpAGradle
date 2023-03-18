package com.example.gradle.service;

import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.response.IdResponse;

public interface DegreeService {
    IdResponse createDegree(CreateDegreeRequest input);
}
