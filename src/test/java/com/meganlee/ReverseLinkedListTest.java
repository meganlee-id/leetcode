package com.meganlee;

import org.junit.*;

public class ReverseLinkedListTest {
    ReverseLinkedList solution = new ReverseLinkedList();
    private String calculate(int[] array) {
        ListNode list = ListNode.fromArray(array);
        System.out.println("========= BEFORE REVERSE ==========");
        System.out.println(list);
        ListNode res  = solution.reverseList3(list);
        System.out.println("========= AFTER REVERSE ==========");
        System.out.println(res + "\n");
        return res == null ? "null" : res.toString();
    }

    int[] list1 = {};
    int[] list2 = {1};
    int[] list3 = {1, 2, 3, 4, 5};

    @Test
    public void test() {
        Assert.assertEquals("null", calculate(list1));
        Assert.assertEquals("1->null", calculate(list2));
        Assert.assertEquals("5->4->3->2->1->null", calculate(list3));
    }
}
