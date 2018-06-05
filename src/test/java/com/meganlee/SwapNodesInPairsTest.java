package com.meganlee;

import org.junit.*;

public class SwapNodesInPairsTest {
    SwapNodesInPairs solution = new SwapNodesInPairs();
    private String calculate(int[] array) {
        ListNode list = ListNode.fromArray(array);
        System.out.println("========= BEFORE SWAP ==========");
        System.out.println(list);
        ListNode res  = solution.swapPairs(list);
        System.out.println("========= AFTER SWAP ==========");
        System.out.println(res + "\n");
        return res == null ? "null" : res.toString();
    }

    int[] list = {1, 2, 3, 4, 5};

    @Test
    public void test() {
        Assert.assertEquals("2->1->4->3->5->null", calculate(list));
    }
}
