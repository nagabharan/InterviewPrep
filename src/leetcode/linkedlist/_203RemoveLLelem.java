package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _203RemoveLLelem {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode fp = fh;

        while (fp.next != null) {
            if (fp.next.val == val) {
                fp.next = fp.next.next;
            } else {
                fp = fp.next;
            }
        }
        return fh.next;
    }
}
