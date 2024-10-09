package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.dtos.client.ClientResponseDTO;

public interface IClientService {

    ClientResponseDTO findById(Integer id);
}
