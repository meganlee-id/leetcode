package com.meganlee;


public class RotateList {
    //------ solution 1 make it a cycle and count --------//
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

    //-------- solution 2: use k % n, k might be larger than n ---------//
    public ListNode rotateRight2(ListNode head, int k) {
        // input check
        if (head == null || head.next == null || k <= 0) { // return if it's one node
            return head;
        }
        // use a dummyHead to faciliate the code implementation
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode oldTail = dummy, newTail = dummy;
        // get size of the list and place oldTail poinster at correct position
        int cnt = 0;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            cnt++;
        }
        // get size of moving pos and place newTail poinster at correct position
        k = cnt - k % cnt;
        if (k == cnt) {
            return dummy.next;
        } else {
            while (k-- > 0) {  // d  -> 1 ->2->3n->4->5->NULL, k = 0
                newTail = newTail.next;
            }
        }
        // reconnect
        oldTail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
}

