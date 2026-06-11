package com.fibonacci;

public class Main {
    public static void main(String[] args) {
        int nThValue;
        FibonacciSequence fibonacci = new Fibonacci();

        for (int i = 0; i < args.length; i++) {
            try {
                nThValue = Integer.parseInt(args[i]);
            } catch (Exception e) {
                System.out.println("Invalid input: Argument " + (i+1) + " was not a number");
                continue;
            }

            if(nThValue < 0) {
                System.out.println("Invalid input: Argument " + i+1 + " was negative");
                continue;
            }

            Long fibonacciValue = fibonacci.getFibbonacciValue(nThValue);
            System.out.println(fibonacci.toString(nThValue, fibonacciValue));
        }
    }
}
