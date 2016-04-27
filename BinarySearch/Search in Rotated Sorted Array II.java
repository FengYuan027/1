public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return search(nums, target, 0, nums.length - 1);
    }
    
    private boolean search(int[] nums, int target, int start, int end) {
        if (start > end) return false;
        int mid = start + (end - start) / 2, val = nums[mid];
        if (val == target) return true;
        if (val < nums[end]) {
            if (target > val && target <= nums[end]) return search(nums, target, mid + 1, end);
            else return search(nums, target, start, mid - 1);
        }
        else if (val > nums[end]) {
            if (target >= nums[start] && target < val) return search(nums, target, start, mid - 1);
            else return search(nums, target, mid + 1, end);
        }
        else {
            if (nums[start] != val) return search(nums, target, start, mid - 1);
            else return search(nums, target, start + 1, mid - 1) || search(nums, target, mid + 1, end - 1);
        }
    }
}
