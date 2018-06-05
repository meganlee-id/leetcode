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
        // iterate backwards and append words one-by-one
        StringBuilder sb = new StringBuilder();
        for (int end = s.length() - 1, start = end; start >= 0; start--) {
            // if it's space, decrement both start and end
            if (Character.isWhitespace(s.charAt(start))) {
                end--;
            // if it's letter decrement only start
            // if it's letter and start of cur word, collect cur word
            } else if (start == 0 || Character.isWhitespace(s.charAt(start - 1))) {
                sb.append(s.substring(start, end + 1) + " ");
                end = start - 1;
            }
        }
        return sb.toString().trim(); 
        //---- alternative without trim() ----//
        // return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
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
