package com.meganlee;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        // input checking
        if (nums == null || nums.length == 0) {
            return false;
        }
        // binary search
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {           // find the target
                return true;
            } else if (nums[lo] < nums[mid]) {   // [lo ~ mid] strictly sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[lo] > nums[mid]) {   // [mid ~ hi] strictly sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {                            // not sure adjust lo
                while (lo <= mid && nums[lo] == nums[mid]) {
                    lo++;
                }
            }
        }
        return false;
    }
}