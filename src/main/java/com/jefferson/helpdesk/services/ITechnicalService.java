package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.dtos.technical.TechnicalRequestDTO;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;

import java.util.List;

public interface ITechnicalService {

    TechnicalResponseDTO findById(Integer id);

    List<TechnicalResponseDTO> findAll();

    TechnicalResponseDTO save(TechnicalRequestDTO dto);

    void checkIfUserExists(TechnicalRequestDTO dto);
}
