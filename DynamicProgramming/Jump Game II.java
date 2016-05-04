/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/

public class Solution1 {
    public int jump(int[] nums) {
        int high = 0, step = 0;
        while (high < nums.length - 1) {
            int nextHigh = high + 1;
            for (int i = step; i <= high; i++) {
                nextHigh = Math.max(nums[i] + i, nextHigh);
            }
            step++;
            high = nextHigh;
        }
        return step;
    }
}

public class Solution2 {
    public int jump(int[] nums) {
        int low = 0, high = 0, step = 0;
        while (high < nums.length - 1) {
            int nextHigh = high + 1;
            for (int i = low; i <= high; i++) {
                nextHigh = Math.max(nums[i] + i, nextHigh);
            }
            step++;
            low = high + 1;
            high = nextHigh;
        }
        return step;
    }
}
