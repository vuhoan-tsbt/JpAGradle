package com.example.gradle.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String address;
    private String bankName;
    private String accountNumber;
    private String dateOfBirth;
    private String accountType;
    private String userCode;
    private String department;
    private Integer value;
    private String Degree;
    private Integer valueDegree;
    private String taxCode;
}
