package leetcode.FAQ;

import leetcode.linkedlist.ListNode;

import java.util.Random;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _382LLRandomNode {

    Random r = null;
    ListNode h = null;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public _382LLRandomNode(ListNode head) {
        r = new Random();
        h = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int c = 1;
        int res = 0;
        ListNode p = h;
        while (p != null) {
            if (r.nextInt(c) == 0)
                res = p.val;
            c++;
            p = p.next;
        }
        return res;
    }

}
