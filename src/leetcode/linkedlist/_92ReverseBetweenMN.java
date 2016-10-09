package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _92ReverseBetweenMN {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;

        int i = 0;
        ListNode p = head;

        ListNode prev = null, p1 = new ListNode(0), p2 = new ListNode(0);

        while (p != null) {
            i++;
            if (i == m - 1)
                prev = p;
            if (i == m)
                p1.next = p;
            if (i == n) {
                p2.next = p.next;
                p.next = null;
            }
            p = p.next;
        }

        if (p1.next == null)
            return head;

        ListNode a = p1.next;
        ListNode b = a.next;
        a.next = p2.next;

        while (a != null && b != null) {
            ListNode t = b.next;
            b.next = a;
            a = b;
            b = t;
        }

        if (prev != null)
            prev.next = a;
        else
            return a;

        return head;

    }
}
