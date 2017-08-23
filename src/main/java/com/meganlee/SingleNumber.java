package com.meganlee;

import java.util.*;

public class SingleNumber {
    //------------------- Solution 1 -----------------------//
    // Brute-force
    public int singleNumber(int[] nums) {
        // input validation: discuss this
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap();
        for (int n : nums) {
            int currentCount = countMap.containsKey(n) ? countMap.get(n) : 0;
            countMap.put(n, currentCount + 1);
        }
        for (int n : countMap.keySet()) {
            if (countMap.get(n) == 1) {
                return n;
            }
        }
        return 0;
    }

    //------------------- Solution 2 -----------------------//
    // 2-based XOR
    public int singleNumber2(int[] nums) {
        // input validation: discuss this
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
