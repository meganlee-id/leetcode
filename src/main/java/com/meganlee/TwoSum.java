package com.meganlee;

import java.util.*;


public class TwoSum {
    //-------------- Solution 1  ------------------//
    // 2 pointers, naive
    public int[] twoSum(int[] nums, int target) {
        // invalid input
        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j}; // i goes before j
                }
            }
        }

        return null; // throw new IllegalArgumentException("No two sum solution");
    }

    //-------------- Solution 2  ------------------//
    // HashMap: 
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // Map<num, index>
        Map<Integer, Integer> table = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (table.containsKey(complement)) {
                return new int[] {table.get(complement), i}; // found an answer
            } else {
                table.put(nums[i], i);
            }
        }

        return null;
    }

    //-------------- Solution 3  ------------------//
    // Sort and solve:
    // T=O(nlgn) Space: decided on the sorting algorithm
    public int[] twoSum3(int[] nums, int target) {
        // input validation
        if (nums == null || nums.length < 2) {
            return null;
        }

        // user a HashMap to keep the original index before sorting
        Map<Integer, Integer> table = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }

        // use two pointers to find the right solution
        Arrays.sort(nums);
        for(int l = 0, r = nums.length - 1; l < r; ) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[] {table.get(nums[l]), table.get(nums[r])};
            } else if (sum < target) {
                l++;
            } else { // sum > target
                r--;
            }
        }

        return null;
    }
}
