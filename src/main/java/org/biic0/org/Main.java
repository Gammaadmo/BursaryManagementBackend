package org.biic0.org; // Use your base package name here

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This annotation enables auto-configuration, component scanning, etc.
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // Starts the Spring Boot application
    }
}
