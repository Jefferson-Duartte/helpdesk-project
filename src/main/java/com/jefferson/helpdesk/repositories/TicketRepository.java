package com.jefferson.helpdesk.repositories;

import com.jefferson.helpdesk.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
