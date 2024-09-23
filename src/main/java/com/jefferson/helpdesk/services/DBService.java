package com.jefferson.helpdesk.services;

import com.jefferson.helpdesk.domain.Client;
import com.jefferson.helpdesk.domain.Request;
import com.jefferson.helpdesk.domain.Technical;
import com.jefferson.helpdesk.domain.enums.PRIORITY;
import com.jefferson.helpdesk.domain.enums.PROFILE;
import com.jefferson.helpdesk.domain.enums.STATUS;
import com.jefferson.helpdesk.repositories.ClientRepository;
import com.jefferson.helpdesk.repositories.RequestRepository;
import com.jefferson.helpdesk.repositories.TechnicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private TechnicalRepository technicalRepository;
    private ClientRepository clientRepository;
    private RequestRepository requestRepository;

    public DBService(TechnicalRepository technicalRepository, ClientRepository clientRepository, RequestRepository requestRepository) {
        this.technicalRepository = technicalRepository;
        this.clientRepository = clientRepository;
        this.requestRepository = requestRepository;
    }

    public void intanceDB() {

        Technical technical = new Technical(null, "Jefferson", "4324324232", "jeff@mail.com", "123");
        technical.addProfiles(PROFILE.ADMIN);
        Client client = new Client(null, "Jeff", "87878765", "jefferson@mail.com", "123");
        Request request = new Request(null, client, technical, "Primeiro chamado", "Chamado 01", STATUS.PROGRESS, PRIORITY.NORMAL);

        technicalRepository.saveAll(List.of(technical));
        clientRepository.saveAll(List.of(client));
        requestRepository.saveAll(List.of(request));

    }
}
