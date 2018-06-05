package com.meganlee;

import java.util.*;

public class MinStack {
    //--------------- Solution 1 ------------------//
    // 2 parallel stacks with same size
    //-- there is a min val corresponding to each elements
    //-- not practical using a single min variable. e.g |3 | 1 | 2 | 1 | 4 how to deal with 1
    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();
    
    public void push(int x) {
        stack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();       
    }

    public int getMin() {
        return minStack.peek();
    }

    //--------------- Solution 2 ------------------//
    // we could only use 1 stack + a min variable
    // each time we encouter a new min, we just push the old min before the new value
    Stack<Integer> s = new Stack();
    int min = Integer.MAX_VALUE;
    public void push2(int x) {
        // if x is a mew min
        if(x <= min){    // do not use "x < min" , when x == min, also need to push the old min
            s.push(min); // push the old min
            min = x;     // update the min variable to be newly added x
        }
        s.push(x);       // push value x
    }

    public void pop2() {
        int val = s.pop();  // first pop the value out
        if (val == min)  {  // if the popped value is the current min
            min = s.pop();  // restore the old min
        }
    }

    public int top2() {
        return s.peek();
    }

    public int getMin2() {
        return min;
    }
}