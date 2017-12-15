package com.meganlee;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        // binary search
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        // lo first num > target
        // hi first num < target
        return lo;
    }
}
