package leetcode.linkedlist;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _19RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fp = head, sp = head;

        for (int i = 0; i < n; i++)
            fp = fp.next;

        if (fp == null) {
            head = head.next;
            return head;
        }

        while (fp.next != null) {
            fp = fp.next;
            sp = sp.next;
        }

        sp.next = sp.next.next;

        return head;
    }
}
