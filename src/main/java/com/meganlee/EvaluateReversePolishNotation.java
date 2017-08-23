package com.meganlee;

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // validate the arguments
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        // use a stack to facilitate calculation
        String operators = "+-*/";
        Stack<Integer> stack = new Stack();
        for (String token: tokens) {
            // numbers: convert string into integer and push to stack
            if (!operators.contains(token)) { // str.contains(anotherStr)
                stack.push(Integer.valueOf(token));
            // operators: pop operands, calculate and store result back to stack
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
