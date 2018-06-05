package com.meganlee;

import java.util.*;
import org.junit.*;

public class MaximumSubArrayTest {
    MaximumSubArray solution = new MaximumSubArray();
    private int calculate(int[] nums) {
        int res = solution.maxSubArray3(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res + "\n");
        return res;
    }

    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    @Test
    public void test() {
        Assert.assertEquals(6, calculate(nums));
    }
}