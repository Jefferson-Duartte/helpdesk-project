package com.jefferson.helpdesk.repositories;

import com.jefferson.helpdesk.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
