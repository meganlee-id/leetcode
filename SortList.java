
public class SortList {
    //--------------- Solution 1 ----------------//
    // partition sort - time limits exceed
    // worst case O(N^2)
    public ListNode sortList(ListNode head) {
        return partitionSort(head)[0];
    }

    // return {head, tail} of the sorted list
    private ListNode[] partitionSort(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            ListNode[] res = {head, head};
            return res;
        }

        // partition around the first element
        ListNode dummy1 = new ListNode(0), tail1 = dummy1;
        ListNode dummy2 = new ListNode(0), tail2 = dummy2;
        ListNode partitioner = head;
        head = head.next;
        while (head != null) {
            if (head.val < partitioner.val) {
                tail1.next = head;
                tail1 = tail1.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
            }
            head = head.next;
        }
        tail1.next = null;  // don't forget to set tail.next to null
        tail2.next = null;

        // recursively sort on both sides
        ListNode[] pair1 = partitionSort(dummy1.next);
        ListNode[] pair2 = partitionSort(dummy2.next);
        ListNode[] res = new ListNode[2];
        if (pair1[0] != null) {
            pair1[1].next = partitioner;
        }
        partitioner.next = pair2[0];
        res[0] = (pair1[0] != null) ? pair1[0] : partitioner;
        res[1] = (pair2[1] != null) ? pair2[1] : partitioner;
        return res;
    }


    //--------------- Solution 2 ----------------//
    // merge sort O(NlogN)
    public ListNode sortList2(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // step 1: find middle
        ListNode tail1 = findMiddle(head);
        ListNode head2 = tail1.next;
        tail1.next = null;

        // step 2: divdie and conquer
        head = sortList(head);
        head2 = sortList(head2);

        // step 3: merge two lists
        return merge(head, head2);
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



    //////////////////  TEST  ///////////////////
    public static void test(SortList solution, int[] x) {
        ListNode l = new ListNode(x);
        System.out.println(solution.sortList(l));
    }

    public static void main(String[] args) {
        SortList solution = new SortList();
        int[] x1 = {1};
        int[] x2 = {3, 2, 1};
        int[] x3 = {1, 1, 2, 3, 1, 5, 4, 5};
        test(solution, x1);
        test(solution, x2);
        test(solution, x3);
    }
}

