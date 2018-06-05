package com.meganlee;

import org.junit.*;

public class ReorderListTest {
    ReorderList solution = new ReorderList();
    private String calculate(int[] array) {
        ListNode l = ListNode.fromArray(array);
        System.out.println("\n========== Input ===========");
        System.out.println(l);
        solution.reorderList2(l);
        System.out.println("========== Reorder ===========");
        System.out.println(l);
        return l == null ? "null" : l.toString();
    }

    int[] x1 = {1};
    int[] x2 = {1, 2};
    int[] x3 = {1, 2, 3, 4, 5};
    int[] x4 = {1, 2, 3, 4, 5, 6};

    @Test
    public void test() {
        Assert.assertEquals("1->null", calculate(x1));
        Assert.assertEquals("1->2->null", calculate(x2));
        Assert.assertEquals("1->5->2->4->3->null", calculate(x3));
        Assert.assertEquals("1->6->2->5->3->4->null", calculate(x4));
    }
}
