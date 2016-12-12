package com.meganlee;


public class ReverseInteger {
    //----------------- Solution 1 & 2--------------------//
    // Classic reverse process
    public int reverse(int x) {
        // The following works even if x < 0
        // In Java -123 / 10 = -12  (python: -13)
        //         -123 % 10 = -3   (python: 7)
        int res = 0;
        while (x != 0) {
            int oldRes = res;           // store the value before the change

            int digit = x % 10;
            res = res * 10 + digit;
            x /= 10;

            if (res / 10 != oldRes) {   // reverse calculation, if not equals to oldRes, overflow
                return 0;
            }
        }
        return res;
    }

    // convert to long for calculation
    public long reverse2(int x) {
        int sign = (x > 0) ? 1 : -1;    // get the sign
        long absX = Math.abs((long)x);  // use long (-Integer.MIN_VALUE overflow)

        long res = 0;
        while(absX != 0) {
            long digit = absX % 10;     // use long
            res = res * 10 + digit;
            absX /= 10;
        }

        res *= sign;
        return (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) ? (int)res : 0;  // remember to cast to (int)
    }

    //----------------- Solution 3 --------------------//
    // string method
    public long reverse3(int x) {
        int sign = (x < 0) ? -1 : 1;
        long absX = Math.abs((long)x);

        String xStr = String.valueOf(absX);
        String xStrR = new StringBuilder(xStr).reverse().toString();

        long res = Long.parseLong(xStrR) * sign;
        return (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) ? (int)res : 0;
    }


    
    ////////////////// TEST ///////////////////////
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int[] numbers = {-1200, 2344, 0, 2345, 1220010};
        System.out.println("----------------");
        for (int x : numbers) {
            System.out.println(solution.reverse(x));
        }

        System.out.println("----------------");
        for (int x : numbers) {
            System.out.println(solution.reverse2(x));
        }
        System.out.println(-123/10);
        System.out.println(Math.abs((long)Integer.MIN_VALUE));
    }
}
