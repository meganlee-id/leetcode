package com.meganlee;

import org.junit.*;

public class PartitionListTest {
    PartitionList solution = new PartitionList();
    private String calculate(int[] array, int pivot) {
        ListNode l = ListNode.fromArray(array);
        System.out.println("\n========== Input ===========");
        System.out.println(l);
        System.out.println("pivot = " + pivot);
        ListNode res = solution.partition(l, pivot);
        System.out.println("========== Sorted ===========");
        System.out.println(res);
        return res == null ? "null" : res.toString();
    }

    int[] x = {1, 2, 3, 4, 5, 2, 1, 3};

    @Test
    public void test() {
        Assert.assertEquals("1->2->2->1->3->4->5->3->null", calculate(x, 3));
    }
}
