package com.jefferson.helpdesk.domain.dtos.technical;

import com.jefferson.helpdesk.domain.enums.PROFILE;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalRequestDTO{

    @NotEmpty(message = "O campo NAME é requerido")
    private String name;

    @NotEmpty(message = "O campo DOCUMENT é requerido")
    private String document;

    @NotEmpty(message = "O campo EMAIL é requerido")
    private String email;

    @NotEmpty(message = "O campo PASSWORD é requerido")
    private String password;

    private Set<PROFILE> profiles;
}
