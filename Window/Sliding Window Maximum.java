public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] maximums = new int[nums.length - k + 1];
        for (int start = 0, end = 0; end < nums.length; end++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[end]) {
                deque.pollLast();
            }
            deque.addLast(nums[end]);
            if (end >= k - 1) {
                maximums[end-k+1] = deque.peekFirst();
                if (deque.peekFirst() == nums[start]) {
                    deque.pollFirst();
                }
                start++;
            }
        }
        return maximums;
    }
}
