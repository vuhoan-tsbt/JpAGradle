package com.example.gradle.controller;

import com.example.gradle.model.request.CreateDegreeRequest;
import com.example.gradle.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/api/degree", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class DegreeController {
    private final DegreeService degreeService;
    @PostMapping("/create")
    public ResponseEntity<?> createDegree(@RequestBody @Valid CreateDegreeRequest input){
        return ResponseEntity.ok(degreeService.createDegree(input));
    }

}
