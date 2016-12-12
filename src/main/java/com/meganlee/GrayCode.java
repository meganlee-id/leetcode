package com.meganlee;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	//----------------- Solution 1 ---------------------//
    public List<Integer> grayCode(int n) {
        // input validation
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        
        // collect result bit-by-bit / level-by-level
        res.add(0);
        for (int pos = 0; pos < n; pos++) { // track levels of iteration, pay attention of off-by-one error
            int size = res.size();
            int msb = 1 << pos;  // msb: most significant bit
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
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        
        // use binary -> Gray conversion XOR rule
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
