package com.example.gradle.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDepartmentRequest {
    private Integer userId;
    private Integer departmentId;
    private String nameDepartment;
}
