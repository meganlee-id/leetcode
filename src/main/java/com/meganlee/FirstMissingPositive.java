package com.meganlee;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // input checking
        if (A == null || A.length == 0) {
            return 1;
        }
        // put num at index i = num - 1
        for (int i = 0; i < A.length; ) {
            int targetIndex = A[i] - 1;
            if (A[i] <= 0 || A[i] > A.length || i == targetIndex || A[i] == A[targetIndex]) {
                i++; // skip
            } else {
                swap(A, i, targetIndex); // swap, no i++
            }
        }
        // find the first number that is not the same with the index
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
