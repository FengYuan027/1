/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }
    
    private int findPeak(int[] nums, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])) {
            return mid;
        }
        else if (mid > 0 && nums[mid] < nums[mid-1]) return findPeak(nums, start, mid - 1);
        else if (mid < nums.length - 1 && nums[mid] < nums[mid+1]) return findPeak(nums, mid + 1, end);
        else {
            int left = findPeak(nums, start, mid - 1);
            return left == -1 ? findPeak(nums, mid + 1, end) : left;
        }
    }
}
