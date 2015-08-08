public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        if (N == 1) return nums[0];
        
        int before1 = 0, before2 = 0;
        int max_with_first = 0, max_with_last = 0;
        
        for (int i = 0; i < N - 1; i++) {
            max_with_first = Math.max(nums[i] + before1, before2);
            before1 = before2;
            before2 = max_with_first;
        }
        
        before1 = 0;
        before2 = 0;
        
        for (int i = 1; i < N; i++) {
            max_with_last = Math.max(nums[i] + before1, before2);
            before1 = before2;
            before2 = max_with_last;
        }
        
        return Math.max(max_with_first, max_with_last);
    }
}
