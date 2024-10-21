package com.jefferson.helpdesk.mappers;

import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketRequestDTO;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toEntity(TicketRequestDTO dto);

    TicketResponseDTO toResponseDTO(Ticket obj);

    List<TicketResponseDTO> toListResponseDTO(List<Ticket> objList);

}
