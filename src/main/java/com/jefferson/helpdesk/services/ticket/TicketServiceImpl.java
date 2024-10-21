package com.jefferson.helpdesk.services.ticket;

import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.mappers.TicketMapper;
import com.jefferson.helpdesk.repositories.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ITicketService {

    private TicketRepository repository;

    private TicketMapper mapper;

    public TicketServiceImpl(TicketRepository repository, TicketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TicketResponseDTO findById(Integer id) {
        return mapper.toResponseDTO(this.findByIdEntity(id));
    }

    @Override
    public Ticket findByIdEntity(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado"));
    }


}
