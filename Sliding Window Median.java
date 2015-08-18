public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> medians = new ArrayList<Integer>();
        if (nums == null || k < 1 || nums.length < k) {
            return medians;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] < maxHeap.peek()) {
                maxHeap.add(nums[i]);
            }
            else {
                minHeap.add(nums[i]);
            }
            maintainHeaps(maxHeap, minHeap);
            if (i >= k - 1) {
                medians.add(maxHeap.peek());
                int remove = nums[i - k + 1];
                if (remove <= maxHeap.peek()) {
                    maxHeap.remove(remove);
                }
                else {
                    minHeap.remove(remove);
                }
                maintainHeaps(maxHeap, minHeap);
            }
        }
        return medians;
    }
    
    private void maintainHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }
}
