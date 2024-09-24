package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.repositories.TechnicalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicalService {

    private TechnicalRepository repository;

    public TechnicalService(TechnicalRepository repository) {
        this.repository = repository;
    }

    public Technical findById(Integer id){
        Optional<Technical> technical = repository.findById(id);

        return technical.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
