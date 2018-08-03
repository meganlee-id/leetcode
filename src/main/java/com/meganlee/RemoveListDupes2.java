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
    // two pointers: "pre" tail of previoud gropu, "iter" iterator travel within dupes
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode iter = pre.next;
        // each time iter will be 1) null 2) start from 1st value travel to end of duplicates
        while (iter != null) {
            // move iter to end of dupes
            while (iter.next != null && iter.val == iter.next.val) {
                iter = iter.next;
            }
            // if there iter is null || only one value
            if (pre.next == iter) {
                pre = pre.next;      // pre move to next group
            // multiple nodes
            } else {
                pre.next = iter.next; // pre stays the same
            }
            iter = iter.next;
        }
        return dummyHead.next;
    }
}