package com.meganlee;

import java.util.*;

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
        // String.matches("regex_string")
        return s.trim().matches("[+-]?([0-9]+\\.?|[0-9]*\\.[0-9]+)([eE][+-]?[0-9]+)?");
    }


    //------------------- Solution 2 ------------------//
    // check string one-by-one, using flag
    public boolean isNumber2(String s) {
        s = s.toLowerCase().trim();
        boolean dotSeen = false;
        boolean eSeen   = false;
        boolean numberBeforeE = false;
        boolean numberAfterE  = false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i); 
            if ('0' <= cur && cur <= '9') {
                if (!eSeen) numberBeforeE = true;
                if (eSeen)  numberAfterE  = true;
            } else if (cur == '-' || cur == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (cur == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (cur == 'e' ) {
                if (eSeen) return false;
                eSeen = true;
            } else { // invalid chars
                return false;
            }
        }
        return eSeen ? (numberBeforeE && numberAfterE) : numberBeforeE;
    }

    //------------------- Solution 3 ------------------//
    // DFA: automator
    public boolean isNumber3(String s) {
        s = s.trim().toLowerCase();
        // use a flag for deciding on dot
        boolean numBeforeE = false;
        boolean numAfterE  = false;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // state transition
                if      (state <= 2) state = 2;
                else if (state <= 4) state = 4;
                else if (state <= 7) state = 7;
                else return false;
                // update num flag
                if (state <= 4) numBeforeE = true;
                if (state >  4) numAfterE  = true;
            } else if (ch == '+' || ch == '-') {
                // state transition
                if (state == 0 || state == 5) state++;
                else return false;
            } else if (ch == '.') {
                if (state <= 2) state = 3;
                else return false;
            } else if (ch == 'e') {
                if (2 <= state && state <= 4) state = 5;
                else return false;
            } else {
                return false;
            }
        }
        return (numBeforeE && Arrays.asList(2, 3, 4).contains(state)) || (numBeforeE && numAfterE && state == 7);
    }
}
