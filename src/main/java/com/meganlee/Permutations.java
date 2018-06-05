package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class Permutations {
    //---------------- Solution 1 -------------------//
    // use int[] as solution builder, this solution uses swap()
    // Attention: it's fine in this problem to NOT use Arrays.sort, so the res perms are not naturally ordered
    public List<List<Integer>> permute(int[] nums) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // use a helper to recursively populate the res
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int start) {
        //--- 1. base case
        if (start == nums.length) {
            // construct a perm from int[] nums, and add to res
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        //--- 2. general case
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                helper(res, nums, start + 1);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    //--------------------- Solution 2 --------------------//
    // a very classic permutation solution
    // []
    // [1], [2], [3]
    // for [1]: [1 2], [1 3], for [2]: [2 1], [2 3] for [3]: [3 1] [3 2]
    // ...
    public List<List<Integer>> permute2(int[] nums) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // use a helper to recursively populate the res
        helper2(res, new ArrayList(), nums);
        return res;
    }

    private void helper2(List<List<Integer>> res, List<Integer> perm, int[] nums) {
        //--- 1. base case
        if (perm.size() == nums.length) {
            res.add(new ArrayList(perm));  // remember to new a List, otherwise perm would change
        //--- 2. general case
        } else {
            for (int num: nums) {
                if (!perm.contains(num)) {  // this line is important, filter out used numbers
                    perm.add(num);
                    helper2(res, perm, nums);
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }

    //----------------- Solution 3 -------------------//
    // iterative: 
    // level1: { [#] }      <-- # is the potential position to put next elem: 1
    // level2: { [# 1 #] }  <-- # are the possible postitions to put next elem: 2
    // level3: { [# 1 # 2 #], [# 2 # 1 #] } <-- for each perm, we have three # to put the next num
    // ...
    public List<List<Integer>> permute3(int[] nums) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // use a incremental way of constructing the solution
        Arrays.sort(nums);  // we dont' have to sort, if we don't need the final res list sorted
        res.add(new ArrayList()); // start with {[#]}
        for (int num: nums) {        // for each new number, add each number one by one
            List<List<Integer>> newRes = new ArrayList();
            for (List<Integer> perm: res) { // for each previous level res
                for (int i = 0; i <= perm.size(); i++) { // add new number to all possible pos
                    perm.add(i, num); // add number n at index i
                    newRes.add(new ArrayList(perm));
                    perm.remove(i);
                }
            }
            res = newRes;
        }
        return res;
    }
}