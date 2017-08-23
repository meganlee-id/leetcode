package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class PermutationSequence {
    //----------------- Solution 1 ------------------//
    // use example, find pattern, math
    // O(N)
    public String getPermutation(int n, int k) {
        // check for n
        if (n <= 0) {
            return "";
        }
        // IntStream.rangeClosed(1, n): int[]
        List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        // get factorial table
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
            int index = k / fact[i - 1];
            res.append(nums.get(index));
            nums.remove(index);
            k %= fact[i - 1]; // new k
        }
        return res.toString();
    }
}


