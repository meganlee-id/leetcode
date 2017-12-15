package com.meganlee;

import org.junit.*;

public class AddTwoNumbersTest {
    AddTwoNumbers solution = new AddTwoNumbers();
    private String calculate(int[] arr1, int[] arr2) {
        // calculate sum
        ListNode l1 = ListNode.fromArray(arr1);
        ListNode l2 = ListNode.fromArray(arr2);
        ListNode sumNode = solution.addTwoNumbers(l1, l2);
        // print the addition of two numbers
        System.out.println("\n  " + l1);
        System.out.println("+ " + l2);
        System.out.println("  " + sumNode);
        System.out.println("----------------------------\n");
        // return sum for comparison
        return sumNode.toString();
    }

    int[] arr1 = {6,1,3};
    int[] arr2 = {2,9,7};
    int[] arr3 = {2};
    int[] arr4 = {9,9,9};

    @Test
    public void test() {
        Assert.assertEquals(calculate(arr1, arr2), "8->0->1->1->null");
        Assert.assertEquals(calculate(arr1, arr3), "8->1->3->null");
        Assert.assertEquals(calculate(arr3, arr4), "1->0->0->1->null");
    }
}