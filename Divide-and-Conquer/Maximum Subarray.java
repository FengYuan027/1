/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubarray(nums, 0, nums.length - 1).max;
    }
    
    private SubSum maxSubarray(int[] nums, int start, int end) {
        if (start == end) {
            return new SubSum(nums[start], nums[start], nums[start], nums[start]);
        }
        SubSum l = maxSubarray(nums, start, start + (end - start)/2),
                r = maxSubarray(nums, start + (end - start)/2 + 1, end);
        int left = Math.max(l.left, l.total + r.left),
            right = Math.max(r.right, r.total + l.right),
            max = Math.max(l.right + r.left, Math.max(l.max, r.max)),
            total = l.total + r.total;
        return new SubSum(left, right, max, total);
    } 
    
    private class SubSum {
        int left, right, max, total;
        public SubSum(int l, int r, int m, int t) {
            left = l;
            right = r;
            max = m;
            total = t;
        }
    }
}
