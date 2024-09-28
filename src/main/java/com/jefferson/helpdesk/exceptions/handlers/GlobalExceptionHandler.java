package com.jefferson.helpdesk.exceptions.handlers;

import com.jefferson.helpdesk.exceptions.DataIntegrityViolationException;
import com.jefferson.helpdesk.exceptions.ExceptionResponse;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ExceptionResponse> buildResponseEntity(Exception exception, HttpStatus status, HttpServletRequest request){

        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), status.value(), request.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ExceptionResponse> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request){
        return buildResponseEntity(exception, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> dataIntegrityViolation(DataIntegrityViolationException exception, HttpServletRequest request){
        return buildResponseEntity(exception, HttpStatus.BAD_REQUEST, request);
    }

}
