package com.meganlee;

import java.util.*;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // input validation
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        // global and local solution
        int global = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxCopy = max; // has keep a copy otherwise, max will be changed at next line!
            max = Collections.max(Arrays.asList(nums[i], nums[i] * min,  nums[i] * maxCopy)); 
            min = Collections.min(Arrays.asList(nums[i], nums[i] * min,  nums[i] * maxCopy)); 
            global = Math.max(global, max);
        }
        return global;
    }
}
