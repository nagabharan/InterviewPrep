package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _83RemoveDupSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fp = head;

        while (fp.next != null) {
            if (fp.val == fp.next.val)
                fp.next = fp.next.next;
            else
                fp = fp.next;
        }
        return head;
    }
}
