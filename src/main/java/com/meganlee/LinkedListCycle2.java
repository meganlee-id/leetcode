package com.meganlee;

import java.util.*;

public class LinkedListCycle2 {
    //------------ Solution 1 ---------------//
    // HashSet, S = O(N)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet();
        ListNode node = head;
        while (node != null) { 
            if (!visited.add(node)) { // set.add() returns boolean
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //------------ Solution 2 ---------------//
    // runner + walker, S = O(1)
    public ListNode detectCycle2(ListNode head) {
        ListNode walker = head, runner = head;
        // runner.next.next is valid
        while (runner != null && runner.next != null) { // check runner != null first
            // move one step
            runner = runner.next.next;
            walker = walker.next;
            // cycle detecteds
            if (runner == walker){
                ListNode walker2 = head; 
                while (walker2 != walker) {
                    walker = walker.next;
                    walker2 = walker2.next;
                }
                return walker;
            }
        }
        return null;
    }
}
