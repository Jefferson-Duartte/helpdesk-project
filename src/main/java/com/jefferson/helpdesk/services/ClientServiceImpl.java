package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.dtos.client.ClientResponseDTO;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.mappers.ClientMapper;
import com.jefferson.helpdesk.repositories.ClientRepository;

public class ClientServiceImpl implements IClientService{

    private ClientRepository repository;
    private ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientResponseDTO findById(Integer id) {
        var client = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
        return mapper.toResponseDTO(client);
    }
}
