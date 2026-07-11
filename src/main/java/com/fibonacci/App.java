package com.fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the entry point of the program.
 * It initializes the Spring Boot application.
 */
@SpringBootApplication
public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    /**
     * The main method starts the Spring Boot application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logger.info("Starting the Fibonacci application");
        SpringApplication.run(App.class, args);
        logger.info("Fibonacci application started and ready to accept requests");
    }
}
