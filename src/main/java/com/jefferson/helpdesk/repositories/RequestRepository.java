package com.jefferson.helpdesk.repositories;

import com.jefferson.helpdesk.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}
