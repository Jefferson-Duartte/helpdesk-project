package com.jefferson.helpdesk.controllers;

import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import com.jefferson.helpdesk.services.ticket.TicketServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
