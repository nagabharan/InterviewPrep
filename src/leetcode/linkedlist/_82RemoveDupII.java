package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _82RemoveDupII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode fp = fh;

        while (fp.next != null && fp.next.next != null) {
            if (fp.next.val == fp.next.next.val) {
                int dup = fp.next.val;
                while (fp.next != null && fp.next.val == dup)
                    fp.next = fp.next.next;
            } else {
                fp = fp.next;
            }

        }
        return fh.next;
    }
}
