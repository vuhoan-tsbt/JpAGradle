package com.example.gradle.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDegreeRequest {
    private Integer userId;
    private Integer degreeId;
    private String nameDegree;
}
