package com.meganlee;

import java.util.*;
import org.junit.*;

public class MaximumSubarray3Test {
    MaximumSubarray3 solution = new MaximumSubarray3();
    private int calculate(int[] nums, int k) {
        System.out.println("============== Input nums ==============");
        System.out.println(Arrays.toString(nums));
        System.out.println(String.format("k = %d", k));
        int res = solution.maxSubArray(nums, k);
        System.out.println(res);
        return res;
    }

    int[] nums = {-2,4,-1,3,-1,3};

    @Test
    public void test() {
        Assert.assertEquals(9, calculate(nums, 2));
        Assert.assertEquals(10, calculate(nums, 3));
        Assert.assertEquals(9, calculate(nums, 4));
    }
}