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
        // use a start and a end pointer to point to the last seen word
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            // if it's space, increment both start and end
            if (Character.isWhitespace(s.charAt(end))) {
                start++;
            // if it's letter increment only end
            // if it's leeter and end shows the end of the current word, calculate the word length
            } else if (end == s.length() - 1 || Character.isWhitespace(s.charAt(end + 1))) {
                res = end - start + 1;
                start = end + 1;
            }
        }
        return res;
    }

    //--------------------  Solution 2 ------------------------//
    // Pure for loop: from end to front
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
        String[] words = s.split("\\s+");
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

        int end = s.trim().length();           // think about when there is only one word
        int start = s.trim().lastIndexOf(" "); // think about when there is only one word
        return end - start - 1;
    }

    
    //---------------------- Solution 5 ----------------------//
    // sb.reverse() and matcher.find() && matcher.group();
    public int lengthOfLastWord5(String s) {
        if (s == null) {
            return 0;
        }
        s = new StringBuilder(s).reverse().toString();
        Matcher m = Pattern.compile("\\w+").matcher(s);
        m.find();                   // m.find(): move the pointer to the next matching substring
        return m.group().length();  // m.group(): return the matched substring()
    }
}