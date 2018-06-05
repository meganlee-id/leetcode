package com.meganlee;

import java.util.*;

public class CombinationSum2 {
    //----------------------  Solution 1 --------------------------//
    // Recursive: Exactly same as Combination Sum, except for
    // helper(res, combo, target - nums[i], nums, "start + 1"!!!);
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // input checking
        if (candidates == null || candidates.length == 0) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);  // sort to facilitate future calculation (might contain duplicates)
        helper(res, new ArrayList(), candidates, 0, target);
        return res;
    }
    
    // start is the min index of sorted elems
    // combo [2,4] == combo [4,2], we keep the combo sorted to avoid dupes
    private void helper(List<List<Integer>> res, List<Integer> combo, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList(combo));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                // find all the unique numbers left
                if (i == start || candidates[i - 1] != candidates[i]) {
                    combo.add(candidates[i]);
                    helper(res, combo, candidates, i + 1, target - candidates[i]); // diff index + 1
                    combo.remove(combo.size() - 1);
                }
            }
        } // otherwise target < 0 ignore
    }

    //----------------------  Solution 2 --------------------------//
    // Iterative
    public List<List<Integer>> combinationSum2B(int[] candidates, int target) {
        // input checking
        if (candidates == null || candidates.length == 0) {
            return new ArrayList();
        }
        Arrays.sort(candidates); // sorted
        List<List<Integer>> res = new ArrayList();      // result collector, res contains elem from all levels
        List<List<Integer>> level = new ArrayList();    // level collector
        level.add(new ArrayList(Arrays.asList(0, 0)));     // [[sum, start index]] Arrays.asList immutable
        while (!level.isEmpty()) {
            List<List<Integer>> newLevel = new ArrayList();
            for (List<Integer> combo: level) {
                int sum = combo.get(0), start = combo.get(1);
                if (sum == target) {
                    combo.remove(0); // remove sum
                    combo.remove(0); // remove start index
                    res.add(combo);  // collect
                } else if (sum < target) {
                    for (int i = start; i < candidates.length; i++) {
                        if (i == start || candidates[i - 1] != candidates[i]) { // current place do NOT use same elem
                            List<Integer> newCombo = new ArrayList(combo);
                            newCombo.add(candidates[i]); // append new elem
                            newCombo.set(0, sum + candidates[i]); // update sum
                            newCombo.set(1, i + 1); // update start index =======start from next elem ========
                            newLevel.add(newCombo);
                        }
                    }
                }  // otherwise target < 0 ignore
            }
            level = newLevel;
        }
        return res;
    }
}
