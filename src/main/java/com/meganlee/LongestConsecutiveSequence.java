package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class LongestConsecutiveSequence {

    //--------------  Solution 1 -------------------//
    // 
    public int longestConsecutive(int[] nums) {
        // input checking: 2 passes iterate
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        // put original array into a set: stream might be 5X slow than pure java
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length && !set.isEmpty(); i++) { // break early with set.isEmpty
            // go down
            int count = 0;
            for (int n = nums[i]; set.contains(n); n--) {
                set.remove(n);  // remove along the way, visit each element exactly once
                count++;
            }
            // go up
            for (int n = nums[i] + 1; set.contains(n); n++) { // start from nums[i] + 1
                set.remove(n);  // remove along the way, visit each element exactly once
                count++;
            }
            res = Math.max(count, res);
        }
        return res;
    }

    //--------------  Solution 2 -------------------//
    // O(N) one pass iterate
    public int longestConsecutive2(int[] nums) {
        // input valiation
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (!map.containsKey(n)) { // we've never seen the cur num n
                // get down/up counts
                int down = map.getOrDefault(n - 1, 0); // if n-1 exist, n-1 is the max boundary of a consecutive sequence
                int up   = map.getOrDefault(n + 1, 0); // if n+1 exist, n+1 is the min boundary of a consecutive 
                // update map
                int count = down + 1 + up;
                map.put(n, count);         // update current
                map.put(n - down, count);  // update min boundary
                map.put(n + up, count);    // update max boundary
                // update res
                res = Math.max(res, count);
            } // else duplicates, we just skip
        }
        return res;
    }

    //--------------  Solution 3 -------------------//
    // sort and count O(NlgN)
    public int longestConsecutive3(int[] nums) {
        // input valiation
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // sort the array first
        Arrays.sort(nums);
        // iterate and record max
        int res = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {    // 1. consecutive:       count++
                cur++;
            } else if (nums[i] != nums[i - 1]) { // 2. break & non-dupe:  reset count
                res = Math.max(res, cur);
                cur = 1;
            }                                    // 3. break & dupe: continue
        }
        return Math.max(res, cur); // there might be left over update stored in cur
    }

}
