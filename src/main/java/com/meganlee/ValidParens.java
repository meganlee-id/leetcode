package com.meganlee;

import java.util.*;

public class ValidParens {
    //---------------- Solution: the most basic idea ----------------/
    // push when we meet open parens, pop and match when we see close parens
    public boolean isValid(String s) {
        // input checking, assume no other characters than "()[]{}"!!
        if (s == null) { // if s is "", return true
            return false;
        }
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
