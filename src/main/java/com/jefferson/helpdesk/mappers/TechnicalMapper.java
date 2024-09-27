package com.jefferson.helpdesk.mappers;

import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalRequestDTO;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnicalMapper {

    Technical toEntity(TechnicalRequestDTO dto);

    TechnicalResponseDTO toResponseDTO(Technical obj);
}
