package practiceOA;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nagabharan on 21-Oct-16.
 */
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FindKNearestPoint {
    public Point[] kNear(Point[] arr, final Point o, int k) {
        Point[] res = new Point[k];
        int c = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k,
                new Comparator<Point>() {
                    @Override
                    public int compare(Point o1, Point o2) {
                        return (int) (getDist(o1, o) - getDist(o2, o));
                    }
                });

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty()) {
            res[c++] = pq.poll();
        }

        return res;
    }

    public double getDist(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
