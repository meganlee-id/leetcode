package com.meganlee;

import java.util.*;

public class RemoveListDupes2 {
    //--------------  Solution 1 ------------------//
    // recursion, use a Seen to facilitate
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> seen = new HashSet();
        return helper(head, seen);
    }
    private ListNode helper(ListNode head, Set<Integer> seen) {
        // base case
        if (head == null) {
            return head;
        }
        // general case
        ListNode dedupedTail = helper(head.next, seen);
        // discuss cases to return new list
        if (seen.contains(head.val)) {
            return (dedupedTail != null && dedupedTail.val == head.val) ? dedupedTail.next : dedupedTail;
        } else {
            head.next = dedupedTail;
            seen.add(head.val);
            return head;
        }
    }

    //--------------  Solution 2 ------------------//
    // two pointers: p1 PREDECESSOR of 1st of dupe seq, p2 last of dupe seq
    // dupes: [p1.next --> p2]
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy; // new tail
        while (p1 != null) {
            // move p2 to the furthest duplicate node
            ListNode p2 = p1.next;
            if (p2 != null) { // make sure to have this!
                while (p2.next != null && p2.next.val == p2.val) {
                    p2 = p2.next;
                }
                // if next seq has dupes
                if (p1.next != p2) {
                    p1.next = p2.next; // skip dupes
                }
            }
            // update p1
            p1 = p1.next;
        }
        return dummy.next;
    }
}