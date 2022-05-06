package com.meganlee;


public class SearchInRotatedSortedArray {
    //------------------- Solution 1 ----------------------//
    // brute force O(n)
    public int search(int[] nums, int target) {
        // input checking
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // check one by one
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //------------------- Solution 2 ----------------------//
    // a more concise way of developing the algorithm
    public int search2(int[] nums, int target) {
        // input checking
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // binary search
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {          // find the target
                return mid;
            } else if (nums[lo] <= nums[mid]) { // [lo ~ mid] strictly sorted (<= not <, lo might equals mid)
                if (nums[lo] <= target && target < nums[mid]) { // target '<' mid (not <=)
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {                            // [mid ~ hi] strictly sorted
                if (nums[mid] < target && target <= nums[hi]) { // mid '<'' target (not <=)
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
