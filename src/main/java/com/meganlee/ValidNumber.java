package com.meganlee;

public class ValidNumber {
    //------------------- Solution 1 ------------------//
    // use regular expression
    // AeB
    //
    // A could be integer or float
    //     1) sign --> + - non
    //     2) [0-9]*.[0-9]* would all be valid except for . only
    //         e.g: 000  30.  .05   9.00
    //
    // B should be integer
    //     1) sign --> + - non
    //     2) [0-9]+
    //
    // eB must appear or disappear together
    //
    // A = [+-]? (I | F)
    //      I = [0-9]+\.?          --> integer
    //      F = [0-9]*\.[0-9]+     --> float
    //
    // e = [eE]
    //
    // B = [+-]?[0-9]+    --> raised to the power
    //
    // REGEX = A(eB)? 
    //       = [+-]?([0-9]+\.?|[0-9]*\.[0-9]+)([eE][+-]?[0-9]+)?
    public boolean isNumber(String s) {
        // input validation
        if (s == null) {
            return false;
        }
        // String.matches("regex_string")
        return s.trim().matches("[+-]?([0-9]+\\.?|[0-9]*\\.[0-9]+)([eE][+-]?[0-9]+)?");
    }


    //------------------- Solution 2 ------------------//
    // check string one-by-one, using flag
    public boolean isNumber2(String s) {
        // input validation
        if (s == null) {
            return false;
        }
        s = s.trim().toLowerCase();
        // check char one-by-one
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDot = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                hasNum = true;
            } else if (ch == '.') {
                if (hasE || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
                hasNum = false;  // have to have number after
            } else if (ch == 'e') {
                if (!hasNum || hasE) {
                    return false;
                }
                hasE = true;
                hasNum = false;  // have to have number after
            } else {
                return false;
            }
        }
        return hasNum;
    }

    //------------------- Solution 3 ------------------//
    // DFA: automator
    public boolean isNumber3(String s) {
        // input validation
        if (s == null) {
            return false;
        }
        s = s.trim().toLowerCase();
        // use a flag for deciding on dot
        boolean hasNum = false;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                hasNum = true;
                if (state <= 2) {
                    state = 2;
                } else if (state <=4) {
                    state = 4;
                } else {
                    state = 7;
                }
            } else if (ch == '+' || ch == '-') {
                if (state == 0 || state == 5) {
                    state++;
                } else {
                    return false;
                }
            } else if (ch == '.') {
                if (state <= 2) {
                    state = 3;
                } else {
                    return false;
                }
            } else if (ch == 'e') {
                if (hasNum && 2 <= state && state <= 4) {
                    state = 5;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return (state == 2) || (state == 3 && hasNum) || (state == 4) || (state == 7);
    }
}
