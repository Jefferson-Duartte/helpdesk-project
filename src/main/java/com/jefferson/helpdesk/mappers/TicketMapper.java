package com.jefferson.helpdesk.mappers;

import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketRequestDTO;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "technical.id", source = "technical")
    @Mapping(target = "client.id", source = "client")
    Ticket toEntity(TicketRequestDTO dto);

    @Mapping(target = "technical", source = "technical.id")
    @Mapping(target = "technicalName", source = "technical.name")
    @Mapping(target = "client", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    TicketResponseDTO toResponseDTO(Ticket obj);

    List<TicketResponseDTO> toListResponseDTO(List<Ticket> objList);

}
