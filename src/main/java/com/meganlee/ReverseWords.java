package com.meganlee;

import java.util.*;

public class ReverseWords {
    //-------------------  Solution 1 ------------------------//
    // sliding window (backwards)
    public String reverseWords(String s) {
        // validate input
        if (s == null || s.trim().length() == 0) { //---- also works without trim: s.length() == 0
            return "";
        }
        // invariant: in range [start, end] there is no whitespace
        List<String> res = new ArrayList();
        for (int end = s.length() - 1, start = end; start >= 0; start--) {
            // invariant broken, adjust start
            if (Character.isWhitespace(s.charAt(start))) {
                end = start - 1;
            // invariant hold, only update res if it's last char
            } else if (start == 0 || Character.isWhitespace(s.charAt(start - 1))) {
                res.add(s.substring(start, end + 1));
            }
        }
        return String.join(" ", res);
    }

    //-------------------  Solution 2 ------------------------//
    // String's build-in methods
    public String reverseWords2(String s) {
        // validate input
        if (s == null || s.trim().length() == 0) { //---- also works without trim: s.length() == 0
            return "";
        }
        // use built-in methods
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
