package com.meganlee;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        // input validation
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length < 3) {
            return res;
        }

        // remember to sort this first
        Arrays.sort(num); 
        
        // fix the 1st number as the samllest number is each result bag
        for (int i = 0; i < num.length; i++) {
            // skip all duplicate for the 1st num
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            // lo -> 2nd, hi -> 3rd
            int lo = i + 1, hi = num.length - 1;
            while (lo < hi) {
                int sum = num[i] + num[lo] + num[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi])); // add result
                    lo++; hi--; // update both pointers, we only want dedupped result
                    while (lo < hi && num[lo] == num[lo - 1]) lo++; // skip duplicates from lo side
                    while (lo < hi && num[hi] == num[hi + 1]) hi--; // skip duplicates from hi side
                } else if (sum < 0) {
                    lo++;
                } else { //sum > 0
                    hi--;
                }
            }
            
        }
        return res;
    }
}


