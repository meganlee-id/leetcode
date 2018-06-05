package com.meganlee;

import java.util.*;
import org.junit.*;

public class GenerateParensTest {
    GenerateParens solution = new GenerateParens();
    private String calculate(int n) {
        System.out.println("\n------ n = " + n + " -------");
        List<String> res = solution.generateParenthesis(n);
        PrettyPrinter.print1DStrList(res);
        return PrettyPrinter.str1DStrList(res);
    }

    @Test
    public void testMinusOne() {
        Assert.assertEquals("[]", calculate(-1));
    }

    @Test
    public void testOne() {
        Assert.assertEquals("[()]", calculate(1));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals("[(()), ()()]", calculate(2));
    }

    @Test
    public void testThree() {
        Assert.assertEquals("[((())), (()()), (())(), ()(()), ()()()]", calculate(3));
    }

    @Test
    public void testFour() {
        Assert.assertEquals("[(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]", calculate(4));
    }
}
