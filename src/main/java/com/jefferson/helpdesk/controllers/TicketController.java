package com.jefferson.helpdesk.controllers;

import com.jefferson.helpdesk.domain.dtos.ticket.TicketRequestDTO;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import com.jefferson.helpdesk.services.ticket.TicketServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketServiceImpl service;

    public TicketController(TicketServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TicketResponseDTO> save(@RequestBody @Valid TicketRequestDTO dto){
        var ticket = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(uri).body(ticket);
    }


}
