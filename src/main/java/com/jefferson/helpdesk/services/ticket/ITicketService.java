package com.jefferson.helpdesk.services.ticket;

import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketRequestDTO;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;

import java.util.List;

public interface ITicketService {
    TicketResponseDTO findById(Integer id);

    Ticket findByIdEntity(Integer id);

    List<TicketResponseDTO> findAll();

    TicketResponseDTO save(TicketRequestDTO dto);


}
