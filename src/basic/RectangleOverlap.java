package basic;

/**
 * Created by nagabharan on 01-Oct-16.
 */
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RectangleOverlap {
    static boolean Overlap(Point x1, Point y1, Point x2, Point y2) {
        if (x1.x > y2.x || x2.x > y1.x)
            return false;
        return !(x1.y < y2.y || x2.y < y1.y);
    }

    public static void main(String[] args) {
        Point l1 = new Point(0, 10), r1 = new Point(10, 0);
        Point l2 = new Point(5, 5), r2 = new Point(15, 0);
        System.out.println(Overlap(l1, r1, l2, r2));
    }
}
