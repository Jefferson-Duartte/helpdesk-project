package com.jefferson.helpdesk.controllers;

import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;
import com.jefferson.helpdesk.services.TechnicalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/technicals")
public class TechnicalController {

    private TechnicalService service;

    public TechnicalController(TechnicalService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicalResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
