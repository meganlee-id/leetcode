
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;  // insert node into the sorted list (dummyHead list)
        while (cur != null) {
            ListNode pre = dummyHead;
            // step 1: find the predecessor
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // step 2: insert node in
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            // step 3: update cur
            cur = next;
        }
        return dummyHead.next;
    }

    //////////////////  TEST  ///////////////////
    public static void test(InsertionSortList solution, int[] x) {
        ListNode l = new ListNode(x);
        System.out.println(solution.insertionSortList(l));
    }

    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();
        int[] x1 = {1};
        int[] x2 = {3, 2, 1};
        int[] x3 = {1, 1, 2, 3, 1, 5, 4, 5};
        int[] x4 = {1, 3, 8, 5, 2, 6, 7, 4};

        test(solution, x1);
        test(solution, x2);
        test(solution, x3);
        test(solution, x4);
    }
}