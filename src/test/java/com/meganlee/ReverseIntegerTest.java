package com.meganlee;

import org.junit.*;

public class ReverseIntegerTest {
    ReverseInteger solution = new ReverseInteger();
    private int calculate(int x) {
        int reverseX = solution.reverse(x);
        System.out.println("\n------------");
        System.out.println("Original Number: " + x);
        System.out.println("Reversed Number: " + reverseX);
        return reverseX;
    }
    int[] numbers  = {-1200, 2344, 0, 2345, 1220010, Integer.MAX_VALUE, Integer.MIN_VALUE};
    int[] expected = {-21,   4432, 0, 5432, 100221,  0,                0};

    @Test
    public void test() {
        for (int i = 0; i < numbers.length; i++) {
            Assert.assertEquals(calculate(numbers[i]), expected[i]);
        } 
    }
}