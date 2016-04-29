public class Solution1 {
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

public class Solution2 {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) swap(nums, i, two--);
            while (nums[i] == 0 && i > zero) swap(nums, i, zero++);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
