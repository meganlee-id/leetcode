package com.meganlee;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3) {
            return res;
        }

        Arrays.sort(num); // remember to sort this first
        for (int i = 0; i < num.length; i++) {
            // decide on the first num, skip dupes
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            // use 2 pointers with sorted array method 
            for(int start = i + 1, end = num.length - 1; start < end; ) {
                int sum = num[i] + (num[start] + num[end]) ;
                if (sum == 0) {
                    List<Integer> triple = Arrays.asList(num[i], num[start], num[end]);
                    res.add(triple);
                    // skip all the duplicates, start will point to a diff num than num[start], end points to a diff num than nums[end]
                    start++;
                    end--;
                    while (start < end && num[start] == num[start - 1]) {
                        start++;
                    }
                    while (start < end && num[end] == num[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else { // sum > 0
                    end--;
                }
            }
        }
        return res;
    }
}


