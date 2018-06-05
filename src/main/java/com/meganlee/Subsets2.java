package com.meganlee;

import java.util.*;

public class Subsets2 {
    //--------------  Solution 1 ---------------------//
    // classic recursion (DFS + backtrack)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // input checking
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        Arrays.sort(nums);  // remember to sort!!
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res,  List<Integer> subset, int[] nums, int cur) {
        // base case
        if (cur >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }
        // GENERAL CASE
        // case 1: exclude cur elem ONLY WHEN the cur elem not in set (nums needs t be sorted)
        if (subset.isEmpty() || subset.get(subset.size() - 1) != nums[cur]) {
            helper(res, subset, nums, cur + 1);
        }
        // case 2: ixclude cur elem
        subset.add(nums[cur]);
        helper(res, subset, nums, cur + 1);
        subset.remove(subset.size() - 1);
    }

    //--------------  Solution 2 ---------------------//
    // incremental
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // input checking
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        // num freq
        Map<Integer, Integer> freq = new HashMap();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());  // add the empty set
        for (int num: freq.keySet()) { // level by level
            int count = freq.get(num);
            // step 2: add new number to set,
            // add current number zero, once, then twice...
            int size = res.size();
            for (int i = 1; i <= count; i++) {
                for (int k = (i - 1) * size; k < i * size; k++) {
                    List<Integer> item = new ArrayList(res.get(k));
                    item.add(num);
                    res.add(item);
                }
            }
        }
        return res;
    }
}
