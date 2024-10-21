package com.jefferson.helpdesk.mappers;

import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketRequestDTO;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "technical", source = "technical", ignore = true)
    @Mapping(target = "client", source = "client", ignore = true)
    Ticket toEntity(TicketRequestDTO dto);

    @Mapping(target = "technical", source = "technical", ignore = true)
    @Mapping(target = "client", source = "client", ignore = true)
    TicketResponseDTO toResponseDTO(Ticket obj);

    List<TicketResponseDTO> toListResponseDTO(List<Ticket> objList);

}
