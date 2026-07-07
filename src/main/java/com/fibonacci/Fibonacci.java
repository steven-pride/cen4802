package com.fibonacci;

import org.springframework.stereotype.Component;

/**
 * This class implements the Fibonacci sequence interface, providing methods to calculate and display
 * the Fibonacci value.
 */
@Component
public class Fibonacci implements FibonacciSequence {
    /**
     * Calculates the Fibonacci value for the given index.
     *
     * @param n the index of the Fibonacci value to calculate
     * @return the Fibonacci value at the given index
     */
    @Override
    public Long getFibbonacciValue(Integer n) {
        // Base case: F(0) = 0 and F(1) = 1
        if (n <= 1) {
            return Long.valueOf(n);
        }

        // Recursive call to calculate the Fibonacci value
        // using the math formula: F(n) = F(n-1) + F(n-2)
        return getFibbonacciValue(n - 1) + getFibbonacciValue(n - 2);
    }

    /**
     * Converts the given Fibonacci value to a string representation.
     *
     * @param nThValue the index of the Fibonacci value
     * @param fibonacciValue the Fibonacci value to convert
     * @return a string representation of the Fibonacci value
     */
    public String toString(Integer nThValue, Long fibonacciValue) {
        String nThValueString;

        // Determine the appropriate suffix for the Fibonacci index value
        // (e.g., 1st, 2nd, 3rd)
        if (nThValue == 0)
            // Special case for 0
            nThValueString = "0";
        else if (nThValue == 1 || (nThValue > 20 && nThValue % 10 == 1))
            nThValueString = nThValue + "st";
        else if (nThValue == 2 || (nThValue > 20 && nThValue % 10 == 2))
            nThValueString = nThValue + "nd";
        else if (nThValue == 3 || (nThValue > 20 && nThValue % 10 == 3))
            nThValueString = nThValue + "rd";
        else
            nThValueString = nThValue + "th";

        return "The " + nThValueString + " term of the Fibonacci sequence is " + fibonacciValue + ".";
    }
}
