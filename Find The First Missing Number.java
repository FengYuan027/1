public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int index = Math.abs(nums[i]);
                if (index - 1 < nums.length && nums[index-1] >= 0 ) {
                    if (nums[index - 1] != 0) {
                        nums[index-1] = 0 - nums[index-1];
                    }
                    else {
                        nums[index-1] = 0 - (nums.length + 1);
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return 0;
    }
}
