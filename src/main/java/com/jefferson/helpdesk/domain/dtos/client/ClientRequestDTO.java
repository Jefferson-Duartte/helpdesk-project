package com.jefferson.helpdesk.domain.dtos.client;

import com.jefferson.helpdesk.domain.enums.PROFILE;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    @CPF
    private String document;

    @NotEmpty
    private String password;

    private Set<PROFILE> profiles;

}
