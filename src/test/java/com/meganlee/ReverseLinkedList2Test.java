package com.meganlee;

import org.junit.*;

public class ReverseLinkedList2Test {
    ReverseLinkedList2 solution = new ReverseLinkedList2();
    private String calculate(int[] array, int m, int n) {
        ListNode list = ListNode.fromArray(array);
        System.out.println("========= BEFORE REVERSE ==========");
        System.out.println("reverse between: [" + m + ", " + n + "]");        
        System.out.println(list);
        ListNode res  = solution.reverseBetween(list, m, n);
        System.out.println("========= AFTER REVERSE ==========");
        System.out.println(res + "\n");
        return res == null ? "null" : res.toString();
    }

    int[] list = {1, 2, 3, 4, 5};

    @Test
    public void test() {
        Assert.assertEquals("5->4->3->2->1->null", calculate(list, 1, 5));
        Assert.assertEquals("1->4->3->2->5->null", calculate(list, 2, 4));
    }
}
