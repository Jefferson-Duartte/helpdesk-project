package com.jefferson.helpdesk.services.technical;

import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalRequestDTO;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;

import java.util.List;

public interface ITechnicalService {

    TechnicalResponseDTO findById(Integer id);

    Technical findByIdEntity(Integer id);

    List<TechnicalResponseDTO> findAll();

    TechnicalResponseDTO save(TechnicalRequestDTO dto);

    void checkIfUserExists(TechnicalRequestDTO dto);

    void deleteById(Integer id);

    TechnicalResponseDTO update(Integer id, TechnicalRequestDTO dto);
}
