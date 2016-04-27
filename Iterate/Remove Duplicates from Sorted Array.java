public class Solution1 {
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

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        for (int num : nums) {
            if (current < 1 || num != nums[current-1]) nums[current++] = num;
        }
        return current;
    }
}
