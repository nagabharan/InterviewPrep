package leetcode.trees;

import java.util.*;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _103BTZigZagSpiralOrder {
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(root, res, 1);
        return res;
    }

    static void zigzagLevelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null)
            return;

        if (res.size() < level) {
            ArrayList<Integer> levelList = new ArrayList<>();
            if (level % 2 == 1) {
                levelList.add(root.val);
            } else {
                levelList.add(0, root.val);
            }
            res.add(levelList);
        } else {
            if (level % 2 == 1) {
                res.get(level - 1).add(root.val);
            } else {
                res.get(level - 1).add(0, root.val);
            }
        }
        zigzagLevelOrder(root.left, res, level + 1);
        zigzagLevelOrder(root.right, res, level + 1);
    }

    static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;

        q.offer(root);

        while (!q.isEmpty()) {
            int s = q.size();
            level++;
            ArrayList<Integer> levelList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < s; i++) {
                TreeNode t = q.poll();
                if (level % 2 == 1) {
                    levelList.add(t.val);
                } else {
                    stack.push(t.val);
                }
                if (t.left != null)
                    q.offer(t.left);

                if (t.right != null)
                    q.offer(t.right);

            }
            if (level % 2 == 0) {
                while (!stack.isEmpty())
                    levelList.add(stack.pop());
            }
            res.add(levelList);
        }
        return res;
    }
}
