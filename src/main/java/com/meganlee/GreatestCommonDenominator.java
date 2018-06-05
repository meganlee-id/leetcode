package com.meganlee;

public class GreatestCommonDenominator {
    // call gcd(Math.max(a, b), Math.min(a, b))
    // a >= b && a > 0 && b > 0
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
