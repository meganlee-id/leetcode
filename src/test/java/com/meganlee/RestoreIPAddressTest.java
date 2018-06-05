package com.meganlee;

import java.util.*;
import org.junit.*;

public class RestoreIPAddressTest {
    RestoreIPAddress solution = new RestoreIPAddress();
    private String calculate(String s) {
        List<String> res = solution.restoreIpAddresses(s);
        System.out.println(s);
        for (String ip: res)
            System.out.println(ip);
        System.out.println();
        Collections.sort(res);
        return res.toString();
    }

    String s1 = "25525511135";
    String s2 = "348795";
    String s3 = "0000";
    String s4 = "002002011";

    @Test
    public void test() {
        Assert.assertEquals(
            "[255.255.11.135, 255.255.111.35]",
            calculate(s1)
        );
        Assert.assertEquals(
            "[3.4.87.95, 3.48.7.95, 3.48.79.5, 34.8.7.95, 34.8.79.5, 34.87.9.5]",
            calculate(s2)
        );
    }

    @Test
    public void testZero() {
        Assert.assertEquals(
            "[0.0.0.0]",
            calculate(s3)
        );
        Assert.assertEquals(
            "[]",
            calculate(s4)
        );
    }
}
