public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> maximums = new ArrayList<Integer>();
        if (nums == null || k < 1 || k > nums.length) {
            return maximums;
        }
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (deque.size() > 0 && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k; i < nums.length; i++) {
            maximums.add(nums[deque.getFirst()]);
            while (deque.size() > 0 && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            while (deque.size() > 0 && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        maximums.add(nums[deque.getFirst()]);
        return maximums;
    }
}
