package com.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test the App class.
 */
public class AppTest {

    /**
     * Initializes the output stream captor to capture the output of System.out
     */
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Redirects System.out to our stream
     */
    @BeforeEach
    public void setUp() {
        // Redirect System.out to our stream
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Tests the main method with invalid input
     */
    @Test
    public void testMainInvalidInput() {
        App.main(new String[]{"test"});
        assertTrue(outputStreamCaptor.toString().trim().contains("Invalid input: Argument 1 was not a number"));
    }

    /**
     * Tests the main method with negative input
     */
    @Test
    public void testMainNegativeInput() {
        App.main(new String[]{"-1"});
        assertTrue(outputStreamCaptor.toString().trim().contains("Invalid input: Argument 1 was negative"));
    }

    /**
     * Tests the main method with positive input
     */
    @Test
    public void testMainPositiveInput() {
        App.main(new String[]{"10"});
        assertTrue(outputStreamCaptor.toString().trim().contains("The 10th term of the Fibonacci sequence is 55."));
    }

    /**
     * Tests the main method with manual input
     */
    @Test
    public void testMainManualInput() {
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));
        App.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().trim().contains("The 10th term of the Fibonacci sequence is 55."));
    }

    /**
     * Tests the parseArguments method with an invalid input
     */
    @Test
    public void testParseArgumentsInvalidInput() {
        String[] args = {"abc"};
        int i = 0;
        String result = App.parseArguments(args, i);
        assertEquals("Invalid input: Argument 1 was not a number", result);
    }

    /**
     * Tests the parseArguments method with a negative input
     */
    @Test
    public void testParseArgumentsNegativeInput() {
        String[] args = {"-1"};
        int i = 0;
        String result = App.parseArguments(args, i);
        assertEquals("Invalid input: Argument 1 was negative", result);
    }

    /**
     * Tests the parseArguments method with a positive input
     */
    @Test
    public void testParseArgumentsPositiveInput() {
        String[] args = {"10"};
        int i = 0;
        String result = App.parseArguments(args, i);
        assertEquals("The 10th term of the Fibonacci sequence is 55.", result);
    }

    /**
     * Tests the getUserInput method
     */
    @Test
    public void testGetUserInput() {
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));
        String[] result = App.getUserInput();
        assertEquals("10", result[0]);
    }
}
