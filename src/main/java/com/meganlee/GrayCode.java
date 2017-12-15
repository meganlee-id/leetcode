package com.meganlee;

import java.util.*;

public class GrayCode {
    //----------------- Solution 1 ---------------------//
    public List<Integer> grayCode(int n) {
        // input validation
        List<Integer> res = new ArrayList();
        if (n < 0) {
            return res;
        }
        
        // collect result bit-by-bit / level-by-level
        res.add(0);
        // pos indicate 1) level 2) 0-indexed number of effective bits
        for (int pos = 0; pos < n; pos++) {
            // get the msb for appending the mirrored reversed number in current res
            int msb = 1 << pos;     // msb: most significant bit
            // append the mirrored reverse
            int size = res.size(); // record the size of last level
            for (int i = size - 1; i >= 0; i--) {
                res.add(msb + res.get(i));
            }
        }
        return res;
    }

    //----------------- Solution 2 ---------------------//
    // mathimetical
    public List<Integer> grayCode2(int n) {
        // input validation
        List<Integer> res = new ArrayList();
        if (n < 0) {
            return res;
        }
        
        // use binary -> Gray conversion XOR rule
        for (int i = 0; i < (1 << n); i++) { // i < 2^n
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
