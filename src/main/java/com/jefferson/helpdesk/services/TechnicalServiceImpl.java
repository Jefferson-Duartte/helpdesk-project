package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.mappers.TechnicalMapper;
import com.jefferson.helpdesk.repositories.TechnicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalServiceImpl implements ITechnicalService{

    private TechnicalRepository repository;

    private TechnicalMapper mapper;

    public TechnicalServiceImpl(TechnicalRepository repository, TechnicalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TechnicalResponseDTO findById(Integer id){
        Technical technical = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return mapper.toResponseDTO(technical);
    }

    @Override
    public List<TechnicalResponseDTO> findAll() {
        return mapper.toListResponseDTO(repository.findAll());
    }
}
