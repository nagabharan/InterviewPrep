package leetcode.linkedlist;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _25ReverseNodeK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode pre = fh;

        int i = 0;
        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                pre = rev(pre, p.next);
                p = pre.next;
            } else {
                p = p.next;
            }
        }
        return fh.next;
    }

    public ListNode rev(ListNode pre, ListNode next) {
        ListNode l = pre.next;
        ListNode curr = l.next;

        while (curr != next) {
            l.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = l.next;
        }

        return l;
    }
}
