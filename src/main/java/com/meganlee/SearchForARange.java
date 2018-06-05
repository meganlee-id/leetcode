package com.meganlee;

import java.util.*;

public class SearchForARange {
    //--------------------- Solution 1 -----------------------//
    // use ceiling function for target and target + 1
    public int[] searchRange(int[] nums, int target) {
        // input checking
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int lo = ceiling(nums, target);

        // target exist: condition alternative hi >= 0 && nums[hi] == target
        if (lo <= nums.length - 1 && nums[lo] == target) { 
            int hi = ceiling(nums, target + 1) - 1;
            return new int[] {lo, hi};
        // target not in nums
        } else {
            return new int[] {-1, -1};
        }
    }
    

    //--------------------- Solution 2 -----------------------//
    // use both ceiling/floor
     public int[] searchRange2(int[] nums, int target) {
        // input checking
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        // find if target exist, if exists, get the low bound index
        int lo = ceiling(nums, target);
        int hi = floor(nums, target);

        // target exist: condition alternative hi >= 0 && nums[hi] == target
        if (lo <= nums.length - 1 && nums[lo] == target) { 
            return new int[] {lo, hi};
        // target not in nums
        } else {
            return new int[] {-1, -1};
        }
    }
    

    //--------------------- Utils: ceiling and floor -----------------------//

    // return:  if exist: position of 1st target
    //          if not:   position of 1st elem > target
    // ceiling range: [0, N], inclusive on both sides
    private int ceiling(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target <= nums[mid]) { // pay attention
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;  // pay attention
    }


    // return:  if exist: position of last target
    //          if not:   position of last elem < target
    // floor range: [-1, N-1], inclusive on both sides
    private int floor(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target >= nums[mid]) { // pay attention
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi; // pay attention
    }
}