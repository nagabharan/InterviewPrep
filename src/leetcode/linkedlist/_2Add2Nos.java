package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _2Add2Nos {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode p1 = l1, p2 = l2;
        ListNode fh = new ListNode(0);
        ListNode p = fh;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;
        }
        if (carry == 1)
            p.next = new ListNode(1);

        return fh.next;
    }
}
