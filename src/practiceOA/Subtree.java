package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
class TN {
    int val;
    TN left, right;

    TN(int x) {
        val = x;
    }
}

public class Subtree {
    public static boolean isSubtree(TN t1, TN t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return isSameTree(t1, t2) || isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    private static boolean isSameTree(TN t1, TN t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
