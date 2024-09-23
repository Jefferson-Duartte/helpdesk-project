package com.jefferson.helpdesk.config;

import com.jefferson.helpdesk.services.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    private final DBService dbService;

    public TestConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean intanceDBTest(){
        this.dbService.intanceDB();
        return true;
    }
}
