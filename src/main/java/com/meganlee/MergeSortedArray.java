package com.meganlee;


public class MergeSortedArray {
    //------------ Solution merg ------------//
    // while loop
    public void merge(int nums1[], int m, int nums2[], int n) {
        // input checking
        if (nums1 == null || nums2 == null) {
            return;
        }

        // merge two
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // copy leftovers: the problem assumes A.length > B.length
        // if 'a' is left over, all 'a' elements r already in place
        // if 'b' is left over, copy 'b' over
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}