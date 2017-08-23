package com.meganlee;

import org.junit.*;

public class SingleNumberTest {
    SingleNumber solution = new SingleNumber();
    private int calculate(int[] array) {
        return solution.singleNumber(array);
    }

    int[] arr1 = {3, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 0};
    int[] arr2 = {1, 1, 2, 2, 0, 0, 3435};

    @Test
    public void testBigNumbers() {
        Assert.assertEquals(calculate(arr1), 0);
    }

    @Test
    public void testNormalNumbers() {
        Assert.assertEquals(calculate(arr2), 3435);
    }
}