package com.meganlee;

import org.junit.*;

public class SingleNumber2Test {
    SingleNumber2 solution = new SingleNumber2();
    private int calculate(int[] array) {
        return solution.singleNumber(array);
    }

    int[] arr1 = {3, 3, 3, Integer.MAX_VALUE};
    int[] arr2 = {1, 1, 1, 0, 0, 0, 3435};

    @Test
    public void testArray1() {
        Assert.assertEquals(calculate(arr1), Integer.MAX_VALUE);
    }

    @Test
    public void testArray2() {
        Assert.assertEquals(calculate(arr2), 3435);
    }
}