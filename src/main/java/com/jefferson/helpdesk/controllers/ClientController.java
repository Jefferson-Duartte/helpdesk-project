package com.jefferson.helpdesk.controllers;

import com.jefferson.helpdesk.domain.dtos.client.ClientResponseDTO;
import com.jefferson.helpdesk.services.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientServiceImpl service;

    public ClientController(ClientServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
