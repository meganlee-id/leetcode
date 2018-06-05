package com.meganlee;

import java.util.*;

public class Subsets {
    //--------------------  Solution 1  ---------------------//
    // recursion (DFS + backtrack)
    public List<List<Integer>> subsets(int[] nums) {
        // input checking
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        // recursive calls
        Arrays.sort(nums);  // remember to sort!!
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> subset, int[] nums, int cur) {
        // BASE CASE
        if (cur == nums.length) {
            res.add(new ArrayList(subset));
            return;
        }
        // GENERAL CASE
        // case 1: exclude cur elem
        helper(res, subset, nums, cur + 1);
        // case 2: ixclude cur elem
        subset.add(nums[cur]);
        helper(res, subset, nums, cur + 1);
        subset.remove(subset.size() - 1);
    }
    

    //--------------------  Solution 2  ---------------------//
    // iterative
    public List<List<Integer>> subsets2(int[] nums) {
        // input checking
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        // level by level
        List<List<Integer>> res = new ArrayList(); // do NOT use new ArrayList(new ArrayList()), will return 1D: []
        res.add(new ArrayList());  // add empty subset
        Arrays.sort(nums); // sort first!
        for (int num: nums) { // level by level
            int size = res.size(); // need to record this, otherwise it will be changed
            for (int i = 0; i < size; i++) {
                List<Integer> item = new ArrayList(res.get(i)); // add all previous elements
                item.add(num);
                res.add(item);
            }
        }
        return res;
    }
}

