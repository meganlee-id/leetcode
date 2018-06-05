package com.meganlee;

public class StringToInteger {
    //-------------   Solution 1 int: Reverse Calculation  ---------------//
    // use "reverse calculation" to check for overflow
    public int myAtoi(String str) {
        // input validation
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();

        // define vars, get sign            
        int absRes = 0;    //--DIFF-- use "int" + "reverse calculation"
        int i = 0;
        int sign = 1;      // if no sign char detected, should default to true
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = (str.charAt(0) == '+') ? 1 : -1;
            i++;
        }

        // convert the value
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int oldAbsRes = absRes;
            absRes = absRes * 10 + (str.charAt(i) - '0');  // convert char to int: digit = char - '0'
            if (absRes / 10 != oldAbsRes) {                //--DIFF--: overflow check using "reverse calculation"
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++; // remember to +1 in a while loop
        }
        // if no digit sequence detected, res remains 0 here, comply to the requirement
        return absRes * sign;
    }

    //------------- Solution 2. Use Long ---------------//
    // use "long" to check for overflow
    public static int myAtoi2(String str) {
        // input validation
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();

        // define vars, get sign
        long absRes = 0;    //--DIFF--  use long for detecting overflow during calculation
        int i = 0;
        int sign = 1;       // if no sign char detected, should default to true
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = (str.charAt(0) == '+') ? 1 : -1;
            i++;
        }

        // convert the value
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            absRes = absRes * 10 + (str.charAt(i) - '0');  // convert char to int: digit = char - '0'
            if (absRes > Integer.MAX_VALUE) {              //--DIFF-- overflow check: if (absRes == MAX + 1) isPos ? MAX : MIN
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++; // remember to +1 in a while loop
        }
        // if no digit sequence detected, res remains 0 here, comply to the requirement
        return (int)(absRes * sign); // remember to cast
    }



    //-------------   Solution 3 Reverse Calculation  ---------------//
    // StringBuilder.toString(): NOT RECOMMENDED FOR THIS PROBLEM
    public static int myAtoi3(String str) {
        // input validation
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();

        // define vars, get sign
        long absRes = 0;    //--DIFF-- use long for detecting overflow during calculation
        int i = 0;
        int sign = 1;       // if no sign char detected, should default to true
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = (str.charAt(0) == '+') ? 1 : -1;
            i++;
        }

        // convert the value
        StringBuilder sb = new StringBuilder();
        while (i < str.length() && Character.isDigit(str.charAt(i)) && sb.length() <= 10) { //--DIFF--: int couldn't be more than 10 digits
            if (!(sb.length() == 0 && str.charAt(i) == '0')) { // skip leading '0'
                sb.append(str.charAt(i));
            }
            i++; // remember to +1 in a while loop
        }
        absRes = (sb.length() == 0) ? 0 : Long.valueOf(sb.toString());
        if (absRes > Integer.MAX_VALUE) {              //--DIFF-- overflow check: if (absRes == MAX + 1) isPos ? MAX : MIN
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        // if no digit sequence detected, res remains 0 here, comply to the requirement
        return (int)(absRes * sign); // remember to cast
    }
}
