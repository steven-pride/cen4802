package com.fibonacci;

public class Fibonacci implements FibonacciSequence {
    @Override
    public Long getFibbonacciValue(Integer n) {
        if (n <= 1) {
            return Long.valueOf(n);
        }

        return getFibbonacciValue(n - 1) + getFibbonacciValue(n - 2);
    }

    public String toString(Integer nThValue, Long fibonacciValue) {
        String nThValueString;

        if (nThValue == 0)
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
