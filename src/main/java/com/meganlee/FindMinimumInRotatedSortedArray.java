package com.meganlee;

public class FindMinimumInRotatedSortedArray {
    //----------------  Solution 1  -----------------//
    // use examples to walk through the code logic
    // 1) [1]
    // 2) [1, 2]
    // 3) [2, 1]
    // 4) [1, 2, 3]
    // 5) [3, 1, 2]
    // 6) [2, 3, 1]
    public int findMin(int[] nums) {
        // validation
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            if (nums[lo] <= nums[hi]) {  // no split: lo == hi || nums[lo] < nums[hi]
                break;
            } else {                     // go to split side
                int mid = lo + (hi - lo) / 2;
                if (nums[lo] <= nums[mid]) {  
                    lo = mid + 1;  //---- [lo, mid] ordered, [mid + 1, hi] has split point
                } else {   
                    hi = mid;      //---- [mid + 1, hi] ordered, [lo, mid] has split point
                    // not mid - 1!                   
                }
            }
        }
        return nums[lo];   
    }


    //----------------  Solution 2  -----------------//
    public int findMin2(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int lo = 0, hi = num.length - 1;
        int min = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (num[lo] <= num[mid]) {  // [lo ~ mid] strictly sorted
                min = Math.min(min, num[lo]);
                lo = mid + 1;
            } else {                    // [mid ~ hi] strictly sorted
                min = Math.min(min, num[mid]);
                hi = mid - 1;
            }
        }
        return min;
    }
}
