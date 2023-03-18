package com.example.gradle.service.impl;

import com.example.gradle.entity.Degree;
import com.example.gradle.entity.Department;
import com.example.gradle.entity.User;
import com.example.gradle.exceptions.ServiceApiException;
import com.example.gradle.model.request.CreateUserRequest;
import com.example.gradle.model.response.IdResponse;
import com.example.gradle.repository.DegreeRepository;
import com.example.gradle.repository.DepartmentRepository;
import com.example.gradle.repository.UserRepository;
import com.example.gradle.service.UserService;
import com.example.gradle.utils.BankUtils;
import com.example.gradle.utils.ErrorCode;
import com.example.gradle.utils.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public String Numbers(long numbers) {
        int count = 0;
        long num = numbers;
        while (num > 0) {
            num /= 10;
            count++;
        }
        String out = "";
        while (4 - count > 0) {
            out = out + "0";
            count++;
        }
        return out + numbers;
    }
    @Override
    public IdResponse createUser(CreateUserRequest input) {
        Optional<User> optional=  userRepository.getByEmailAndPhone(input.getEmail(),input.getPhone());
        if (optional.isPresent()){
            throw new ServiceApiException(ErrorCode.ERROR03, ErrorMessage.MESSAGE03);
        }
        long number = userRepository.countUser(input.getUserCode()) + 1;
        User user = new User();
        user.setEmail(input.getEmail());
        user.setPhone(input.getPhone());
        user.setDateOfBirth(input.getDateOfBirth());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setAddress(input.getAddress());
        user.setUserCode(input.getUserCode() + Numbers(number));
        user.setBankName(input.getBankName());
        user.setAccountType(input.getAccountType());
        user.setAccountNumber(input.getAccountNumber());
        user.setTaxCode(input.getTaxCode());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return new IdResponse(user.getId());
    }
}
