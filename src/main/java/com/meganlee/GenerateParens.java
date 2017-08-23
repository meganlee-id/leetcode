package com.meganlee;

import java.util.*;

public class GenerateParens {
    public List<String> generateParenthesis(int n) {
        // input validation
        List<String> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        helper(res, new char[n * 2], n, n, 0);
        return res;
    }

    private void helper(List<String> res, char[] str, int open, int close, int i) {
        // base case: condition met
        if (i == str.length) { 
            res.add(String.valueOf(str));
            return;     // remember to return in base case
        }
        // general case: use '(' or ')' at current index i
        if (open > 0) { // open/close : number open/close partens left/unused
            str[i] = '(';
            helper(res, str, open - 1, close, i + 1);
        }
        if (close > 0 && close > open) {
            str[i] = ')';
            helper(res, str, open, close - 1, i + 1);
        }
    }
}
     
