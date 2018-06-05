package com.meganlee;

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // validate input (assume input is a valid reverse polish string)
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        String operators = "+-*/";
        Stack<Integer> stack = new Stack();
        for (String token: tokens) {
            // NUMBERS: convert string into integer and push to stack
            if (!operators.contains(token)) { // str.contains(anotherStr)
                stack.push(Integer.valueOf(token));
            // OPS: 1) pop operands 2) calculate 3) store res back to stack
            } else {
                int b = stack.pop(); // b is the number AFTER  the operand
                int a = stack.pop(); // a is the number BEFORE the operand
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}
