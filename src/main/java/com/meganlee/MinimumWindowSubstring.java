package com.meganlee;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // input validation
        String res = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return res;
        }
        // char frequency
        Map<Character, Integer> dict = new HashMap();
        for (char ch: t.toCharArray()) {
            dict.put(ch, dict.containsKey(ch) ? dict.get(ch) + 1 : 1);
        }
        // sliding window
        int count = 0; // use count to determine how many chars we've seen for solution collecting
        Map<Character, Integer> chsLeft = new HashMap(dict);
        for (int start = 0, end = start; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (chsLeft.containsKey(ch)) { // ch valid
                chsLeft.put(ch, chsLeft.get(ch) - 1); // count it
                if (chsLeft.get(ch) >= 0) { // was available
                    count++;
                } 
                if (count == t.length()) { // found a valid window
                    // shrink start
                    // DO NOT PUT char sChar = s.charAt(start) HERE at line 29, START IS CHANGING
                    while (!chsLeft.containsKey(s.charAt(start)) || chsLeft.get(s.charAt(start)) < 0) {
                        if (chsLeft.containsKey(s.charAt(start))) { // update chsLeft
                            chsLeft.put(s.charAt(start), chsLeft.get(s.charAt(start)) + 1);
                        }
                        start++;
                    }
                    // update solution
                    res = ("".equals(res) || res.length() > end - start + 1) ? s.substring(start, end + 1) : res;
                }
            } 
        }    
        return res;
    }
}

