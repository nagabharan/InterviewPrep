package leetcode.linkedlist;

/**
 * Created by nagabharan on 08-Oct-16.
 */
public class _237DeleteNodeLL {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
