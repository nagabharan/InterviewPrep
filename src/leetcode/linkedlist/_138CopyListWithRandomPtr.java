package leetcode.linkedlist;

import java.util.HashMap;

/**
 * Created by nagabharan on 11-Oct-16.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class _138CopyListWithRandomPtr {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode nh = new RandomListNode(head.label);
        RandomListNode p = head, q = nh;

        map.put(p, q);
        p = p.next;

        while (p != null) {
            RandomListNode t = new RandomListNode(p.label);
            map.put(p, t);
            q.next = t;
            q = t;
            p = p.next;
        }
        p = head;
        q = nh;

        while (p != null) {
            if (p.random != null)
                q.random = map.get(p.random);
            else
                q.random = null;
            p = p.next;
            q = q.next;
        }

        return nh;
    }
}
