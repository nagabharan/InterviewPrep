package leetcode;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _4MedianOfTwoSortedArrays {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 != 0)
            return (double) findK(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
        else
            return (findK(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findK(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;

    }

    static int findK(int[] nums1, int[] nums2, int k, int sa, int ea, int sb, int eb) {
        int alen = ea - sa + 1;
        int blen = eb - sb + 1;

        if (alen == 0)
            return nums2[sb + k];
        if (blen == 0)
            return nums1[sa + k];
        if (k == 0)
            return nums1[sa] < nums2[sb] ? nums1[sa] : nums2[sb];

        int amid = alen * k / (alen + blen);
        int bmid = k - amid - 1;

        amid += sa;
        bmid += sb;

        if (nums1[amid] > nums2[bmid]) {
            k = k - (bmid - sb + 1);
            ea = amid;
            sb = bmid + 1;
        } else {
            k = k - (amid - sa + 1);
            eb = bmid;
            sa = amid + 1;
        }

        return findK(nums1, nums2, k, sa, ea, sb, eb);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
