package com.meganlee;

import java.util.*;

public class CopyListRandomPointer {
    //------------------- Solution 1 --------------------------//
    // O(n) time, O(n) space: Hashmap<old -> new>
    public RandomListNode copyRandomList2(RandomListNode head) {
        // if head == null, the following code works well
        // 1st time loop: create map{old -> new}
        Map<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode iter = head;
        while (iter != null) {
            map.put(iter, new RandomListNode(iter.label));
            iter = iter.next;
        }
        // 2nd time loop: fill in next and random for new nodes
        iter = head;
        while (iter != null) {
            RandomListNode iterClone = map.get(iter);
            iterClone.next = map.get(iter.next);     // map.get(key)  returns value (if key exist)
            iterClone.random = map.get(iter.random); // map.get(null) returns null  (if key no there)
            iter = iter.next;
        }
        // return the new head
        return map.get(head);
    }

    //------------------- Solution 2   --------------------------//
    // O(n) time, O(1) space: old new INTERLEAVES
    public RandomListNode copyRandomList(RandomListNode head) {
        // if head == null, the following code works well
        // step 1: interleave old and new
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode iterClone = new RandomListNode(iter.label);
            iterClone.next = iter.next;
            iter.next = iterClone;
            iter = iter.next.next; // jump 2 nodes
        }

        // step 2: correct the new node's random link
        iter = head;
        while (iter != null) {
            if (iter.random != null) {  // REMEMBER FOR checking!!
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next; // jump 2 nodes
        }

        // step 3: separate two list
        RandomListNode newHead = (head == null) ? null : head.next; // record it for return, consider null
        iter = head;
        while (iter != null && iter.next != null) {         // loop enter condition: iter != null
            // 0th,2nd,.. enters here to correct old next   // loop end   condition: iter.next != null
            // 1st,3rd... enters here to correct new next
            RandomListNode afterIter = iter.next;    
            iter.next = iter.next.next;
            iter = afterIter;  // jump 1 node
        }
        return newHead;
    }
}

