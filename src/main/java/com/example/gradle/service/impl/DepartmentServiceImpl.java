package com.example.gradle.service.impl;

import com.example.gradle.entity.Department;
import com.example.gradle.entity.User;
import com.example.gradle.entity.UserDepartment;
import com.example.gradle.exceptions.ServiceApiException;
import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.request.CreateUserDepartmentRequest;
import com.example.gradle.model.response.IdResponse;
import com.example.gradle.repository.DepartmentRepository;
import com.example.gradle.repository.UserDepartmentRepository;
import com.example.gradle.repository.UserRepository;
import com.example.gradle.service.DepartmentService;
import com.example.gradle.utils.ErrorCode;
import com.example.gradle.utils.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final UserDepartmentRepository userDepartmentRepository;

    @Override
    @Transactional
    public IdResponse createDepartment(CreateDegreeRequest input) {
        Optional<Department> optional = departmentRepository.getByNameDepartment(input.getName());
        if (optional.isPresent()) {
            throw new ServiceApiException(ErrorCode.ERROR02, ErrorMessage.MESSAGE02);
        }
        Department department = new Department();
        department.setName(input.getName());
        department.setValue(input.getValue());
        department.setCreatedAt(LocalDateTime.now());
        departmentRepository.save(department);
        return new IdResponse(department.getId());
    }

    @Override
    @Transactional
    public IdResponse createDepartmentUser(CreateUserDepartmentRequest input) {
        Optional<Department> department = departmentRepository.getByIdDepartment(input.getDepartmentId());
        if (department.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR05, ErrorMessage.MESSAGE05);
        }
        Optional<User> optional = userRepository.getByUserId(input.getUserId());
        if (optional.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR06, ErrorMessage.MESSAGE06);
        }
        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setUsers(optional.get());
        userDepartment.setTypeDepartment(department.get());
        userDepartment.setName(input.getNameDepartment());
        userDepartment.setCreatedAt(LocalDateTime.now());
        userDepartmentRepository.save(userDepartment);
        return new IdResponse(userDepartment.getId());
    }

    @Override
    public IdResponse updateUserDepartment(Integer id, CreateUserDepartmentRequest input) {
        Optional<UserDepartment> userDepartment = userDepartmentRepository.getByIdUserDepartment(id);
        if (userDepartment.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR07, ErrorMessage.MESSAGE07);
        }
        Optional<Department> department = departmentRepository.getByIdDepartment(input.getDepartmentId());
        if (department.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR05, ErrorMessage.MESSAGE05);
        }
        Optional<User> optional = userRepository.getByUserId(input.getUserId());
        if (optional.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR06, ErrorMessage.MESSAGE06);
        }
        userDepartment.get().setUsers(optional.get());
        userDepartment.get().setTypeDepartment(department.get());
        userDepartment.get().setName(input.getNameDepartment());
        userDepartment.get().setUpdateAt(LocalDateTime.now());
        userDepartmentRepository.save(userDepartment.get());
        return new IdResponse(userDepartment.get().getId());
    }
}
