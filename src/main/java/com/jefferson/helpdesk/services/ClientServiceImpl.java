package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.Client;
import com.jefferson.helpdesk.domain.dtos.client.ClientRequestDTO;
import com.jefferson.helpdesk.domain.dtos.client.ClientResponseDTO;
import com.jefferson.helpdesk.exceptions.DataIntegrityViolationException;
import com.jefferson.helpdesk.exceptions.ObjectNotFoundException;
import com.jefferson.helpdesk.mappers.ClientMapper;
import com.jefferson.helpdesk.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    private ClientRepository repository;
    private ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientResponseDTO findById(Integer id) {
        var client = findByIdEntity(id);
        return mapper.toResponseDTO(client);
    }

    @Override
    public Client findByIdEntity(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
    }

    @Override
    public ClientResponseDTO save(ClientRequestDTO dto) {
        checkIfUserExists(dto);
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }

    public void checkIfUserExists(ClientRequestDTO dto) {
        Optional<Client> emailObj = repository.findByEmail(dto.getEmail());
        Optional<Client> documentObj = repository.findByDocument(dto.getDocument());

        if (emailObj.isPresent() && !emailObj.get().getDocument().equals(dto.getDocument()) || documentObj.isPresent() && !documentObj.get().getEmail().equals(dto.getEmail())) {
            throw new DataIntegrityViolationException("Dados inválidos");
        }
        if (emailObj.isPresent() && documentObj.isPresent() && emailObj.get().getEmail().equals(dto.getEmail()) && documentObj.get().getDocument().equals(dto.getDocument())) {
            throw new DataIntegrityViolationException("Usuário já existe");
        }
    }

    @Override
    public ClientResponseDTO update(Integer id, ClientRequestDTO dto) {
        var oldUser = findByIdEntity(id);

        oldUser.setName(dto.getName());
        oldUser.setEmail(dto.getEmail());
        oldUser.setDocument(dto.getDocument());
        oldUser.setPassword(dto.getPassword());
        oldUser.setProfiles(dto.getProfiles());

        Client updatedUser = repository.save(oldUser);
        return mapper.toResponseDTO(updatedUser);
    }

    @Override
    public void deleteById(Integer id) {
        findByIdEntity(id);
        repository.deleteById(id);
    }

}
