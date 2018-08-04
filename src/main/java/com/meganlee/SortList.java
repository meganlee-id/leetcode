package com.meganlee;

import java.util.*;

public class SortList {
    //--------------- Solution 1 ----------------//
    // merge sort O(NlogN)
    public ListNode sortList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // step 1: find middle, divide into 2 list
        ListNode tail1 = findMiddle(head);
        ListNode head2 = tail1.next;
        tail1.next = null; // remember to disconnect the two
        // step 2: divdie and conquer
        ListNode head1 = sortList(head);   // recursive call
        head2 = sortList(head2);  // recursive call
        // step 3: merge two lists
        return merge(head1, head2);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }

    private ListNode merge(ListNode a, ListNode b) {
        // use a dummy node, a and b might both be null
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        // don't forget to handle leftovers
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    //--------------- Solution 2 ----------------//
    // Arrays.sort(), modify the values
    public ListNode sortList2(ListNode head) {
        // input validation
        if (head == null || head.next == null) {
            return head;
        }
        // put all vals in an ArrayList
        List<Integer> vals = new ArrayList();
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(vals);
        // update original list's vals
        cur = head;
        for (int val: vals) {
            cur.val = val;
            cur = cur.next;
        }
        return head;
    }
}
