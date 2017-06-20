package com.meganlee;

public class MedianOfTwoSortedArray {
    // assume A and B are not null
    // assume m + n >= 1

    //----------------- Solutin 1 -------------------//
    // O(N) space and time, Merge Sort
    // remember this solution!!
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // calculate the two indices for median
        int N1 = nums1.length, N2 = nums2.length;
        int mid1 = (N1 + N2 - 1) / 2; // index of median1
        int mid2 = (N1 + N2) / 2;     // index of median2
        
        // create the merged array
        int[] nums3 = new int[N1 + N2];
        int i = 0, j = 0, k = 0; // k = num of elems merged || index to place next elem
        while (i < N1 && j < N2) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        // copy remainders
        while (i < N1) {
            nums3[k++] = nums1[i++];
        }
        while (j < N2) {
            nums3[k++] = nums2[j++];
        }
        // divided by 2.0 (double) not 2 (int)
        return (nums3[mid1] + nums3[mid2]) / 2.0;
    }


    //----------------- Solutin 2 -------------------//
    // Divide and conquer/Recursive
    // if (aMid < bMid) Keep [aRight + bLeft]    
    // else             Keep [bRight + aLeft]
    // NOTE: k is the length, starts from 1
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int k1 = (A.length + B.length + 1) / 2;
        int k2 = (A.length + B.length + 2) / 2;
        return (findKth(A, 0, B, 0, k1) + findKth(A, 0, B, 0, k2)) / 2.0;
    }

    public double findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        // base cases
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];  
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];   
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        
        // general cases
        int aMedian = (aStart + k / 2 - 1 < A.length) ? A[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bMedian = (bStart + k / 2 - 1 < B.length) ? B[bStart + k / 2 - 1] : Integer.MAX_VALUE;
        if (aMedian < bMedian) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2); // Check: aRight + bLeft 
        } else {
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2); // Check: bRight + aLeft
        }
    }

    //----------------- Solutin 3 -------------------//
    // iterative binary search derivative
    // https://discuss.leetcode.com/topic/3367/share-my-iterative-solution-with-o-log-min-n-m
}