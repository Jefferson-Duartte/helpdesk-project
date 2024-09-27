package com.jefferson.helpdesk.domain.dtos.technical;

import com.jefferson.helpdesk.domain.enums.PROFILE;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalRequestDTO{

    private String name;
    private String document;
    private String email;
    private String password;
    private Set<PROFILE> profiles;
}
