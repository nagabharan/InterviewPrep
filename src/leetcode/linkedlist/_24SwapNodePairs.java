package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _24SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode fp = fh;

        while (fp.next != null && fp.next.next != null) {
            ListNode t1 = fp;
            fp = fp.next;
            t1.next = fp.next;

            ListNode t2 = fp.next.next;
            fp.next.next = fp;
            fp.next = t2;
        }
        return fh.next;
    }
}
