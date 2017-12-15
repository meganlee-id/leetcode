package com.meganlee;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // input validation
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }

        // remember to sort this first
        Arrays.sort(num);

        // closet initialization update along the way
        // DO NOT use Integer.MAX_VALUE might have overflow (closet-target)
        int closest = num[0] + num[1] + num[2]; 

        // fix the 1st number as the samllest number is each result bag
        for (int i = 0; i < num.length - 1; i++) {
            // lo -> 2nd, hi -> 3rd
            int lo = i + 1, hi = num.length - 1;
            while (lo < hi) {
                int sum = num[i] + num[lo] + num[hi];
                // adjust pointers
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
                // update solution, use Math.abs
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
