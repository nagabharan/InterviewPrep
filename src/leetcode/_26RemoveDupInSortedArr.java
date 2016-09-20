package leetcode;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _26RemoveDupInSortedArr {
    static int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }

        return i + 1;

        /*if(nums.length<2)
            return nums.length;

        int i=0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;*/

        /*int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                count++;
        }

        return (nums.length-count);*/
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }
}
