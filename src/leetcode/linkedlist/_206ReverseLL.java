package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _206ReverseLL {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        head.next = null;

        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }
}
