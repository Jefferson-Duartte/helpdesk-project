package com.jefferson.helpdesk.controllers;

import com.jefferson.helpdesk.domain.dtos.technical.TechnicalRequestDTO;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;
import com.jefferson.helpdesk.services.ITechnicalService;
import com.jefferson.helpdesk.services.TechnicalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/technicals")
public class TechnicalController {

    private ITechnicalService service;

    public TechnicalController(TechnicalServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicalResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TechnicalResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody TechnicalRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

}
