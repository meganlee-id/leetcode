package com.meganlee;

public class StringToInteger {
	
	//------------- Solution 1. Use casting ---------------//
    // use long to prevent overflow
    public static int myAtoi(String str) {
        // input validation
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();

        // define vars, get sign
        long res = 0;
        int i = 0;
        boolean isPos = true;                   // if no sign, isPos should be true by default
        char sign = str.charAt(0);
        if (sign == '+' || sign == '-') {
            isPos = (sign == '+');
            i++;
        }

        // convert the value
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';    // don't forget to convert to int
            res = res * 10 + digit;
            if (res > Integer.MAX_VALUE) {      // if (res == MAX + 1) isNeg ? MIN : MAX  [NOTE: abs(MIN) = MAX + 1]
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++; // remember to +1 in a while loop
        }
        return (int)(isPos ? res : -res);
    }


	//-------------   Solution 2 No casting version A  ---------------//
    public int myAtoi1(String str) {
        // input validation
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();

        // define vars, get sign
        int res = 0;                                       ////// diff 1. use 'int' instead of 'long'
        int i = 0;
        boolean isPos = true;
        char sign = str.charAt(0);
        if (sign == '+' || sign == '-') {
            isPos = (sign == '+');
            i++;
        }

        // convert the string to integer
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {  ////// diff 2. boundary check if (res * 10 + digit) > MAX (reversed calc)
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return isPos ? res : -res;
    }
    

    //-------------   Solution 3 No casting version B  ---------------//
    public int myAtoi2(String str) {
        // input validation
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();

        // define vars, get sign
        int res = 0;                        /////// diff 1. use 'int' instead of 'long'
        int i = 0;
        boolean isPos = true;
        char sign = str.charAt(0);
        if (sign == '+' || sign == '-') {
            isPos = (sign == '+');
            i++;
        }

        // convert the string to integer
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            int oldRes = res;
            res = res * 10 + digit;
            if (res / 10 != oldRes) {       ////// diff 2. if overflow res / 10 != oldRes (sign might still be the same in some cases)
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return isPos ? res : -res;
    }

    
    ////////////////// TEST ///////////////////////
    public static void test(StringToInteger solution, String s) {
        System.out.println(solution.myAtoi(s));
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();
        test(solution, "");
        test(solution, "   ");
        test(solution, null);
        test(solution, " a-00de ");

        test(solution, "  -0000123");
        test(solution, "  +0000123");
        test(solution, "  0000123abc");

        test(solution, "2147483659");
        test(solution, "-2147483648");
    }
}
