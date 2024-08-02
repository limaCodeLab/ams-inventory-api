package com.skald.ats.inventory.api.controller.exceptions;

import java.time.Instant;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.skald.ats.inventory.api.service.exceptions.ValidationDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.skald.ats.inventory.api.service.exceptions.DatabaseException;
import com.skald.ats.inventory.api.service.exceptions.NoHandlerFoundException;
import com.skald.ats.inventory.api.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError bodyResponseError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database (DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError bodyResponseError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<StandardError> noResourceFound (NoHandlerFoundException e, HttpServletRequest request) {
        String error = "Endpoint not found";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError bodyResponseError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(ValidationDataException.class)
    public ResponseEntity<StandardError> violationRule (ValidationDataException e, HttpServletRequest request) {
        String error = "Validation data error";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError bodyResponseError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardError> jsonInvalid (NullPointerException e, HttpServletRequest request) {
        String error = "null pointer exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError bodyResponseError = new StandardError(Instant.now(), status.value(), error,"Null value: " +  e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(bodyResponseError);
    }

}