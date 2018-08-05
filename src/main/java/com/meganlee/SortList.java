package com.meganlee;

import java.util.*;

public class SortList {
    //--------------- Solution 1 ----------------//
    // recursive merge sort O(NlogN)
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
        head  = sortList(head);   // recursive call
        head2 = sortList(head2);  // recursive call
        // step 3: merge two lists
        return merge(head, head2);
    }

    // findMiddle has to divide list into SMALLER SIZE!!!
    // otherwise will STACKOVERFLOW!
    private ListNode findMiddle(ListNode head) {
        // assume at least 2 nodes
        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }
    // NOTE: do NOT use while (runner != null && runner.next != null)
    // for 3 nodes. that won't divide problem into SMALLER size!!


    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
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
