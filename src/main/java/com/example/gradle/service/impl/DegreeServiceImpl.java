package com.example.gradle.service.impl;

import com.example.gradle.entity.Degree;
import com.example.gradle.exceptions.ServiceApiException;
import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.model.response.IdResponse;
import com.example.gradle.repository.DegreeRepository;
import com.example.gradle.service.DegreeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;
    @Override
    public IdResponse createDegree(CreateDegreeRequest input) {
        Optional<Degree> degree = degreeRepository.getByName(input.getName());
        if(degree.isPresent()){
            throw new ServiceApiException("Error_01","Bằng cấp đã tồn tại");
        }
        Degree response = new Degree();
        response.setName(input.getName());
        response.setValue(input.getValue());
        response.setCreatedAt(LocalDateTime.now());
        degreeRepository.save(response);
        return new IdResponse(response.getId());
    }
}
