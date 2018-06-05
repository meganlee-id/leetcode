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
        Map<Character, Integer> freq = new HashMap();
        for (char ch: t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        // sliding window
        int count = 0; // use count to determine how many chars we've seen for solution collecting
        Map<Character, Integer> chsLeft = new HashMap(freq);
        for (int start = 0, end = 0; end < s.length(); end++) {
            // we only update everything when next ch is valid
            char ch = s.charAt(end);
            if (freq.containsKey(ch)) {
                // 1. update cache
                chsLeft.put(ch, chsLeft.get(ch) - 1);
                count += (chsLeft.get(ch) >= 0) ? 1 : 0; // count towards one char in t
                if (count == t.length()) {
                    // 2. adjust start to mim size, when we find a valid window
                    while (chsLeft.getOrDefault(s.charAt(start), -1) < 0) { // extra valid char OR non-valid char
                        if (chsLeft.containsKey(s.charAt(start))) { // update chsLeft
                            chsLeft.put(s.charAt(start), chsLeft.get(s.charAt(start)) + 1);
                        }
                        start++;
                    }
                    // 3. update res
                    res = ("".equals(res) || res.length() > end - start + 1) ? s.substring(start, end + 1) : res; 
                }
           } 
        }    
        return res;
    }
}

