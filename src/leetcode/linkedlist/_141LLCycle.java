package leetcode.linkedlist;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _141LLCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fp = head, sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp)
                return true;
        }
        return false;
    }
}
