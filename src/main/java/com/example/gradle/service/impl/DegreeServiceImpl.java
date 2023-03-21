package com.example.gradle.service.impl;

import com.example.gradle.entity.Degree;
import com.example.gradle.entity.User;
import com.example.gradle.entity.UserDegree;
import com.example.gradle.exceptions.ServiceApiException;
import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.request.CreateUserDegreeRequest;
import com.example.gradle.model.response.IdResponse;
import com.example.gradle.repository.DegreeRepository;
import com.example.gradle.repository.UserDegreeRepository;
import com.example.gradle.repository.UserRepository;
import com.example.gradle.service.DegreeService;
import com.example.gradle.utils.ErrorCode;
import com.example.gradle.utils.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;
    private final UserDegreeRepository userDegreeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public IdResponse createDegree(CreateDegreeRequest input) {
        Optional<Degree> degree = degreeRepository.getByName(input.getName());
        if (degree.isPresent()) {
            throw new ServiceApiException(ErrorCode.ERROR01, ErrorMessage.MESSAGE01);
        }
        Degree response = new Degree();
        response.setName(input.getName());
        response.setValue(input.getValue());
        response.setCreatedAt(LocalDateTime.now());
        degreeRepository.save(response);
        return new IdResponse(response.getId());
    }

    @Override
    @Transactional
    public IdResponse createUserDegree(CreateUserDegreeRequest input) {
        Optional<User> optional = userRepository.getByUserId(input.getUserId());
        if (optional.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR06, ErrorMessage.MESSAGE06);
        }
        Optional<Degree> optionalDegree = degreeRepository.getByIdDegree(input.getDegreeId());
        if (optionalDegree.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR04, ErrorMessage.MESSAGE04);
        }
        UserDegree degree = new UserDegree();
        degree.setUsers(optional.get());
        degree.setTypeDegree(optionalDegree.get());
        degree.setName(input.getNameDegree());
        degree.setCreatedAt(LocalDateTime.now());
        userDegreeRepository.save(degree);
        return new IdResponse(degree.getId());
    }

    @Override
    public IdResponse updateUserDegree(Integer id, CreateUserDegreeRequest input) {
        Optional<UserDegree> optional = userDegreeRepository.getByIdUserDegree(id);
        if (optional.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR07, ErrorMessage.MESSAGE07);
        }
        Optional<User> optionalUser = userRepository.getByUserId(input.getUserId());
        if (optional.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR06, ErrorMessage.MESSAGE06);
        }
        Optional<Degree> optionalDegree = degreeRepository.getByIdDegree(input.getDegreeId());
        if (optionalDegree.isEmpty()) {
            throw new ServiceApiException(ErrorCode.ERROR04, ErrorMessage.MESSAGE04);
        }
        optional.get().setTypeDegree(optionalDegree.get());
        optional.get().setName(input.getNameDegree());
        optional.get().setUsers(optionalUser.get());
        optional.get().setUpdateAt(LocalDateTime.now());
        optional.get().setCreatedAt(optional.get().getCreatedAt());
        userDegreeRepository.save(optional.get());
        return new IdResponse(optional.get().getId());
    }
}
