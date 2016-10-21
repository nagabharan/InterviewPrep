package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class OverlapRect {
    public static boolean oR(Point l1, Point r1, Point l2, Point r2) {
        if (l1.x > r2.x || l2.x > r1.x)
            return false;
        return !(l1.y < r2.y || l2.y < r1.y);
    }
}
