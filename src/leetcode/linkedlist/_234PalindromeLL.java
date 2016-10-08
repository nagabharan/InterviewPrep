package leetcode.linkedlist;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _234PalindromeLL {
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fp = head, sp = head;

        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }

        ListNode newHead = sp.next;
        sp.next = null;

        ListNode p1 = newHead;
        ListNode p2 = p1.next;

        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        newHead.next = null;

        ListNode p = p2 == null ? p1 : p2;
        ListNode q = head;

        while (p != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }

        return true;
    }
}
