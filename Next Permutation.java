public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int target = nums.length - 2;
        while (target >= 0 && nums[target] >= nums[target + 1]) {
            target--;
        }
        if (target >= 0) {
            int greater = nums.length - 1;
            while (greater > target && nums[greater] <= nums[target]) {
                greater--;
            }
            swap(nums,target, greater);
        }
        int left = target + 1, right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
        return;
    }
    
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
