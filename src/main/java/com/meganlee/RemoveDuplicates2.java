package com.meganlee;

public class RemoveDuplicates2 {
    //--------------- Solution 1 -------------------//
    // 2-pointers O(N)
    public int removeDuplicates(int[] A) {
        // input checking / quick check return
        if (A == null)     return 0;
        if (A.length <= 2) return A.length;

        // len: length of valid subarray, i move char-by-char
        int len = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[len - 2] != A[i]) {
                A[len++] = A[i];
            }
        }
        return len;
    }
}