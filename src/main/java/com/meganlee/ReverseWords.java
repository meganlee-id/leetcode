package com.meganlee;

import java.util.*;

public class ReverseWords {
    //-------------------  Solution 1 ------------------------//
    // use String's build-in methods
    public String reverseWords(String s) {
        // validate input
        if (s == null || s.length() == 0) {
            return "";
        }
        // use built-in methods
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    
    
    //-------------------  Solution 2 ------------------------//
    // split the string by hand (same algorithm as above 2)
    public String reverseWords2(String s) {
        // validate input
        if (s == null || s.length() == 0) {
            return "";
        }
        // iterate backwards and append words one-by-one
        StringBuilder sb = new StringBuilder();
        boolean trimable = false; // whether to trim a final " " in sb
        for (int i = s.length() - 1, start = i, end = i; i >= 0; i--) {
            if (!Character.isSpace(s.charAt(i))) { // do NOT use Character.isLetter, test case: "Hello World!!"
                if (i == s.length() - 1 || Character.isSpace(s.charAt(i + 1))) {
                    end = i;   // identify the end of a word
                }
                if (i == 0 || Character.isSpace(s.charAt(i - 1))) {
                    start = i; // identify the start of a word
                    sb.append(s.substring(start, end + 1) + " ");
                    trimable = true;
                }
            }
        }
        return trimable ? sb.substring(0, sb.length() - 1) : sb.toString();
    }
}
