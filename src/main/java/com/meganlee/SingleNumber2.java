package com.meganlee;

import java.util.*;

public class SingleNumber2 {
    //------------------- Solution 1 -----------------------//
    // Brute-force: exact same code as SingleNumber1
    public int singleNumber(int[] nums) {
        // input validation
        if (nums == null || nums.length == 0) {
            return 0; // discuss what to return with bad input
        }
        Map<Integer, Integer> countMap = new HashMap();
        for (int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        for (int n: countMap.keySet()) {
            if (countMap.get(n) == 1) {
                return n;
            }
        }
        return 0; // discuss what to return with bad input
    }

    //------------------- Solution 2 -----------------------//
    // 3-based XOR, bit by bit
    public int singleNumber2(int[] nums) {
        // input validation: discuss this
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i < 32; i++) { // for each of the bits
            int bitSum = 0;
            for(int n: nums) {
                bitSum += (n >> i) & 1;
                bitSum %= 3;
            }
            res |= (bitSum << i); // += is also fine, bitSum must be 0 or 1
        }
        return res;
    }

    //------------------- Solution 2 -----------------------//
    // 3-based XOR
    public int singleNumber3(int[] nums) {
        int lo = 0, hi = 0;
        for(int i = 0; i < nums.length; i++){
            lo = (lo ^ nums[i]) & ~hi;
            hi = (hi ^ nums[i]) & ~lo; // hi use lo AFTER the update
        }
        return lo; // return lo, since finally there is a SINGLE num(recorded in lo)
    }
}
