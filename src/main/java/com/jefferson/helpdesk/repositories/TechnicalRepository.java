package com.jefferson.helpdesk.repositories;

import com.jefferson.helpdesk.domain.Technical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicalRepository extends JpaRepository<Technical, Integer> {

    Optional<Technical> findByEmail(String email);
    Optional<Technical> findByDocument(String document);
    void deleteById(Integer id);
}
