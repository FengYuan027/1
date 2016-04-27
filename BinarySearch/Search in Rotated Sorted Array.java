public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2, val = nums[mid];
            if (val == target) return mid;
            if (val < nums[end]) {
                if (target > val && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
            else {
                if (target >= nums[start] && target < val) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}
