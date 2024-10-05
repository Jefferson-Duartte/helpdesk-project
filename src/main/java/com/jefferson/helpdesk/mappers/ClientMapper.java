package com.jefferson.helpdesk.mappers;

import com.jefferson.helpdesk.domain.Client;
import com.jefferson.helpdesk.domain.dtos.client.ClientRequestDTO;
import com.jefferson.helpdesk.domain.dtos.client.ClientResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientRequestDTO dto);

    ClientResponseDTO toResponseDTO(Client obj);

    List<ClientResponseDTO> toListResponseDTO(List<Client> objList);

}
