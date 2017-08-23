package com.meganlee;

import java.util.*;

public class SingleNumber2 {
    //------------------- Solution 1 -----------------------//
    // Brute-force: exact same code as SingleNumber1
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
    // 3-based XOR
    public int singleNumber2(int[] nums) {
        // input validation: discuss this
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        // for each of the bits
        for(int i = 0; i < 32; i++) {
            int bitSum = 0;
            for(int n : nums) {
                bitSum += (n >> i) & 1;
                bitSum %= 3;
            }
            res |= (bitSum << i); // += is also fine, bitSum must be 0 or 1
        }
        return res;
    }
}
