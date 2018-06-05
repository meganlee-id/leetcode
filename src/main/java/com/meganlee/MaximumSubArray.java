package com.meganlee;

import java.util.*;

public class MaximumSubArray {
    //----------------- Solution 1 ---------------------//
    // convert to BestTimeBuyAndSellStock.java + can't trade on same day
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        // add up
        int[] sums = Arrays.copyOf(nums, nums.length); // Arrays.copyOf(source, lenOfTarget)
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        // BestTimeBuyAndSellStock.java solution 2
        int min = 0;       // sums[end]-0 = sum_range[0, end];  sums[end]-sums[start] = sum_range[start+1, end]
        int res = sums[0]; // best is the first elem
        for (int s: sums) {
            res = Math.max(res, s - min); // can't trade on the same day, update res first
            min = Math.min(min, s);
        }
        return res;
    }

    //----------------- Solution 2 ---------------------//
    // dp[] Space=O(N)
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i]; // local
            res = Math.max(res, dp[i]);               // global
        }
        return res;
    }

    //----------------- Solution 3 ---------------------//
    // dp: Space=O(1)
    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int sum = nums[0];
        int res = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];   // local
            res = Math.max(res, sum);           // global
        }
        return res;
    }
}
