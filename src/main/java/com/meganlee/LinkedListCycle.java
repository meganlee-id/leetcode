package com.meganlee;

import java.util.*;

public class LinkedListCycle {
    //------------ Solution 1 ---------------//
    // HashSet, S = O(N)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet();
        ListNode node = head;
        while (node != null) { 
            if (!visited.add(node)) { // Set.add() returns boolean
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //------------------ Solution 2 ------------------//
    // Two-pointers (walker & runner)
    // Time: O(n)  Space: O(1)
    public boolean hasCycle2(ListNode head) {
        ListNode runner = head, walker = head;
        while (runner != null && runner.next != null) { // check runner != null first
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                return true;
            }
        }
        return false;
    }
}
