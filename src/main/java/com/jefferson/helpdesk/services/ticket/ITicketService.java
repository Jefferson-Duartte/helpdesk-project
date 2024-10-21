package com.jefferson.helpdesk.services.ticket;

import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;

public interface ITicketService {
    TicketResponseDTO findById(Integer id);

    Ticket findByIdEntity(Integer id);

}
