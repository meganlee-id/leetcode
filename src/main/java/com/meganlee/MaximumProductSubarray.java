package com.meganlee;

import java.util.*;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // input validation
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        // global and local solution
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int lastMax = max, lastMin = min; // has keep a copy otherwise, max will be changed at next line!
            max = Collections.max(Arrays.asList(nums[i], nums[i] * lastMin,  nums[i] * lastMax)); // local max
            min = Collections.min(Arrays.asList(nums[i], nums[i] * lastMin,  nums[i] * lastMax)); // local min
            res = Math.max(res, max); // global max
        }
        return res;
    }
}
