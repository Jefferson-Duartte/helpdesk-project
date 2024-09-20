package com.jefferson.helpdesk.domain;

import com.jefferson.helpdesk.domain.enums.PRIORITY;
import com.jefferson.helpdesk.domain.enums.STATUS;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Request {
    private Integer id;
    private LocalDate openingDate = LocalDate.now();
    private LocalDate closingDate;
    private PRIORITY priority;
    private STATUS status;
    private String title;
    private String observations;

    private Technical technical;
    private Client client;

    public Request(Integer id, Client client, Technical technical, String observations, String title, STATUS status, PRIORITY priority) {
        this.id = id;
        this.client = client;
        this.technical = technical;
        this.observations = observations;
        this.title = title;
        this.status = status;
        this.priority = priority;
    }

}
