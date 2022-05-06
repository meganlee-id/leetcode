package com.meganlee;

public class SortColors {
    //-------------  SOLUTION 1: 2 SCANs ----------------//
    // counting sort
    public void sortColors(int[] A) {
        // check input
        if (A == null || A.length == 0) {
            return;
        }
        // count
        int[] counts = new int[3];
        for (int i: A) {
            counts[i]++;
        }
        // fill
        for (int i = 0; i < A.length; i++) {
            if (i < counts[0]) {
                A[i] = 0;
            } else if (i < counts[0] + counts[1]) {
                A[i] = 1;
            } else {
                A[i] = 2;
            }
        }
    }

    //-------------  SOLUTION 2: 1 SCAN ----------------//
    public void sortColors2(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }
        int lt = 0, i = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, gt--);
            } else { // nums[i] == 1
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}

