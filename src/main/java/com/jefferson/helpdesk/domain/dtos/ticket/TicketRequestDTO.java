package com.jefferson.helpdesk.domain.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDTO {
    private Integer id;
    private Integer priority;
    private Integer technical;
    private Integer client;
    private Integer status;
    private String title;
    private String observations;
    private String clientName;
    private String technicalName;
}
