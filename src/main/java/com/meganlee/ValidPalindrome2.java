package com.meganlee;

public class ValidPalindrome2 {
    //------------------- Solution 1 ------------------------//
    // Recursive: might have stack overflow if input string is too long
   public boolean validPalindrome(String s) {
        // input validate
        if (s == null) {
            return false;
        }
        // check recursively
        char[] chs = s.toCharArray();
        return helper(chs, 0, chs.length - 1, false);
    }
    
    private boolean helper(char[] chs, int s, int e, boolean deleted) {
        // base case
        if (s >= e) {
            return true;
        }
        // general case
        return (chs[s] == chs[e] && helper(chs, s + 1, e - 1, deleted)) ||
               (!deleted && helper(chs, s + 1, e, true)) ||
               (!deleted && helper(chs, s, e - 1, true));
    }

    //------------------- Solution 2 ------------------------//
    // Iterative
    public boolean validPalindrome2(String s) {
        // input validate
        if (s == null) {
            return false;
        }
        // find the 1st diff or return true
        for (int start = 0 , end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return isValid(s, start + 1, end) || isValid(s, start, end - 1);
            }
        }
        return true;
    }
    
    private boolean isValid(String s, int start, int end) {
        // base case
        if (start >= end) {
            return true;
        }
        // general case
        StringBuilder sb = new StringBuilder(s.substring(start, end + 1));
        return sb.toString().equals(sb.reverse().toString());
    }
}
