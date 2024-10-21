package com.jefferson.helpdesk.services.ticket;

import com.jefferson.helpdesk.domain.Client;
import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.domain.Ticket;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketRequestDTO;
import com.jefferson.helpdesk.domain.dtos.ticket.TicketResponseDTO;
import com.jefferson.helpdesk.domain.enums.PRIORITY;
import com.jefferson.helpdesk.domain.enums.STATUS;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.mappers.TicketMapper;
import com.jefferson.helpdesk.repositories.TicketRepository;
import com.jefferson.helpdesk.services.client.ClientServiceImpl;
import com.jefferson.helpdesk.services.technical.TechnicalServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {

    private TicketRepository repository;

    private TechnicalServiceImpl technicalService;
    private ClientServiceImpl clientService;

    private TicketMapper mapper;

    public TicketServiceImpl(TicketRepository repository, TechnicalServiceImpl technicalService, ClientServiceImpl clientService, TicketMapper mapper) {
        this.repository = repository;
        this.technicalService = technicalService;
        this.clientService = clientService;
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

    @Override
    public List<TicketResponseDTO> findAll() {
        return mapper.toListResponseDTO(repository.findAll());
    }

    @Override
    public TicketResponseDTO save(TicketRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(newTicket(dto)));
    }

    public Ticket newTicket(TicketRequestDTO dto){
        Technical technical = technicalService.findByIdEntity(dto.getTechnical());
        Client client = clientService.findByIdEntity(dto.getClient());

        Ticket ticket = new Ticket();

        if (dto.getId() != null) {
            ticket.setId(dto.getId());
        }

        ticket.setTechnical(technical);
        ticket.setClient(client);
        ticket.setPriority(PRIORITY.toEnum(dto.getPriority()));
        ticket.setStatus(STATUS.toEnum(dto.getStatus()));
        ticket.setTitle(dto.getTitle());
        ticket.setObservations(dto.getObservations());

        return ticket;
    }

}
