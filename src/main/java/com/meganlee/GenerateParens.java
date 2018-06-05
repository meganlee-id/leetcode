package com.meganlee;

import java.util.*;

public class GenerateParens {
    //-------------------- Solution 1 -----------------//
    // backtracing, gen N^2 str, use check valid
    public List<String> generateParenthesis(int n) {
        // input validation
        List<String> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        backtrace(res, new char[n * 2], 0);
        return res;
    }

    private void backtrace(List<String> res, char[] str, int pos) {
        // base case: condition met
        if (pos == str.length) {
            if (isValid(str)) {
                res.add(String.valueOf(str));
            }
            return;     // remember to return
        }
        // general case:
        str[pos] = '(';
        backtrace(res, str, pos + 1);
        str[pos] = ')';
        backtrace(res, str, pos + 1);
    }

    private boolean isValid(char[] str) {
        int balance = 0;
        for (char ch: str) {
            balance += (ch == '(') ? 1 : -1;
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    //-------------------- Solution 2 -----------------//
    // backtracing + num_close_paren_left > num_open_paren_left
    public List<String> generateParenthesis2(int n) {
        // input validation
        List<String> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        helper(res, new char[n * 2], n, n, 0);
        return res;
    }

    private void helper(List<String> res, char[] str, int openLeft, int closeLeft, int pos) {
        // base case: condition met
        if (pos == str.length) { 
            res.add(String.valueOf(str));
            return;     // remember to return
        }
        // general case:
        if (openLeft > 0) {
            str[pos] = '(';
            helper(res, str, openLeft - 1, closeLeft, pos + 1);
        }
        if (closeLeft > 0 && closeLeft - 1 >= openLeft) {
            str[pos] = ')';
            helper(res, str, openLeft, closeLeft - 1, pos + 1);
        }
    }

    //-------------------- Solution 3 -----------------//
    // Catalan Simulation
    public List<String> generateParenthesis3(int n) {
        // input validation
        List<String> res = new ArrayList();
        if (n <= 0) {
            return res;
        }
        // Map<N, ListOfValidParens>
        Map<Integer, List<String>> map = new HashMap();
        map.put(0, Arrays.asList(""));
        for (int i = 1; i <= n; i++) {
            // Ci= C0*Ci-1 + C1*Ci-2 + ... + Ci-1*C0
            List<String> level = new ArrayList();
            for (int j = 0; j <= i - 1; j++) {
                for (String s1: map.get(j)) {
                    for (String s2: map.get(i - j - 1)) {
                        level.add("(" + s1 + ")" + s2);
                    }
                }
            }
            map.put(i, level);
        }
        return map.get(n);
    }
}
