package com.example.employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Posy {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13.3")
        .withDatabaseName("testdb")
        .withUsername("testuser")
        .withPassword("testpass");

    @BeforeAll
    public static void setUp() {
        postgres.start();
        System.setProperty("DB_URL", postgres.getJdbcUrl());
        System.setProperty("DB_USERNAME", postgres.getUsername());
        System.setProperty("DB_PASSWORD", postgres.getPassword());
    }

    @Test
    void contextLoads() {
        // Your test logic here
    }
}

