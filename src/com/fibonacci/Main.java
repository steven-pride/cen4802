package com.fibonacci;

/**
 * This class is the entry point of the program.
 * It takes command line arguments and prints the Fibonacci sequence up to the specified values
 */
public class Main {
    /**
     * The main method iterates over the arguments and prints the Fibonacci sequence up to the specified values for each argument
     * @param args the command line arguments, numbers, separated by spaces
     */
    public static void main(String[] args) {
        int nThValue;
        FibonacciSequence fibonacci = new Fibonacci();

        //Iterate over the arguments if there are multiple values
        for (int i = 0; i < args.length; i++) {
            //Try to parse the argument as an integer
            try {
                nThValue = Integer.parseInt(args[i]);
            } catch (Exception e) {
                System.out.println("Invalid input: Argument " + (i+1) + " was not a number");
                continue;
            }

            //Check if the argument is negative
            if(nThValue < 0) {
                System.out.println("Invalid input: Argument " + i+1 + " was negative");
                continue;
            }

            Long fibonacciValue = fibonacci.getFibbonacciValue(nThValue);
            System.out.println(fibonacci.toString(nThValue, fibonacciValue));
        }
    }
}
