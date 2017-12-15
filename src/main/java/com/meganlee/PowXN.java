package com.meganlee;


public class PowXN {
    //------------------  Solution 1 --------------------//
    // divide and conquer -- recursion
    public double myPow(double x, int n) {
        /********** Will pass without this block *********/
        // validation
        if (x == 0 && n > 0) return 0;
        if (x == 0 && n < 0) throw new ArithmeticException("Could not raise 0 to a negative number!");
        // quick return
        if (x == 1) return 1;
        if (x == -1) return (n % 2 == 0) ? 1 : -1;
        /*************************************************/

        // base case
        if (n == 0) {
            return 1;
        }
        
        // general case
        double remainder = 1;
        if (n % 2 != 0) {
            remainder = (n > 0) ? x : 1 / x;
        }
        double half = myPow(x, n / 2);
        return half * half * remainder;
    }

    //------------------  Solution 2 --------------------//
    // bitwise operation -- recursion
    public double myPow2(double x, int n) {
        double res = 1, base = x;
        long absN = Math.abs((long)n); // use long to prevent overflow
        while(absN > 0) {
            if((absN & 1) == 1) {      // lowest bit of absN is 1
                res *= base;           // multiply current base to result
            }
            absN >>= 1;                // absN / 2
            base *= base;              // base = base^2
        }
        return n < 0 ?  1 / res : res; // check n sign
    }


    ////////////////////  TEST  /////////////////////
    public static void main(String[] args) {
        try {
            PowXN p = new PowXN();

            // n > 0
            System.out.println(p.myPow(-3, 2));
            System.out.println(p.myPow(1, 2));
            System.out.println(p.myPow(0.5, 3));
            System.out.println(p.myPow(-0.5, 3));

            // n < 0
            System.out.println(p.myPow(-3, -1));
            System.out.println(p.myPow(3, -2));
            System.out.println(p.myPow(0.5, -3));
            System.out.println(p.myPow(-0.5, -3));

            // n == 0
            System.out.println(p.myPow(1, 0));
            System.out.println(p.myPow(-0.5, 0));

            // x == 0
            System.out.println(p.myPow(0, 0));
            System.out.println(p.myPow(0, 1));
            System.out.println(p.myPow(0, -1));

            // x == 1
            System.out.println(p.myPow(1, Integer.MIN_VALUE));


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

