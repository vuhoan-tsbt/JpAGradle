package com.example.gradle.exceptions;

import com.example.gradle.codes.TemplateApiErrorCodes;
import com.example.gradle.codes.ErrorCodesUtil;
import com.example.gradle.dto.ApiResponse;
import com.example.gradle.dto.ApplicationErrorResponseDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServiceApiExceptionHandler {
    private static final String LOG_TEMPLATE = "{}::{}() - {}";

    private static final String DEFAULT_GET_MESSAGE_ERROR = "System Error.";
    private static final String EXCEPTION = "exception";
    private static final String PATTERN = "^requestDto\\.(.+)$";
    private static final String INVALID_JSON_FORMAT_STRING = "Invalid JSON format.";
    private static final String INVALID_DATE_FORMAT = "Invalid date format.";
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ServiceApiExceptionHandler.class);


    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ServiceApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse templateApiException(ServiceApiException ex) {


        LOGGER.error(LOG_TEMPLATE, getClass().getSimpleName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(), ex);

        final ApplicationErrorResponseDto error = new ApplicationErrorResponseDto(
                ex.getResultCode(), ex.getErrorMessage());

        error.addErrorKeyAndObjectDetail(EXCEPTION, ex.getErrorMessage());

        return error;
    }

    @ExceptionHandler({DataAccessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleDataException(Exception ex) {

        final String errorMsg = ErrorCodesUtil.getMessage(messageSource,
                TemplateApiErrorCodes.DEFAULT_ERROR, DEFAULT_GET_MESSAGE_ERROR);

        final ApplicationErrorResponseDto error = new ApplicationErrorResponseDto(
                String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        error.addErrorKeyAndObjectDetail(EXCEPTION, errorMsg);
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationErrorResponseDto handleMethodNotValidException(MethodArgumentNotValidException ex) {

        final ApplicationErrorResponseDto error = new ApplicationErrorResponseDto(
                String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase());

        for (final FieldError field : ex.getBindingResult().getFieldErrors()) {
            final String name = field.getField().replaceAll(PATTERN, "$1");
            error.addErrorKeyAndObjectDetail(name, field.getDefaultMessage());
        }

        return error;
    }

    @ExceptionHandler({JsonParseException.class, JsonMappingException.class, MismatchedInputException.class,
            DateTimeParseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationErrorResponseDto handleJsonParseMappingException(Exception ex) {

        String message = ex.getMessage().length() > 120 ? ex.getMessage().substring(0, 120) : ex.getMessage();
        String field = EXCEPTION;

        if (ex.getMessage().contains("Date")) {
            message = ErrorCodesUtil.getMessage(messageSource, TemplateApiErrorCodes.ISO_DATE_FORMAT_CHECK,
                    INVALID_DATE_FORMAT);
        }

        if (ex.getCause() instanceof JsonMappingException) {
            final JsonMappingException mappingExc = (JsonMappingException) ex.getCause();

            if (!mappingExc.getPath().isEmpty() && mappingExc.getPath().size() > 1) {
                field = mappingExc.getPath().get(1).getFieldName();
            }
        }

        return generateErrorResponseDto(field, message);
    }

    private ApplicationErrorResponseDto generateErrorResponseDto(final String field, String message) {
        final ApplicationErrorResponseDto error = new ApplicationErrorResponseDto(
                String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase());

        error.addErrorKeyAndObjectDetail(field, message);

        return error;
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationErrorResponseDto handleMethodNotValidException(MissingPathVariableException ex) {

        final ApplicationErrorResponseDto error = new ApplicationErrorResponseDto(
                String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase());

        error.addErrorKeyAndObjectDetail(EXCEPTION, "miss path param :" + ex.getVariableName());

        return error;
    }
}
