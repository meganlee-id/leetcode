package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // input checking
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        // put original array into a set: stream might be 5X slow than pure java
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // check nums one-by-one
        for (int i = 0; i < nums.length && !set.isEmpty(); i++) {
            // go down
            int count = 0;
            for (int n = nums[i]; set.contains(n); n--) {
                set.remove(n);
                count++;
            }
            // go up
            for (int n = nums[i] + 1; set.contains(n); n++) {
                set.remove(n);
                count++;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}
