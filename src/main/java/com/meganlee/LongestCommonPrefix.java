package com.meganlee;

import java.util.*;

public class LongestCommonPrefix {
    //------------------ Solution 1 -----------------------//
    // sort and solve
    public String longestCommonPrefix(String[] strs) {
        // input checking
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 1. sort the array first
        Arrays.sort(strs);
        // 2. compare the fist and last Strings 
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0; // index for the end of prefix
        while (i < Math.min(first.length(), last.length())) { // use "while", we need to know "i" out of loop
            if (first.charAt(i) != last.charAt(i)){
                break;
            }
            i++;
        }
        return first.substring(0, i);
    }

    //------------------ Solution 2 -----------------------//
    // char-by-char: faster to terminate that solution 1
    public String longestCommonPrefix2(String[] strs) {
        // input checking
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {   // for each char/colum
            for (int j = 1; j < strs.length; j++) {    // for each string
                // no more char for strs[j] || strs[j]'s current char is different
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0]; // return!
    }
}
