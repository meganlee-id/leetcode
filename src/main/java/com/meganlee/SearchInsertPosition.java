package com.meganlee;

public class SearchInsertPosition {
    public static int searchInsert(int[] A, int target) {
        // binary search
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
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
