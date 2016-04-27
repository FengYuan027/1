public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[current]) {
                nums[++current] = nums[i];
            }
        }
        return current+1;
    }
}
