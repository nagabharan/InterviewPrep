package leetcode.general;

/**
 * Created by nagabharan on 21-Sep-16.
 */
public class _88MergeSortedArrays {
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j]))
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }

}
