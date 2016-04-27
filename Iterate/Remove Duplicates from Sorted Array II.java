public class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        for (int num : nums) {
            if (current < 2 || nums[current-2] != num) nums[current++] = num;
        }
        return current;
    }
}
