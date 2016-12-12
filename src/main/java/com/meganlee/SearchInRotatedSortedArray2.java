package com.meganlee;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == A[mid]) {         // find the target
                return true;

            } else if (A[lo] < A[mid]) {    // [lo ~ mid] is strictly sorted
                if (A[lo] <= target && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            } else if (A[lo] > A[mid]) {   // [mid ~ hi] is strictly sorted
                if (A[mid] < target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }

            } else {                       // not sure adjust lo              
                while (lo <= mid && A[lo] == A[mid]) {
                    lo++;
                }
            }
        }
        return false;
    }
}