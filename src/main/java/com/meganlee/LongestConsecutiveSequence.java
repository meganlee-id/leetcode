package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class LongestConsecutiveSequence {
    //--------------  Solution 1 -------------------//
    // O(N): Use Set properly
    public int longestConsecutive(int[] nums) {
        // input valiation
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            // if num-1 exist, skip current val, only enter if condition if num is lowest in a steak
            if (!numSet.contains(num - 1)) {  
                // intialize variables
                int currentNum = num;
                // find all numbers > me
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                }
                longestStreak = Math.max(longestStreak, currentNum - num + 1);
            }
        }
        return longestStreak;
    }

    //--------------  Solution 2 -------------------//
    // sort and count O(NlgN)
    public int longestConsecutive2(int[] nums) {
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
                res = Math.max(res, cur);
            } else if (nums[i] != nums[i - 1]) { // 2. break & non-dupe:  reset count
                cur = 1;
            }                                    // 3. break & dupe: continue
        }
        return res; // there might be left over update stored in cur
    }

    //--------------  Solution 3 -------------------//
    // O(N) one pass iterate, use Map/record boundary
    public int longestConsecutive3(int[] nums) {
        // input valiation
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            // notice: any number already in a cons seq will be in map already
            if (!map.containsKey(n)) { // we've never visited the cur num n
                // get down/up counts
                int down = map.getOrDefault(n - 1, 0); // if n-1 exist, n-1 is the max boundary of a cons seq
                int up   = map.getOrDefault(n + 1, 0); // if n+1 exist, n+1 is the min boundary of a cons seq 
                // update res
                int count = down + 1 + up;
                res = Math.max(res, count);
                // update boundary map
                map.put(n, count);         // update current, mean we've visited
                map.put(n - down, count);  // update min boundary
                map.put(n + up, count);    // update max boundary
            } // else duplicates, we just skip
        }
        return res;
    }

    //------------------ Solution 5 ---------------//
    // Use union-find
    // https://leetcode.com/problems/longest-consecutive-sequence/discuss/41062/My-Java-Solution-using-UnionFound
}
