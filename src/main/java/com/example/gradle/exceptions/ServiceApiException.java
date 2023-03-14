package com.example.gradle.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
public class ServiceApiException extends RuntimeException{

    private static final long serialVersionUID = -4998452844437648420L;

    private final String resultCode;

    private final String errorMessage;
}
