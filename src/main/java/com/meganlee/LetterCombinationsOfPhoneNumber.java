package com.meganlee;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    //-------------- Solution 1 --------------//
    // recursive:
    // could also use a char[] instead of a StringBuilder!
    // char[] --> String: String.valueOf(char[])
    public List<String> letterCombinations(String digits) {
        // input checking
        if (digits == null || digits.length() == 0) {
            return new ArrayList();
        }
        // normal case: (starts from index 2, pls see the phone keyboard)
        String[] buttons = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", };
        List<String> res = new ArrayList();
        helper(res, new StringBuilder(), digits, buttons, 0);
        return res;
    }

    private void helper(List<String> results, StringBuilder builder, String digits, String[] buttons, int start) {
        if (start == digits.length()) {      // base case
            results.add(builder.toString());
        } else {                             // general case
            int i = digits.charAt(start) - '0';
            for (char ch: buttons[i].toCharArray()) {
                builder.append(ch);
                helper(results, builder, digits, buttons, start + 1);
                builder.deleteCharAt(builder.length() - 1); // delete last char
            }
        }
    }

    //-------------- Solution 2 --------------//
    // iterative
    public List<String> letterCombinations2(String digits) {
        // input checking
        if (digits == null || digits.length() == 0) {
            return new ArrayList();
        }
        // {key: index, val: string}
        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList(Arrays.asList("")); // beginning level
        for (char digit: digits.toCharArray()) {  // each digit increment the level
            List<String> newRes = new ArrayList();
            for (String s: res) {
                int i = digit - '0';
                for (char ch: buttons[i].toCharArray()) { // WRONG: for (char c: string)
                    newRes.add(s + ch);   // it's ok to do "String" + 'x' <-- char
                }
            }
            res = newRes;
        }
        return res;
    }
}
