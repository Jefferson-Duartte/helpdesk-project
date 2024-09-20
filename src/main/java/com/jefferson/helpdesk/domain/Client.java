package com.jefferson.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private List<Request> requests = new ArrayList<>();

    public Client() {
    }

    public Client(Integer id, String name, String document, String email, String password, List<Request> requests) {
        super(id, name, document, email, password);
        this.requests = requests;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
