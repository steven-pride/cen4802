package com.fibonacci;

import java.util.Scanner;

/**
 * This class is the entry point of the program.
 * It takes command line arguments and prints the Fibonacci sequence up to the specified values
 */
public class App {
    FibonacciSequence fibonacci = new Fibonacci();

    /**
     * The main method iterates over the arguments and prints the Fibonacci sequence up to the specified values for each argument
     * @param args the command line arguments, numbers, separated by spaces
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Fibonacci Sequence Generator!");

        if(args.length == 0) {
            args = getUserInput();
        }

        //Iterate over the arguments if there are multiple values
        for (int i = 0; i < args.length; i++) {
            String output = parseArguments(args, i);
            System.out.println(output);
        }
    }

    /**
     * Method to parse the arguments and return the Fibonacci sequence up to the specified value
     * @param args the command line arguments, numbers, separated by spaces
     * @param i the index of the argument to parse
     * @return string to be printed
     */
    static String parseArguments(String[] args, int i) {
        int nThValue = 0;
        String output = "";
        boolean exception = false;
        FibonacciSequence fibonacci = new Fibonacci();

        //Try to parse the argument as an integer
        try {
            nThValue = Integer.parseInt(args[i]);
        } catch (Exception e) {
            output = "Invalid input: Argument " + (i+1) + " was not a number";
            exception = true;
        }

        //Check if the argument is negative
        if(nThValue < 0 && exception == false) {
            output = "Invalid input: Argument " + (i+1) + " was negative";
        }
        else if (exception == false) {
            Long fibonacciValue = fibonacci.getFibbonacciValue(nThValue);
            output = fibonacci.toString(nThValue, fibonacciValue);
        }

        return output;
    }

    /**
     * Method to get user input
     * @return user input in String[] format
     */
    static String[] getUserInput() {
        String[] args;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number");
        String input = scanner.nextLine();
        args = new String[]{input};
        return args;
    }
}
