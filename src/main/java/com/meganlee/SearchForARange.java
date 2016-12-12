package com.meganlee;

import java.util.Arrays;

public class SearchForARange {
    //--------------------- Solution 1 -----------------------//
    // search for a ceiling/floor, use search for insertion position as a
    public int[] searchRange(int[] A, int target) {
        // input checking
        if (A == null || A.length == 0) {
            return new int[] {-1, -1};
        }
        
        // find if target exist, if exists, get the first occurence' index
        int lowBound = firstGreatEqual(A, target);
        if (lowBound == A.length || A[lowBound] != target) { // target doesn't exist
            return new int[] {-1, -1};
        } else { // target exists in array
            int highBound = firstGreatEqual(A, target + 1) - 1;
            return new int[] {lowBound, highBound};
        }
    }
    
    private int firstGreatEqual(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target <= A[mid]) {  // pay attention to the condition here
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}