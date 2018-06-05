package com.meganlee;

public class ValidPalindrome {
    //------------------- Solution 1 ------------------------//
    // two pointers meeting each other
    public boolean isPalindrome(String s) {
        // input validation
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chs = s.toLowerCase().toCharArray(); // convert to ALL LOWERCASE
        for (int start = 0, end = chs.length - 1; start <= end; ) {
            // each time we move any pointer, need to check condition: start <= end
            char s_ch = chs[start], e_ch = chs[end];
            if      (!Character.isLetterOrDigit(s_ch)) start++;
            else if (!Character.isLetterOrDigit(e_ch)) end--;
            else if (s_ch == e_ch)                   { start++; end--; } // need {} to form a block
            else return false;                                       
        }
        return true;
    }

    //------------------- Solution 2 ------------------------//
    // StringBuilder: equals its reverse
    public boolean isPalindrome2(String s) {
        // input validation
        if (s == null || s.length() == 0) {
            return true;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                strBuilder.append(ch);
            }
        }
        return strBuilder.toString().equals(strBuilder.reverse().toString());
    }

    //-------------- Appendix ----------------//
    // if we could not use toLowerCase() or isLetter() or isDigit()
    private boolean isLetterOrDigit(char c) {
        if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean isSame(char c1, char c2) {
        // convert upper letter to lower letter
        // lowercase and digit stay the same
        if(c1 >= 'A' && c1 <= 'Z') {
            c1 = (char) (c1 - 'A' + 'a');
        }
        if(c2 >= 'A' && c2 <= 'Z') {
            c2 = (char) (c2 - 'A' + 'a');
        }
        return c1 == c2;
    }
}
