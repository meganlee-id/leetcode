package com.meganlee;

import java.util.regex.*; // Matcher, Pattern

public class LengthOfLastWord {
    //--------------------  Solution 1 ------------------------//
    // sliding window (standard template)
    // could also be used to find kth words's length
    public int lengthOfLastWord(String s) {
        // input validation
        if (s == null || s.length() == 0) {
            return 0;
        }
        // invariant: [start, end] contains no space
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            // invariant broken, adjust start
            if (Character.isWhitespace(s.charAt(end))) { // do NOT use Character.isLetter, test case: "Hello World!!"
                start = end + 1;
            // invariant satisfied, only update res when it's last char
            } else if (end == s.length() - 1 || Character.isWhitespace(s.charAt(end + 1))) {
                res = end - start + 1;
            }
        }
        return res;
    }

    //--------------------  Solution 2 ------------------------//
    // Pure for loop: end to front
    public int lengthOfLastWord2(String s) {
        // input validation
        if (s == null || s.length() == 0) {
            return 0;
        }
        // find the last ch's index
        int end = s.length() - 1;
        while (end >= 0 && Character.isWhitespace(s.charAt(end))) {
            end--;
        }
        // find the space's index before the last word
        int start = end;
        while (start >= 0 && !Character.isWhitespace(s.charAt(start))) {
            start--;
        }
        return end - start;     // if no words end==start==-1
    }

    //---------------------- Solution 3 ----------------------//
    // String.trim() and String.split(regex)
    public int lengthOfLastWord3(String s) {
        // input validation
        if (s == null || s.trim().length() == 0) {  // s.trim().length() == 0
            return 0;
        }
        // at lease one word exists
        String sTrim = s.trim();
        String[] words = sTrim.split("\\s+");
        return words[words.length - 1].length();    // str.split(String regex)
    }

    //---------------------- Solution 4 ----------------------//
    // String.trim() and String.lastIndexOf()
    // Assumption: whitespace is only " "
    public int lengthOfLastWord4(String s) {
        // input validation
        if (s == null || s.trim().length() == 0) {  // s.trim().length() == 0
            return 0;
        }
        // at lease one word exists
        String sTrim = s.trim();
        int end = sTrim.length() - 1;
        int start = sTrim.lastIndexOf(" "); // if only one word and no space, return -1
        return end - start;
    }

    //---------------------- Solution 5 ----------------------//
    // sb.reverse() and matcher.find() && matcher.group();
    public int lengthOfLastWord5(String s) {
        // input validation
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = new StringBuilder(s).reverse().toString();
        Matcher m = Pattern.compile("\\w+").matcher(s);
        m.find();                   // m.find(): move the pointer to the next matching substring
        return m.group().length();  // m.group(): return the matched substring()
    }
}
