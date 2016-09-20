package leetcode;

/**
 * Created by nagabharan on 19-Sep-16.
 */

public class _24SwapNodesPairs {

    static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;
        else {
            // swap the two
            ListNode newHead = head.next;
            head.next = swapPairs(head.next.next);
            newHead.next = head;
            return newHead;
        }

        /*
        if (head == null || head.next == null)
            return null;

        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode fakeheadptr = fakehead;

        while (fakeheadptr.next != null && fakeheadptr.next.next != null) {
            ListNode t1 = fakeheadptr;
            fakeheadptr = fakeheadptr.next;
            t1.next = fakeheadptr.next;

            ListNode t2 = fakeheadptr.next.next;
            fakeheadptr.next.next = fakeheadptr;
            fakeheadptr.next = t2;
        }

        return fakehead.next;*/
    }
}
