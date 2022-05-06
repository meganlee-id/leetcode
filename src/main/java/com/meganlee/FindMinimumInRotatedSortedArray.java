package com.meganlee;

public class FindMinimumInRotatedSortedArray {
    // use examples to walk through the code logic
    // 1) [1]
    // 2) [1, 2]
    // 3) [2, 1]
    // 4) [1, 2, 3]
    // 5) [3, 1, 2]
    // 6) [2, 3, 1]
    //----------------  Solution 2  -----------------//
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int lo = 0, hi = num.length - 1;
        int min = Integer.MAX_VALUE;
        // go to the split side
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // [lo ~ mid] strictly sorted
            if (num[lo] <= num[mid]) {
                min = Math.min(min, num[lo]);  // if there is no split, num[lo] might be the answer
                lo = mid + 1;
            // [mid ~ hi] strictly sorted
            } else {
                min = Math.min(min, num[mid]); // if there is no split, num[mid] might be the answer
                hi = mid - 1;
            }
        }
        return min;
    }
}
