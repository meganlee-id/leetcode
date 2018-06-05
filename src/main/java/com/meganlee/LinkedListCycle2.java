package com.meganlee;

import java.util.*;

public class LinkedListCycle2 {
    //------------ Solution 1 ---------------//
    // HashSet, S = O(N)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet();
        ListNode node = head;
        while (node != null) { 
            if (!visited.add(node)) { // Set.add() returns boolean
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //------------ Solution 2 ---------------//
    // runner + walker, S = O(1)
    public ListNode detectCycle2(ListNode head) {
        ListNode runner = head, walker = head;
        while (runner != null && runner.next != null) { // check runner != null first
            // step 1: find meet point
            runner = runner.next.next;
            walker = walker.next;
            // step 2: if meet point find, another walker from start point
            if (runner == walker){
                ListNode walker2 = head; 
                while (walker2 != walker) {
                    walker = walker.next;
                    walker2 = walker2.next;
                }
                return walker;
            }
        }
        return null; // if there is not cycle, return null
    }
}
