package practiceOA;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class ShortestJobFirst {
    public float sjf(int[] at, int[] et) {
        if (at == null || et == null || at.length != et.length) return 0;
        int wt = 0, ct = 0, index = 0;
        int len = at.length;

        PriorityQueue<process> pq = new PriorityQueue<process>(at.length, new Comparator<process>() {
            @Override
            public int compare(process o1, process o2) {
                if (o1.exeTime == o2.exeTime)
                    return o1.arrTime - o2.arrTime;
                return o1.exeTime - o2.exeTime;
            }
        });

        while (!pq.isEmpty() || index < len) {
            if (!pq.isEmpty()) {
                process cur = pq.poll();
                wt += ct - cur.arrTime;
                ct += cur.exeTime;
                while (index < len && ct >= at[index])
                    pq.offer(new process(at[index], et[index++]));
            } else {
                pq.offer(new process(at[index], et[index]));
                ct = at[index++];
            }
        }
        return (float) wt / len;

    }
}
