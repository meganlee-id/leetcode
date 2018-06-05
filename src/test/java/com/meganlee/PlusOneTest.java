package com.meganlee;

import java.util.*;
import org.junit.*;

public class PlusOneTest {
    PlusOne solution = new PlusOne();
    private String calculate(int[] array) {
        int[] arrCopy =  array.clone(); // save original array. otherwise will be changed
        String sumStr = Arrays.toString(solution.plusOne(array));
        System.out.println("1 + " + Arrays.toString(arrCopy) + " = " + sumStr);
        return sumStr;
    }

    int[] digits1 = {9,9,9,9};
    int[] digits2 = {1,3,9,9,9};
    int[] digits3 = {0};

    @Test
    public void test() {
        Assert.assertEquals("[1, 0, 0, 0, 0]", calculate(digits1));
        Assert.assertEquals("[1, 4, 0, 0, 0]", calculate(digits2));
        Assert.assertEquals("[1]", calculate(digits3));
    }
}