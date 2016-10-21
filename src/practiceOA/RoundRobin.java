package practiceOA;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nagabharan on 21-Oct-16.
 */
class process {
    int arrTime;
    int exeTime;

    process(int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}

public class RoundRobin {
    public float avgTime(int[] at, int[] et, int q) {
        if (at == null || et == null || at.length != et.length) return 0;
        int len = at.length;

        Queue<process> queue = new LinkedList<process>();

        int curtime = 0, waittime = 0;
        int index = 0;

        while (!queue.isEmpty() || index < len) {
            if (!queue.isEmpty()) {
                process cur = queue.poll();
                waittime += curtime - cur.arrTime;
                curtime += Math.min(cur.exeTime, q);
                for (; index < len && at[index] <= curtime; index++)
                    queue.offer(new process(at[index], et[index]));
                if (cur.exeTime > q)
                    queue.offer(new process(curtime, cur.exeTime - q));
            } else {
                queue.offer(new process(at[index], et[index]));
                curtime = at[index++];
            }
        }
        return (float) (waittime / len);
    }
}
