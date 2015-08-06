public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min_before = nums[0];
        int max_before = nums[0];
        int max_value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min_curr = Math.min(min_before * nums[i], Math.min(max_before * nums[i], nums[i]));
            int max_curr = Math.max(max_before * nums[i], Math.max(min_before * nums[i], nums[i]));
            min_before = min_curr;
            max_before = max_curr;
            max_value = Math.max(max_value, max_curr);
        }
        return max_value;
    }
}
