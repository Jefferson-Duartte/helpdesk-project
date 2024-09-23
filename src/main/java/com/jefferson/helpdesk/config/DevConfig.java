package com.jefferson.helpdesk.config;

import com.jefferson.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private final DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean intanceDBDev() {
        if (value.equals("create")) {
            this.dbService.intanceDB();
        }
        return false;
    }
}
