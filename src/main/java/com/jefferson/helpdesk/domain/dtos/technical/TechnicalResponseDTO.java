package com.jefferson.helpdesk.domain.dtos.technical;

import com.jefferson.helpdesk.domain.enums.PROFILE;
import lombok.*;

import java.time.LocalDate;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalResponseDTO{
        private Integer id;
        private String name;
        private String document;
        private String email;
        private Set<PROFILE> profiles;
        private LocalDate createdAt;
}
