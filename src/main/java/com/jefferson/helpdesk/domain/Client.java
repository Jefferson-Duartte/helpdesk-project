package com.jefferson.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jefferson.helpdesk.domain.enums.PROFILE;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "tb_client")
public class Client extends Person {

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Request> requests = new ArrayList<>();

    public Client() {
        addProfiles(PROFILE.CLIENT);
    }

    public Client(Integer id, String name, String document, String email, String password) {
        super(id, name, document, email, password);
        addProfiles(PROFILE.CLIENT);
    }
}
