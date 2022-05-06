package com.meganlee;

import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // input check
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        // use a stack to do the calcuation
        Stack<Integer> stack = new Stack();
        Set<String> operators = new HashSet(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer b = stack.pop(); // b is popped first
                Integer a = stack.pop(); // a is popped second
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                int val = Integer.parseInt(token);
                stack.push(val);
            }
        }
        return stack.pop();
    }
}
