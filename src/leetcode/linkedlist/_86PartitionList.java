package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _86PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = new ListNode(0);
        ListNode q = new ListNode(0);
        p1.next = head;

        ListNode p = head, prev = p1, p2 = q;

        while (p != null) {
            if (p.val < x) {
                p = p.next;
                prev = prev.next;
            } else {
                p2.next = p;
                prev.next = p.next;
                p = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        prev.next = q.next;
        return p1.next;
    }
}
