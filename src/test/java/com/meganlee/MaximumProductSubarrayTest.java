package com.meganlee;

import java.util.*;
import org.junit.*;

public class MaximumProductSubarrayTest {
    MaximumProductSubarray solution = new MaximumProductSubarray();
    public int calculate(int[] nums) {
        Arrays.toString(nums);
        int maxProd = solution.maxProduct(nums);
        System.out.println("Max Prod: " + maxProd + "\n");
        return maxProd;
    }
    int[] nums  = {3, 1, -2, 5, 4};

    @Test
    public void test() {
       Assert.assertEquals(20, calculate(nums));
    }
}