package leetcode.trees;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _117RightPtrBT {
    void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode cur = null,
                lastcur = null,
                curhead = null,
                lasthead = root;

        while (lasthead != null) {
            lastcur = lasthead;
            while (lastcur != null) {

                if (lastcur.left != null) {
                    if (curhead == null) {
                        curhead = lastcur.left;
                        cur = lastcur.left;
                    } else {
                        cur.next = lastcur.left;
                        cur = cur.next;
                    }
                }

                if (lastcur.right != null) {
                    if (curhead == null) {
                        curhead = lastcur.right;
                        cur = lastcur.right;
                    } else {
                        cur.next = lastcur.right;
                        cur = cur.next;
                    }
                }
                lastcur = lastcur.next;
            }

            lasthead = curhead;
            curhead = null;
        }
    }
}
