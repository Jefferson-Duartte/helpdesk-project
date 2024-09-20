package com.jefferson.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Technical extends Person {

    private List<Request> requests = new ArrayList<>();

    public Technical() {
    }

    public Technical(Integer id, String name, String document, String email, String password) {
        super(id, name, document, email, password);
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
