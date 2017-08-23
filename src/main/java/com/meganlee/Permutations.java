package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class Permutations {
    //---------------- Solution 1 -------------------//
    // use int[] as solution builder, this solution uses swap()
    // Attention: it's fine in this problem to NOT use Arrays.sort, so the res perms are not naturally ordered
    public List<List<Integer>> permute(int[] num) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length == 0) {
            return res;
        }
        // use a helper to recursively populate the res
        helper(res, num, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] num, int start) {
        //--- 1. base case
        if (start == num.length) {
            // construct a perm from int[] num, and add to res
            res.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
        //--- 2. general case
        } else {
            for (int i = start; i < num.length; i++) {
                swap(num, start, i);
                helper(res, num, start + 1);
                swap(num, start, i);
            }
        }
    }

    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }


    //--------------------- Solution 2 --------------------//
    // a very classic permutation solution
    public List<List<Integer>> permute2(int[] num) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length == 0) {
            return res;
        }
        // use a helper to recursively populate the res
        helper2(res, new ArrayList(), num);
        return res;
    }

    private void helper2(List<List<Integer>> res, List<Integer> perm, int[] num) {
        //--- 1. base case
        if (perm.size() == num.length) {
            res.add(new ArrayList(perm));  // remember to new a List
        //--- 2. general case
        } else {
            for (int i : num) {
                if (!perm.contains(i)) {
                    perm.add(i);
                    helper2(res, perm, num);
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
    public List<List<Integer>> permute3(int[] num) {
        // input checking
        List<List<Integer>> res = new ArrayList();
        if (num == null || num.length == 0) {
            return res;
        }

        // use a incremental way of constructing the solution
        Arrays.sort(num);
        res.add(new ArrayList());
        for (int i: num) {
            List<List<Integer>> newRes = new ArrayList();
            for (List<Integer> perm: res) {
                for (int j = 0; j <= perm.size(); j++) {
                    perm.add(j, i);
                    newRes.add(new ArrayList(perm));
                    perm.remove(j);
                }
            }
            res = newRes;
        }
        return res;
    }
}