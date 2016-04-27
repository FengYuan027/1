public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        return findMin(nums, 0, nums.length - 1);
    }
    
    private int findMin(int[] nums, int start, int end) {
        if (start == end || nums[start] < nums[end]) return nums[start];
        int mid = start + (end - start) / 2, val = nums[mid];
        if (val > nums[end]) return findMin(nums, mid + 1, end);
        else if (val < nums[end]) return findMin(nums, start, mid);
        else {
            if (nums[start] != val) return findMin(nums, start, mid);
            else return Math.min(findMin(nums, start, mid), findMin(nums, mid + 1, end));
        }
    }
}
