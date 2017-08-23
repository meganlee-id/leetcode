package com.meganlee;

import java.util.*;

public class FourSum {
    //-------- Sort and solve, exactly the same code as 3sum --------------//
    public List<List<Integer>> fourSum(int[] num, int target) {
        // input validation
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length < 4) {
            return res;
        }

        // remember to sort before 
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            // skip all duplicate for the 1st num
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length; j++) {
                // skip all duplicates for the 2nd num
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                // start -> 3rd num; end -> 4th num
                for(int start = j + 1, end = num.length - 1; start < end; ) {
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if (sum == target) {
                        List<Integer> quad = Arrays.asList(num[i], num[j], num[start], num[end]);
                        res.add(quad);
                        start++;
                        end--;
                        while (start < end && num[start] == num[start - 1]) {
                            start++;
                        }
                        while (start < end && num[end] == num[end + 1]) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }

    ///////////// TEST ////////////
    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = {1, 2, 5, -3, 4, 2, 1, 1, 3, 6, 5, 7, 1, -3};
        List<List<Integer>> res = solution.fourSum(nums, 0);
        PrettyPrinter.print2DIntList(res);
    }
}

