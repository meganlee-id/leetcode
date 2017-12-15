package com.meganlee;


public class ReverseInteger {
    //----------------- Solution 1 --------------------//
    // direct reverse
    // The following works even if x < 0
    // In Java -123 / 10 = -12  (python: -13)
    //         -123 % 10 = -3   (python: 7)
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10; // scrape lowest digit
            x /= 10;            // shift 1 digit to right (10-based)

            int oldRes = res;           // store the value before the change
            res = res * 10 + digit;     // accumulate to res
            if (res / 10 != oldRes) {   // check overflow: reverse calculation
                return 0;
            }
        }
        return res;
    }

    //----------------- Solution 2 --------------------//
    // Use "long" (fastest solution)
    public long reverse2(int x) {
        long res = 0;     // use long to store res to prevent overflow
        while(x != 0) {
            int digit = x % 10;         // scrape lowest digit
            x /= 10;                    // shift 1 digit right (10-based) 
            res = res * 10 + digit;     // accumulate to res
        }
        // check overflow and cast to int!!
        return (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) ? (int)res : 0;
    }

    //----------------- Solution 3 --------------------//
    // use "string" and "long"
    public long reverse3(int x) {
        // prepare for reverse
        int sign = (x < 0) ? -1 : 1;    // store sign
        long absX = Math.abs((long)x);  // use long

        // use String to reverse
        String xStr = String.valueOf(absX);
        String xStrR = new StringBuilder(xStr).reverse().toString();

        // check overflow and cast to int!!
        long res = Long.valueOf(xStrR) * sign; // get sign back
        return (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) ? (int)res : 0;
    }
}
