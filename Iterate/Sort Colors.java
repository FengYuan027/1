public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, index = 0;
        while (index <= two) {
            if (nums[index] == 0) {
                swap(nums, zero++, index++);
            }
            else if (nums[index] == 2) {
                swap(nums, index, two--);
            }
            else index++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
