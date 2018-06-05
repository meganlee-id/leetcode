package com.meganlee;

import java.util.*;
import org.junit.*;

public class FirstMissingPositiveTest {
    FirstMissingPositive solution = new FirstMissingPositive();
    private int calculate(int[] arr) {
        int res = solution.firstMissingPositive(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
        return res;
    }

    int[] arr1 = {3, 4, -1, 1};
    int[] arr2 = {4, 3, 5, -1, 0, 3, 7, 2, 8, -2, 1};


    @Test
    public void test() {
        Assert.assertEquals(2, calculate(arr1));
        Assert.assertEquals(6, calculate(arr2));
    }
}