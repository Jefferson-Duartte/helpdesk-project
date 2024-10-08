package com.jefferson.helpdesk.exceptions.handlers;

import com.jefferson.helpdesk.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ExceptionResponse> buildResponseEntity(Exception exception, HttpStatus status, HttpServletRequest request) {

        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), status.value(), request.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ExceptionResponse> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
        return buildResponseEntity(exception, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> dataIntegrityViolation(DataIntegrityViolationException exception, HttpServletRequest request) {
        return buildResponseEntity(exception, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        ValidationExceptionResponse errors = new ValidationExceptionResponse(LocalDateTime.now(), "Validation Error", HttpStatus.BAD_REQUEST.value(), request.getRequestURI());

        for (FieldError x : exception.getBindingResult().getFieldErrors()) {
            errors.addErros(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
