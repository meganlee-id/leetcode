package com.meganlee;

import org.junit.*;

public class InsertionSortListTest {
    InsertionSortList solution = new InsertionSortList();
    private String calculate(int[] array) {
        ListNode l = ListNode.fromArray(array);
        System.out.println("\n========== Input ===========");
        System.out.println(l);
        ListNode res = solution.insertionSortList(l);
        System.out.println("========== Sorted ===========");
        System.out.println(res);
        return res == null ? "null" : res.toString();
    }

    int[] x1 = {1};
    int[] x2 = {3, 2, 1};
    int[] x3 = {1, 1, 2, 3, 1, 5, 4, 5};
    int[] x4 = {1, 3, 8, 5, 2, 6, 7, 4};

    @Test
    public void test() {
        Assert.assertEquals("1->null", calculate(x1));
        Assert.assertEquals("1->2->3->null", calculate(x2));
        Assert.assertEquals("1->1->1->2->3->4->5->5->null", calculate(x3));
        Assert.assertEquals("1->2->3->4->5->6->7->8->null", calculate(x4));
    }
}
