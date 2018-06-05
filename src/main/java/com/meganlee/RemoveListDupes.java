package com.meganlee;


public class RemoveListDupes {
    //------------------- Solution 1 ----------------------//
    // recursion
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null) {
            return head;
        }
        // general case
        head.next = deleteDuplicates2(head.next);
        return (head.next != null && head.val == head.next.val) ? head.next : head;
    }

    //------------------- Solution 2 ----------------------//
    // two pointers: p1 1st of dupe seq, p2 last of dup seq
    // dupes: [p1 --> p2]
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode p1 = head;
        while (p1 != null) {
            // move p2 to end of dupe sequence
            ListNode p2 = p1;
            while (p2.next != null && p2.next.val == p2.val) {
                p2 = p2.next;
            }
            // skip tail for dupe sequence
            p1.next = p2.next;
            // update p1
            p1 = p1.next;
        }
        return head;
    }
}