package com.example.book_market_service.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class Liquibase implements CommandLineRunner {

    private  final  Liquibase liquibase;

    @Override
    public void run(String... args) throws Exception {

    }
}
