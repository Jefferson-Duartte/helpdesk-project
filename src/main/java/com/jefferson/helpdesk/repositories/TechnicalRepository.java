package com.jefferson.helpdesk.repositories;

import com.jefferson.helpdesk.domain.Technical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalRepository extends JpaRepository<Technical, Integer> {
}
