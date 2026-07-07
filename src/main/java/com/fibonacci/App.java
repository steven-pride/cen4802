package com.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the entry point of the program.
 * It initializes the Spring Boot application.
 */
@SpringBootApplication
public class App {

    /**
     * The main method starts the Spring Boot application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
