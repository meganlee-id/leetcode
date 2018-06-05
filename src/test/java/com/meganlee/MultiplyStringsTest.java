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
        Assert.assertEquals("72", calculate("8", "9"));
    }

    @Test
    public void testZero1() {
        Assert.assertEquals("0", calculate("0", "123"));
    }

        @Test
    public void testZero2() {
        Assert.assertEquals("0", calculate("0", "000"));
    }

    @Test
    public void testLeadingZero() {
        Assert.assertEquals("121104", calculate("009", "013456"));
    }
}
