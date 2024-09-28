package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalRequestDTO;
import com.jefferson.helpdesk.domain.dtos.technical.TechnicalResponseDTO;
import com.jefferson.helpdesk.exceptions.DataIntegrityViolationException;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.mappers.TechnicalMapper;
import com.jefferson.helpdesk.repositories.TechnicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalServiceImpl implements ITechnicalService {

    private TechnicalRepository repository;

    private TechnicalMapper mapper;

    public TechnicalServiceImpl(TechnicalRepository repository, TechnicalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TechnicalResponseDTO findById(Integer id) {
        Technical technical = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return mapper.toResponseDTO(technical);
    }

    @Override
    public List<TechnicalResponseDTO> findAll() {
        return mapper.toListResponseDTO(repository.findAll());
    }

    @Override
    public String save(TechnicalRequestDTO dto) {
        checkIfUserExists(dto);
        repository.save(mapper.toEntity(dto));
        return "Usuário criado com sucesso";
    }

    @Override
    public void checkIfUserExists(TechnicalRequestDTO dto) {
        Optional<Technical> emailObj = repository.findByEmail(dto.getEmail());
        Optional<Technical> documentObj = repository.findByDocument(dto.getDocument());

        if (emailObj.isPresent() && !emailObj.get().getDocument().equals(dto.getDocument()) ||
                documentObj.isPresent() && !documentObj.get().getEmail().equals(dto.getEmail())) {
            throw new DataIntegrityViolationException("Dados inválidos");
        }
        if (emailObj.isPresent() && documentObj.isPresent() &&
                emailObj.get().getEmail().equals(dto.getEmail()) &&
                documentObj.get().getDocument().equals(dto.getDocument())) {
            throw new DataIntegrityViolationException("Usuário já existe");
        }
    }
}