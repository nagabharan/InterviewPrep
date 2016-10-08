package leetcode.stackqueue;

import leetcode.linkedlist.ListNode;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class stack {
    ListNode top;

    public ListNode peek() {
        if (top != null) {
            return top;
        }
        return null;
    }

    public ListNode pop() {
        if (top == null) {
            return null;
        } else {
            ListNode temp = new ListNode(top.val);
            top = top.next;
            return temp;
        }
    }

    public void push(ListNode n) {
        if (n != null) {
            n.next = top;
            top = n;
        }
    }
}
