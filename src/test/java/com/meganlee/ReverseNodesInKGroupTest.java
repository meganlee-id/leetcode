package com.meganlee;

import org.junit.*;

public class ReverseNodesInKGroupTest {
    ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
    private String calculate(int[] array, int k) {
        ListNode list = ListNode.fromArray(array);
        System.out.println("========= BEFORE  ==========");
        System.out.println("k=" + k);
        System.out.println(list);        
        ListNode res  = solution.reverseKGroup(list, k);
        System.out.println("========= AFTER  ==========");
        System.out.println(res);
        return res == null ? "null" : res.toString();
    }

    int[] x = {1, 2, 3, 4, 5};

    @Test
    public void test() {
        // k <= 1 || k > len, no change
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, -1));
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, 0));
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, 1));
        Assert.assertEquals("1->2->3->4->5->null", calculate(x, 7));
        // valid k
        Assert.assertEquals("3->2->1->4->5->null", calculate(x, 3));
        // k == len of list
        Assert.assertEquals("5->4->3->2->1->null", calculate(x, 5));
    }
}
