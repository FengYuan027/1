public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0 || s <= 0) {
            return -1;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int num = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0 && nums[i] >= s; i--) {
            num = Math.min(num, i + 1);
            if (nums[i] - nums[0] >= s) {
                int start = 0, end = i - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (nums[i] - nums[mid] >= s) {
                        start = mid + 1;
                    }
                    else end = mid - 1;
                }
                num = Math.min(num, i - end);
            }
        }
        return num == Integer.MAX_VALUE ? -1 : num;
    }
}
