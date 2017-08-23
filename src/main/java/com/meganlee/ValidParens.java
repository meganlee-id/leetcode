package com.meganlee;

import java.util.*;

public class ValidParens {
    //---------------- Solution1: the most basic idea ----------------/
    // push when we meet open parens, pop and match when we see close parens
    public boolean isValid(String s) {
        // input checking, assume no other characters than "()[]{}"!!
        if (s == null || s.length() == 0) {
            return false;
        }
        // use a stack to do valid checking
        Stack<Character> st = new Stack();
        String openParens = "([{", closeParens = ")]}";
        for (char ch : s.toCharArray()) {
            // CORRECT: String.contains(str) WRONG: String.contains(char)
            if (openParens.contains(String.valueOf(ch))) {
                st.push(ch);
            } else if (st.empty() || openParens.indexOf(st.pop()) != closeParens.indexOf(ch)) {
                return false;
            }

            //---- an alternative way of writing the if-else block: -----
            // MORE READABLE
            // if (openParens.contains(String.valueOf(ch))) { // 'if' part is same as above
            //     st.push(ch);
            // } else { // right parens
            //     if (st.empty()) {
            //         return false;
            //     }
            //     char top = st.pop();
            //     if (openParens.indexOf(top) != closeParens.indexOf(ch)) {
            //         return false;
            //     }
            // }
        } 
        return st.isEmpty();
    }
}
