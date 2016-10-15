package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by nagabharan on 15-Oct-16.
 */
public class _295FindMedianStream {
    PriorityQueue<Integer> maxHeap, minHeap;

    public _295FindMedianStream() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        else
            return maxHeap.peek();
    }
}
