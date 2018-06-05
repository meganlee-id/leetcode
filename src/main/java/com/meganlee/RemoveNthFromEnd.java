package com.meganlee;


public class RemoveNthFromEnd {
    //------------------- Solution 1 --------------------//
    // 1-pass, 2-pointers, same speed, one is k steps ahead of the other
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // input validation
        if (n <= 0 || head == null) {
            return head;
        }
        // dummyHead to get the the node PREVIOUS to the target node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        // move fast pointer n+1 steps into the list
        while (fast != null && n >= 0) { // n >= 0, move n+1 steps
            fast = fast.next;
            n--;
        }
        // check invalidity, invalid n: n > len
        if (n >= 0) {
            return head;
        }
        // move slow/fast pointer until fast points to null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // delete
        slow.next = slow.next.next;
        return dummy.next;
    }

    //------------------- Solution 2 --------------------//
    // 2-pass, first count len, then move to the node PREVIOUS to the node to be delete
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // input validation
        if (n <= 0 || head == null) {
            return head;
        }
        // create dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;
        // count the len
        int len = 0;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        // check n's validation
        if (n <= 0 || n > len) {
            return head;
        }
        // move to the node previous to the target node
        iter = dummy; // reset iter to dummy
        int steps = len - n;
        while (steps > 0) {
            steps--;
            iter = iter.next;
        }
        // delete the node
        iter.next = iter.next.next;
        return dummy.next;
    }
}

