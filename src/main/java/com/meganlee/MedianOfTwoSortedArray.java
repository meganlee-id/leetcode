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
        int mid1 = (N1 + N2 - 1) / 2;   // index of median1 0-based
        int mid2 = (N1 + N2)     / 2;   // index of median2 0-based
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
        return (nums3[mid1] + nums3[mid2]) / 2.0; // divided by 2.0 (double) not 2 (int)
    }


    //----------------- Solutin 2 -------------------//
    // Divide and conquer/Recursive
    // if (aMid < bMid) Keep [aRight + bLeft]    
    // else             Keep [bRight + aLeft]
    // NOTE: k is the length, starts from 1
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        int k1 = (N1 + N2 - 1) / 2 + 1;   // median1 is k1_th elem, 1-based
        int k2 = (N1 + N2)     / 2 + 1;   // median2 is k2_th elem, 1-based
        double median1 = findKth(nums1, 0, nums2, 0, k1);
        double median2 = findKth(nums1, 0, nums2, 0, k2);
        return (median1 + median2) / 2.0; // not divided by integer 2
    }

    // starting from index p1 in sorted array nums1, index p2 in sorted array nums2
    // find the kth elem using both arrays
    public double findKth(int[] nums1, int p1, int[] nums2, int p2, int k) {
        // base cases
        if (p1 > nums1.length - 1) {  // nums1 index overflows, return kth elem in nums2
            return nums2[p2 + k - 1];  
        }
        if (p2 > nums2.length - 1) {  // nums2 index overflows, return kth elem in nums1
            return nums1[p1 + k - 1];   
        }
        if (k == 1) {
            return Math.min(nums1[p1], nums2[p2]);
        }
        // general cases
        //----- if both arrays    has > k/2 elem, throw k/2 elem from the array with smaller max value
        //----- if only one array has > k/2 elem, throw k/2 elem from the array with longer length
        //
        // k/2 = half size, (p1 + k/2 - 1): end index to be cut away
        int cut1 = p1 + k / 2 - 1;  // max index in nums1 that might be cut away
        int cut2 = p2 + k / 2 - 1;  // max index in nums2 that might be cut away
        int max1 = (cut1 < nums1.length) ? nums1[cut1] : Integer.MAX_VALUE; // last elem in nums1 to be cut
        int max2 = (cut2 < nums2.length) ? nums2[cut2] : Integer.MAX_VALUE; // last elem in nums2 to be cut
        if (max1 < max2) {
            return findKth(nums1, p1 + k / 2, nums2, p2, k - k / 2); // throw away nums1's first k/2 elems
        } else {
            return findKth(nums1, p1, nums2, p2 + k / 2, k - k / 2); // throw away nums2's first k/2 elems
        }
    }

    //----------------- Solutin 3 -------------------//
    // iterative binary search derivative
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        // make sure nums1 is the array with smaller size, we'll binary search on it
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 > N2) return findMedianSortedArrays(nums2, nums1);
        // binary search on nums1, the array with smaller length
        int lo = 0, hi = N1; // the split point, hi is NOT N1-1, hi could be N1 too
        while (lo <= hi) {
            // k = mid1 + mid2: the kth elem is the smaller median
            int mid1 = lo + (hi - lo) / 2;       // size of left partition in nums1 to be checked
            int mid2 = (N1 + N2 + 1) / 2 - mid1; // size of left partition in nums2 to be checked
            // find 4 boundary numbers
            double leftMax1  = (mid1 == 0)  ? Integer.MIN_VALUE : nums1[mid1 - 1];
            double leftMax2  = (mid2 == 0)  ? Integer.MIN_VALUE : nums2[mid2 - 1];
            double rightMin1 = (mid1 == N1) ? Integer.MAX_VALUE : nums1[mid1];
            double rightMin2 = (mid2 == N2) ? Integer.MAX_VALUE : nums2[mid2];
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) { // find the right position
                double median1 = Math.max(leftMax1, leftMax2);
                double median2 = (N1 + N2) % 2 == 0 ? Math.min(rightMin1, rightMin2) : median1;
                return (median1 + median2) / 2.0;
            } else if (leftMax1 > rightMin2) { // shift mid1 to left
                hi = mid1 - 1;
            } else { // shift mid2 to right
                lo = mid1 + 1;
            }
        }
        // Only way we can reach here is that input arrays not sorted
        return -1;
    }
}