public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length == 0) {
            return;
        }
        int odd = 0, even = nums.length - 1;
        while (odd <= even) {
            if (nums[odd] % 2 == 0) {
                swap(nums, odd, even--);
            }
            else odd++;
        }
        return;
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
