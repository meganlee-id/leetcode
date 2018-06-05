
package com.meganlee;

import org.junit.*;

public class RemoveListDupesTest {
    RemoveListDupes solution = new RemoveListDupes();
    private String calculate(int[] array) {
        ListNode list = ListNode.fromArray(array);
        System.out.println("========= BEFORE DEDUP ==========");
        System.out.println(list);
        ListNode res  = solution.deleteDuplicates(list);
        System.out.println("========= AFTER DEDUP ==========");
        System.out.println(res);
        return res == null ? "null" : res.toString();
    }

    int[] x1 = {1,1,2,3,3};
    int[] x2 = {1,1,1,1,1};
    int[] x3 = {1,1,1,2,3,3,3,3,4,4,5};

    @Test
    public void test() {
        Assert.assertEquals("1->2->3->null", calculate(x1));
        Assert.assertEquals("1->null", calculate(x2));
        Assert.assertEquals("1->2->3->4->5->null", calculate(x3));
    }
}
