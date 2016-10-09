package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || k > Integer.MAX_VALUE)
            return head;

        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }

        if (k > length)
            k = k % length;

        ListNode f = head, s = head;

        while (k > 0) {
            k--;
            f = f.next;
            if (f == null)
                f = head;
        }
        if (f == null || s == f)
            return head;
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        ListNode nh = s.next;
        s.next = null;
        f.next = head;
        return nh;
    }
}
