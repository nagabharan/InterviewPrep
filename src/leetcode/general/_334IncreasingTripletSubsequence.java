package leetcode.general;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];
            if (x >= z)
                x = z;
            else if (y >= z)
                y = z;
            else
                return true;
        }
        return false;
    }
}
