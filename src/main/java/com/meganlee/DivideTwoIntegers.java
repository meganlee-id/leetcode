package com.meganlee;

public class DivideTwoIntegers {
    //------------------ Solution 1 ---------------------//
    public int divide(int dividend, int divisor) {
        // T=O(N) S=Constant
        // the only 2 cases of overflow: 1) divide by 0 2) -214743648 / -1
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // record sign and get abs values for calculation
        boolean isNeg = ((dividend ^ divisor) >>> 31) == 1; //get sign:shift 31 ! not 32
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        // subtract b from a each time
        int absRes = 0;    // absRes won't overflow
        while (a >= b) {
            a -= b;
            absRes += 1;
        }
        return isNeg ? -absRes : absRes;
    }

    //------------------ Solution 2 ---------------------//
    // T=O(lgN) S=Constant
    // first find the largest shift, then do it bit by bit
    public int divide2(int dividend, int divisor) {
        // the only 2 cases of overflow: 1) divide by 0 2) -214743648 / -1
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // record sign and get abs values for calculation
        boolean isNeg = ((dividend ^ divisor) >>> 31) == 1; //get sign:shift 31 ! not 32
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        // find the largest shift
        long shift = 1, multiple = b;
        while (a >= (multiple << 1)) {
            shift <<= 1;
            multiple <<= 1;
        }
        // accumulate absRes bit by bit
        int absRes = 0;    // absRes won't overflow, use int
        while (shift >= 1) {
            if (a >= multiple) {
                a -= multiple;
                absRes += shift;
            }
            shift >>= 1;
            multiple >>= 1;
        }
        return isNeg ? -absRes : absRes;
    }

    //------------------ Solution 3 ---------------------//
    // NOTE: IF NOT ALLOWED TO USE LONG
    // WE CONSIDER HOW TO TACKLE OVERFLOW OF MATH.ABS(INTEGER.MIN_VALUE)
    public int divide3(int dividend, int divisor) {
        // only 2 cases of RESULT overflow 1) divide by 0 2) -214743648 / -1
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // record sign and get abs values for calculation
        boolean isNeg = ((dividend ^ divisor) >>> 31) == 1; //get sign:shift 31 ! not 32
        
        /*************/
        // overflow DURING colculation: Math.abs(Integer.MIN_VALUE)
        int absRes = 0;    // absRes won't overflow, use int
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == divisor) ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            absRes++;
        }
        /*************/

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        // subtract b from a each time
        while (a >= b) {
            a -= b;
            absRes += 1;
        }
        return isNeg ? -absRes : absRes;
    }
}
