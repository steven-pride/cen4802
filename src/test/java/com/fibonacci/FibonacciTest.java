package com.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the Fibonacci class.
 */
public class FibonacciTest {
    Fibonacci fibonacci;

    /**
     * Initialize the Fibonacci object before each test.
     */
    @BeforeEach
    public void setup() {
        fibonacci = new Fibonacci();
    }

    /**
     * Test the getFibbonacciValue method with a positive number.
     */
    @Test
    public void testGetFibbonacciValuePositive() {
        Long fibonacciValue = fibonacci.getFibbonacciValue(10);
        assertEquals(55, fibonacciValue);
    }

    /**
     * Test the getFibbonacciValue method with zero.
     */
    @Test
    public void testGetFibbonacciValueZero() {
        Long fibonacciValue = fibonacci.getFibbonacciValue(0);
        assertEquals(0, fibonacciValue);
    }

    /**
     * Test the toString method with the 1st term.
     */
    @Test
    public void testToStringSt() {
        String fibonacciString = fibonacci.toString(1, 0L);
        assertEquals("The 1st term of the Fibonacci sequence is 0.", fibonacciString);
    }

    /**
     * Test the toString method with the 2nd term.
     */
    @Test
    public void testToStringNd() {
        String fibonacciString = fibonacci.toString(2, 1L);
        assertEquals("The 2nd term of the Fibonacci sequence is 1.", fibonacciString);
    }

    /**
     * Test the toString method with the 3rd term.
     */
    @Test
    public void testToStringRd() {
        String fibonacciString = fibonacci.toString(3, 2L);
        assertEquals("The 3rd term of the Fibonacci sequence is 2.", fibonacciString);
    }

    /**
     * Test the toString method with the 10th term.
     */
    @Test
    public void testToStringTh() {
        String fibonacciString = fibonacci.toString(10, 55L);
        assertEquals("The 10th term of the Fibonacci sequence is 55.", fibonacciString);
    }
}
