package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _328OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode conn = head.next;

        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            if (t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;

        }
        p1.next = conn;
        return head;
    }
}
