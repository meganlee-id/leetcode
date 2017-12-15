package com.meganlee;

import org.junit.*;

public class MultiplyStringsTest {
    MultiplyStrings solution = new MultiplyStrings();
    private String calculate(String num1, String num2) {
        String prod = solution.multiply(num1, num2);
        System.out.println(String.format("\n %s X %s = %s \n", num1, num2, prod));
        return prod;
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(calculate("8", "9"), "72");
    }

    @Test
    public void testZero1() {
        Assert.assertEquals(calculate("0", "123"), "0");
    }

        @Test
    public void testZero2() {
        Assert.assertEquals(calculate("0", "000"), "0");
    }

    @Test
    public void testLeadingZero() {
        Assert.assertEquals(calculate("009", "013456"), "121104");
    }
}
