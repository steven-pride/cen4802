package com.fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class FibonacciController {

    private static final Logger logger = LogManager.getLogger(FibonacciController.class);

    private final FibonacciSequence fibonacci;

    @Autowired
    public FibonacciController(FibonacciSequence fibonacci) {
        this.fibonacci = fibonacci;
    }

    @GetMapping("/fibonacci")
    public String getFibonacci(@RequestParam(value = "n", defaultValue = "0") int n) {
        logger.info("Received request for Fibonacci term {}", n);

        if (n < 0) {
            logger.warn("Rejected request: index {} is negative", n);
            return "Invalid input: n was negative";
        }

        try {
            long start = System.nanoTime();
            Long fibonacciValue = fibonacci.getFibbonacciValue(n);
            long durationMs = (System.nanoTime() - start) / 1_000_000;
            logger.info("Calculated Fibonacci term {} = {} in {} ms", n, fibonacciValue, durationMs);
            return fibonacci.toString(n, fibonacciValue);
        } catch (RuntimeException e) {
            logger.error("Failed to calculate Fibonacci term {}: {}", n, e.getMessage(), e);
            return "An error occurred while calculating the Fibonacci value";
        }
    }

    /**
     * Handles requests where the "n" parameter cannot be converted to an integer
     * (e.g. /fibonacci?n=abc), logging the failure as an ERROR instead of letting
     * Spring's DefaultHandlerExceptionResolver log it as a WARN.
     *
     * @param e the type mismatch exception raised by Spring
     * @return an error message describing the invalid input
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        logger.error("Rejected request: value '{}' for parameter '{}' is not a valid integer",
                e.getValue(), e.getName(), e);
        return "Invalid input: n must be an integer";
    }
}
