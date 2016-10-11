package leetcode.linkedlist;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode sec = s.next;
        s.next = null;

        sec = rev(sec);

        ListNode p1 = head;
        ListNode p2 = sec;

        while (p2 != null) {
            ListNode t1 = p1.next, t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        }
    }

    public ListNode rev(ListNode h) {
        if (h == null)
            return h;

        ListNode p = h;
        ListNode c = p.next;

        while (c != null) {
            ListNode t = c.next;
            c.next = p;
            p = c;
            c = t;
        }

        return h;
    }
}
