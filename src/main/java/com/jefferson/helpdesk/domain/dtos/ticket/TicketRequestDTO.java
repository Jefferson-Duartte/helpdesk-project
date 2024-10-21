package com.jefferson.helpdesk.domain.dtos.ticket;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "O campo PRIORITY é requerido")
    private Integer priority;

    @NotNull(message = "O campo TECHNICAL é requerido")
    private Integer technical;

    @NotNull(message = "O campo CLIENT é requerido")
    private Integer client;

    @NotNull(message = "O campo STATUS é requerido")
    private Integer status;

    @NotEmpty(message = "O campo TITLE é requerido")
    private String title;

    @NotEmpty(message = "O campo OBSERVATIONS é requerido")
    private String observations;

}
