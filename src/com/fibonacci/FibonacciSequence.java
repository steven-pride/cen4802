package com.fibonacci;

/**
 * This interface defines the contract for calculating and displaying a Fibonacci sequence.
 */
public interface FibonacciSequence {
    /**
     * Calculates the Fibonacci value for the given index.
     *
     * @param n the index of the Fibonacci value to calculate
     * @return the Fibonacci value at the given index
     */
    Long getFibbonacciValue(Integer n);

    /**
     * Converts the given Fibonacci value to a string representation.
     *
     * @param nThValue the index of the Fibonacci value
     * @param fibonacciValue the Fibonacci value to convert
     * @return a string representation of the Fibonacci value
     */
    String toString(Integer nThValue, Long fibonacciValue);
}
