package com.jefferson.helpdesk.controllers;

import com.jefferson.helpdesk.domain.dtos.technical.TechnicalRequestDTO;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;
import com.jefferson.helpdesk.services.ITechnicalService;
import com.jefferson.helpdesk.services.TechnicalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<TechnicalResponseDTO> save(@Valid @RequestBody TechnicalRequestDTO dto) {
        var technical = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(technical.getId()).toUri();
        return ResponseEntity.created(uri).body(technical);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TechnicalResponseDTO> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicalResponseDTO> update(@PathVariable Integer id, @RequestBody @Valid TechnicalRequestDTO dto){
        return ResponseEntity.ok().body(service.update(id, dto));
    }
}
