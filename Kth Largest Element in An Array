public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (true) {
            if (start == end) return nums[start];
            int mid = (start + end) / 2;
            swap(nums, mid, end);
            int curr = start;
            for (int i = start; i < end; i++) {
                if (nums[i] > nums[end]) {
                    swap(nums, curr++, i);
                }
            }
            swap(nums, curr, end);
            if (curr == k-1) return nums[curr];
            if (curr >= k) end = curr - 1;
            else start = curr + 1;
        }
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
