public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num1 = 0, num2 = 0, max_profit = 0;
        for (int i = 0; i < nums.length; i++) {
            max_profit = Math.max(nums[i] + num1, num2);
            num1 = num2;
            num2 = max_profit;
        }
        return max_profit;
    }
}
