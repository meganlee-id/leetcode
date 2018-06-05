package com.meganlee;


public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // input checking
        if (head == null || n <= 0) {
            return head;
        }
        // count number of nodes in the list
        int num = 1;
        ListNode iter = head;
        while (iter.next != null) { // stop at tail node
            num++;
            iter = iter.next;
        }
        // make the list a cycle, and find new tail
        iter.next = head; // cycle it up
        for (int i = 0; i < num - n % num; i++) {
            iter = iter.next;
        }
        // make cycle back to a list
        head = iter.next;
        iter.next = null;
        return head;
    }
}

