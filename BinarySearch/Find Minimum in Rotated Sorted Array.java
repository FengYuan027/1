public class Solution {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
    int start = 0, end = nums.length - 1;
    while (start < end) {
      if (nums[start] < nums[end]) return nums[start];
      int mid = start + (end - start)/2, val = nums[mid];
      if (val > nums[end]) start = mid + 1; // Remember to compare the end, rather than the start
      else end = mid;
    }
      return nums[start];
  }
}
