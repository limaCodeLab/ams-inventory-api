package com.skald.ats.inventory.api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    private HttpStatus status;
    private String errorMessage;
    private String fieldName;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError bodyResponseError = new StandardError(status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database (DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError bodyResponseError = new StandardError(status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<StandardError> noResourceFound (NoHandlerFoundException e, HttpServletRequest request) {
        String error = "Endpoint not found";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError bodyResponseError = new StandardError(status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(ValidationDataException.class)
    public ResponseEntity<StandardError> violationRule (ValidationDataException e, HttpServletRequest request) {
        String error = "Validation data error";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError bodyResponseError = new StandardError(status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardError> jsonInvalid (NullPointerException e, HttpServletRequest request) {
        String error = "Null pointer exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError bodyResponseError = new StandardError(status.value(), error,"Null value: " +  e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationData (MethodArgumentNotValidException e, HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        String nameError = "Validation data error";
        status = HttpStatus.UNPROCESSABLE_ENTITY;

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            fieldName = error.getField();
            errorMessage = Objects.requireNonNull(error.getDefaultMessage()).replaceAll("[={}]", "");
        }

        StandardError bodyResponseError = new StandardError(status.value(), nameError, "'" + fieldName + "' -> " + errorMessage, request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

}