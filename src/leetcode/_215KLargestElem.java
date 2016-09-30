package leetcode;

/**
 * Created by nagabharan on 29-Sep-16.
 */
public class _215KLargestElem {
    /*static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for(int i:nums){
            q.offer(i);
            if(q.size()>k)
                q.poll();
        }
        return q.peek();
    }*/

    static int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums.length == 0)
            return 0;
        return getK(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    static int getK(int k, int[] nums, int b, int e) {
        int piv = nums[e];
        int l = b;
        int r = e;

        while (true) {
            while (nums[l] < piv && l < r)
                l++;
            while (nums[r] >= piv && l < r)
                r--;
            if (l == r)
                break;
            swap(nums, l, r);
        }
        swap(nums, l, e);

        if (k == l + 1)
            return piv;
        else if (k < l + 1)
            return getK(k, nums, b, l - 1);
        else
            return getK(k, nums, l + 1, e);
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
