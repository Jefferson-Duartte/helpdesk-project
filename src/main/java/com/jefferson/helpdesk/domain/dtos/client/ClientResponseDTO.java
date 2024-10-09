package com.jefferson.helpdesk.domain.dtos.client;

import com.jefferson.helpdesk.domain.enums.PROFILE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {
    private Integer id;
    private String name;
    private String document;
    private String email;
    private Set<PROFILE> profiles;
    private LocalDate createdAt;
}
