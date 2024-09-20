package com.jefferson.helpdesk.domain;

import com.jefferson.helpdesk.domain.enums.PROFILE;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "document"})
public abstract class Person {

    protected Integer id;
    protected String name;
    protected String document;
    protected String email;
    protected String password;
    protected Set<PROFILE> profiles = EnumSet.noneOf(PROFILE.class);
    protected LocalDate createdAt = LocalDate.now();

    public Person() {
        addProfiles(PROFILE.CLIENT);
    }

    public Person(Integer id, String name, String document, String email, String password) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
    }

    public void addProfiles(PROFILE profile) {
        if (profile != null) {
            this.profiles.add(profile);
        }
    }
}
