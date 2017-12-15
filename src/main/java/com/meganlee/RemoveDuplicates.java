package com.meganlee;

public class RemoveDuplicates {
    //--------------- Solution 1 -------------------//
    // 2-pointers O(N)
    public int removeDuplicates(int[] A) {
        // input checking / quick check return
        if (A == null)     return 0;
        if (A.length <= 1) return A.length;

        // len: length of valid subarray, i move char-by-char
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[len - 1] != A[i]) {
                A[len++] = A[i];
            }
        }
        return len;
    }
}