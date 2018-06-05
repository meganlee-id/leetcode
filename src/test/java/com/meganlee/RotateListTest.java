   package com.meganlee;

import java.util.*;
import org.junit.*;

public class RotateListTest {
    RotateList solution = new RotateList();
    private String calculate(int[] arr, int k) {
        ListNode n = ListNode.fromArray(arr);
        ListNode res = solution.rotateRight(n, k);
        System.out.println("======= input ======");
        System.out.println(n);
        System.out.println(k);
        System.out.println("======= output ======");
        System.out.println(res + "\n");
        return res == null ? "null" : res.toString();
    }

    int[] x = {1, 2, 3, 4, 5};

    @Test
    public void test() {
        // k <= 0
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, -1));
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, 0));
        // k = 1
        Assert.assertEquals("5->1->2->3->4->null", calculate(x, 1));
        // k < len
        Assert.assertEquals("3->4->5->1->2->null", calculate(x, 3));
        // k == len
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, 5));
        // k > len
        Assert.assertEquals("3->4->5->1->2->null", calculate(x, 8));
    }
} 