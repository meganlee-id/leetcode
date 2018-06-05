package com.meganlee;

import org.junit.*;

public class RemoveListDupes2Test {
    RemoveListDupes2 solution = new RemoveListDupes2();
    private String calculate(int[] array) {
        ListNode list = ListNode.fromArray(array);
        System.out.println("========= BEFORE DEDUP ==========");
        System.out.println(list);
        ListNode res  = solution.deleteDuplicates(list);
        System.out.println("========= AFTER DEDUP ==========");
        System.out.println(res);
        return res == null ? "null" : res.toString();
    }

    int[] x = {1,2,2,3};

    @Test
    public void test() {
        Assert.assertEquals("1->3->null", calculate(x));
    }
}
