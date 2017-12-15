package com.meganlee;

import java.util.*;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        // input validation
        if (n <= 0) {
            return -1;
        }
        // use an n-sized array for calculation
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            // calculate ith number
            int next = Collections.min(Arrays.asList(2 * res[p2], 3 * res[p3], 5 * res[p5]));
            res[i] = next;
            // update poinster: do NOT use "else", will skip duplicate values
            if (next == 2 * res[p2]) p2++;
            if (next == 3 * res[p3]) p3++;
            if (next == 5 * res[p5]) p5++;
        }
        return res[n - 1];
    }
}