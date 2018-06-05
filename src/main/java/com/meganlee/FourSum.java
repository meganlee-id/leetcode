package com.meganlee;

import java.util.*;

public class FourSum {
    //-------- Sort and solve, exactly the same code as 3sum --------------//
    public List<List<Integer>> fourSum(int[] num, int target) {
        // input validation
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length < 4) {
            return res;
        }

        // remember to sort before 
        Arrays.sort(num);

        // fix the 1st number as the samllest number is each result bag
        for (int i = 0; i < num.length; i++) {
            // skip all duplicate for the 1st num
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }

            // fix the 2nd number as the second samllest number is each result bag
            for (int j = i + 1; j < num.length; j++) {
                // skip all duplicates for the 2nd num
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                // lo -> 3rd num; hi -> 4th num
                int lo = j + 1, hi = num.length - 1; 
                while (lo < hi) {
                    int sum = num[i] + num[j] + num[lo] + num[hi];
                    if (sum == target) {
                        List<Integer> quad = Arrays.asList(num[i], num[j], num[lo], num[hi]);
                        res.add(quad);
                        lo++; hi--;
                        while (lo < hi && num[lo] == num[lo - 1]) lo++; // skip dupes from lo side
                        while (lo < hi && num[hi] == num[hi + 1]) hi--; // skip dupes from hi side
                    } else if (sum < target) {
                        lo++;
                    } else { //sum > target
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}

