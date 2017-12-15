package com.meganlee;


public class RemoveElement {

    //---------------- Solution 1 --------------------//
    // 2 pointers, stable, more moves
    public int removeElement(int[] A, int elem) {
        // input check
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = 0;        // len of the valid pre-subarray
        for (int i = 0; i < A.length; i++) { // move one step a time, check char-by-char
            if (A[i] != elem) {
                A[len++] = A[i];
            }
        }
        return len;
    }

    //---------------- Solution 2 -----------------//
    // 2 pointers, non-stable, less moves with sparse target
    public int removeElement2(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0, j = A.length - 1;
        while (i <= j) {
            if (A[i] != elem) {
                i++;
            } else {
                // swap(A, i, j--);  // no need to swap!, discard target
                A[i] = A[j];
                j--;
            }
        }
        return i;
    }
}
