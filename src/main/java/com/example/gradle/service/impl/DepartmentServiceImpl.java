package com.example.gradle.service.impl;

import com.example.gradle.entity.Department;
import com.example.gradle.exceptions.ServiceApiException;
import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.response.IdResponse;
import com.example.gradle.repository.DepartmentRepository;
import com.example.gradle.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public IdResponse createDepartment(CreateDegreeRequest input) {
        Optional<Department> optional = departmentRepository.getByNameDepartment(input.getName());
        if (optional.isPresent()){
            throw new ServiceApiException("Error_02","Phòng ban chức vụ này đã tồn tại");
        }
        Department department = new Department();
        department.setName(input.getName());
        department.setValue(input.getValue());
        department.setCreatedAt(LocalDateTime.now());
        departmentRepository.save(department);
        return new IdResponse(department.getId());
    }
}
