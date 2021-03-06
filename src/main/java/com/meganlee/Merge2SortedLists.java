package com.meganlee;

public class Merge2SortedLists {
    //-------- Solution 1 ---------//
    // recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Base case: either of 2 lists is null
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // General case: neither is null
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    //-------- Solution 2 ---------//
    // Iterative
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        return dummy.next; 
    }
}