package leetcode.general;

import java.util.Arrays;

/**
 * Created by nagabharan on 29-Sep-16.
 */
public class _189RotateArray {
    /*static void rotate(int[] nums, int k) {
        if (nums == null || k < 0)
            return;
        int[] res = new int[nums.length];

        for (int i = 0; i < k; i++) {
            res[i] = nums[nums.length - k + i];
        }
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            res[i] = nums[j];
            j++;
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }*/

    /*static void rotate(int[] nums, int k) {
        if (nums == null || k < 0)
            return;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
    }*/

    static void rotate(int[] nums, int k) {
        if (nums == null || k < 0)
            return;
        if (k > nums.length)
            k = k % nums.length;
        int a = nums.length - k;
        reverse(nums, 0, a - 1);
        reverse(nums, a, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    static void reverse(int[] arr, int b, int e) {
        while (b < e) {
            int temp = arr[b];
            arr[b] = arr[e];
            arr[e] = temp;
            b++;
            e--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
