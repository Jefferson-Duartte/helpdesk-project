package com.jefferson.helpdesk.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationExceptionResponse extends ExceptionResponse {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationExceptionResponse(LocalDateTime timestamp, String error, Integer status, String path) {
        super(timestamp, error, status, path);
    }

    public void addErros(String fieldName, String message) {
        erros.add(new FieldMessage(fieldName, message));
    }
}
