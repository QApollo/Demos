package com.qualogy.TddMockJunitdemo;

public class StringCalculator implements CalculateService{

    //Implement CalculateService Method.
    public int add(final String numbers) {
        int sum = 0;
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
            } else {
            for (String number : numbersArray) {
                sum = sum + Integer.parseInt(number);  // If it is not a number, parseInt will throw an exception
            }
            System.out.print("Sum of number =" + sum);
            return sum;
        }
    }
}