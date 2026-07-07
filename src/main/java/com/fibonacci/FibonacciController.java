package com.fibonacci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private final FibonacciSequence fibonacci;

    @Autowired
    public FibonacciController(FibonacciSequence fibonacci) {
        this.fibonacci = fibonacci;
    }

    @GetMapping("/fibonacci")
    public String getFibonacci(@RequestParam(value = "n", defaultValue = "0") int n) {
        if (n < 0) {
            return "Invalid input: n was negative";
        }
        Long fibonacciValue = fibonacci.getFibbonacciValue(n);
        return fibonacci.toString(n, fibonacciValue);
    }
}
