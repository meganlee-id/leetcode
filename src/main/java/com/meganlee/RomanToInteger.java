package com.meganlee;

import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        // input checking
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        // assume the s is a valid Roman integer
        // 1. build the value chart
        char[] letters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values   = { 1,   5,   10,  50, 100, 500, 1000};
        Map<Character, Integer> table = new HashMap();
        for (int i = 0; i < letters.length; i++) {
            table.put(letters[i], values[i]);
        }
        
        // 2. calculate the value
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && table.get(s.charAt(i)) < table.get(s.charAt(i + 1))) {
                res -= table.get(s.charAt(i));
            } else {
                res += table.get(s.charAt(i));
            }
        }
        return res;
    }
}
