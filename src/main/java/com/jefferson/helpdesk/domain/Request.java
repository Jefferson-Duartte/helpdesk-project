package com.jefferson.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jefferson.helpdesk.domain.enums.PRIORITY;
import com.jefferson.helpdesk.domain.enums.STATUS;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "tb_request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;

    private PRIORITY priority;

    private STATUS status;

    private String title;

    private String observations;

    @ManyToOne
    @JoinColumn(name = "technical_id")
    private Technical technical;

    @ManyToOne
    @JoinColumn(name = "client_id")
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
