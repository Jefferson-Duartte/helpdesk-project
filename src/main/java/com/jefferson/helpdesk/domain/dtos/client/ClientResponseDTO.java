package com.jefferson.helpdesk.domain.dtos.client;

import com.jefferson.helpdesk.domain.enums.PROFILE;

import java.time.LocalDate;
import java.util.Set;

public class ClientResponseDTO {
    private Integer id;
    private String name;
    private String document;
    private String email;
    private Set<PROFILE> profiles;
    private LocalDate createdAt;
}
