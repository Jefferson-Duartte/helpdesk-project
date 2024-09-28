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

        Technical technical = new Technical(null, "Jeffersoen", "43243243232", "jef@mail.com", "12213143");
        Technical technical1 = new Technical(null, "Jeffers21on", "432432421232", "je2ff@mail.com", "12123");
        Technical technical2 = new Technical(null, "Jeffereson", "4324324132", "je23ff@mail.com", "1232");
        technical.addProfiles(PROFILE.ADMIN);
        Client client = new Client(null, "Jeff", "87878765", "jefferson@mail.com", "123");
        Request request = new Request(null, client, technical, "Primeiro chamado", "Chamado 01", STATUS.PROGRESS, PRIORITY.NORMAL);

        technicalRepository.saveAll(List.of(technical,technical1, technical2));
        clientRepository.saveAll(List.of(client));
        requestRepository.saveAll(List.of(request));

    }
}
