package com.meganlee;

// Also checkout "GreatestCommonDenominator.java"

public class BinominalCoefficient {
    //------------ Solution works fine for small num ---------------//
    // when there is no overflow, the solution works fine
    public int binomialCoeff(int n, int k) {
        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }
        // starting from 1, there is a guarantee that the res is dividable: when i = 5
        // in numerator, there are 5 consecutive numbers, there must be a multiple of 5!
        int res = 1;
        for (int i = 1; i <= k; ++i) {
            res *= n - i + 1;
            res /= i;
        }
        return res;
        // n  /  1
        // n*(n-1) / 1*2
        // n*(n-1)*(n-2) / 1*2*3
        // n*(n-1)*(n-2)*(n-3) / 1*2*3*4
        // n*(n-1)*(n-2)*(n-3)*(n-4) / 1*2*3*4*5
        // ...
    }
}
