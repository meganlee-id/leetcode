package com.meganlee;

import java.util.*;

public class Permutations2 {
    //----------------- Solution 1 ------------------//
    // use int[] as solution builder
    // use swap smartly
    // permutations returned is not in a natural order because of swap
    public List<List<Integer>> permuteUnique(int[] num) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length == 0) {
            return res;
        }

        // use a helper to populate res
        helper(res, num, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] num, int start) {
        // base case
        if (start == num.length) {
            List<Integer> perm = new ArrayList();
            for (int i : num) {
                perm.add(i);
            }
            res.add(perm);
            return;
        }

        // general case
        Set<Integer> visited = new HashSet();
        for (int i = start; i < num.length; i++) {
            if (visited.contains(num[i])) {
                continue;
            }
            visited.add(num[i]);
            swap(num, start, i);
            helper(res, num, start + 1);
            swap(num, start, i);
        }
    }

    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }


    //------------------ Solution 2 ------------------//
    // the classic solution
    public List<List<Integer>> permuteUnique2(int[] num) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length == 0) {
            return res;
        }

        // use a helper to populate res
        List<Integer> nums = new ArrayList();
        for (int i: num) {
            nums.add(i);
        }
        helper(res, new ArrayList(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> perm, List<Integer> nums) {
        // base case
        if (nums.size() == 0) { // no more numbers to consume
            res.add(new ArrayList(perm));
            return;
        }

        // general case
        Set<Integer> visited = new HashSet();
        for (int i = 0; i < nums.size(); i++) {
            int k = nums.get(i);
            if (visited.contains(k)) {
                continue;
            }
            visited.add(k);

            perm.add(k);
            nums.remove(i);
            helper(res, perm, nums);
            nums.add(i, k);
            perm.remove(perm.size() - 1);
        }
    }

    //------------------- Solution 3 -------------------//
    // iterative
    public List<List<Integer>> permuteUnique3(int[] num) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length == 0) {
            return res;
        }

        // use a incremental way of constructing the solution
        Arrays.sort(num);
        res.add(new ArrayList());
        for (int i: num) {
            List<List<Integer>> resTemp = new ArrayList();
            for (List<Integer> perm: res) {
                for (int j = 0; j <= perm.size(); j++) {
                    perm.add(j, i);
                    resTemp.add(new ArrayList(perm));
                    perm.remove(j);
                    // only add until before the first occurrence of the same number
                    if (j < perm.size() && perm.get(j) == i) {
                        break;
                    }
                }
            }
            res = resTemp;
        }
        return res;
    }
}
