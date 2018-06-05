package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class PermutationSequence {
    //----------------- Solution 1 ------------------//
    // O(N) Math pattern, math
    public String getPermutation(int n, int k) {
        // check for n
        if (n <= 0) {
            return "";
        }
        // keep the remaining element list: IntStream.rangeClosed(1, n): int[]
        List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        // DP: get factorial table: used during calculation
        int fact[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            fact[i] = (i == 0) ? 1 : fact[i - 1] * i;
        }
        // check for k
        if (k < 1 || k > fact[n]) {
            return "";
        }
        k -= 1;  // k is 1-based --> change to 0-based
        // build the string
        StringBuilder res = new StringBuilder();
        for (int i = n; i > 0; i--){
            int index = k / fact[i - 1]; // next elem index
            k %= fact[i - 1]; // new k
            res.append(nums.get(index)); // append next elem
            nums.remove(index); // remove it
        }
        return res.toString();
    }
}


