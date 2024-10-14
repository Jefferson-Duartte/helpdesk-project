package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.Client;
import com.jefferson.helpdesk.domain.dtos.client.ClientRequestDTO;
import com.jefferson.helpdesk.domain.dtos.client.ClientResponseDTO;

public interface IClientService {

    ClientResponseDTO findById(Integer id);

    ClientResponseDTO save(ClientRequestDTO dto);

    void checkIfUserExists(ClientRequestDTO dto);

    ClientResponseDTO update(Integer id, ClientRequestDTO dto);

    Client findByIdEntity(Integer id);


}
