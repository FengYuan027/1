class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) return 0;
        int min_val = Integer.MAX_VALUE, max_val = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max_val) max_val = nums[i];
            if (nums[i] < min_val) min_val = nums[i];
        }
        if (max_val == min_val) {
            return 0;
        }
        int step = Math.max(1, (max_val - min_val)/(nums.length-1));
        Hashtable<Integer, Bucket> buckets= new Hashtable<Integer, Bucket>();
        for (int i = 0; i < nums.length; i++) {
            int hash = (nums[i] - min_val)/step;
            if (!buckets.containsKey(hash)) {
                buckets.put(hash, new Bucket(nums[i]));
            }
            else buckets.get(hash).add(nums[i]);
        }
        Bucket prev = null, curr = null;
        int hash = 0, max_gap = -1;
        while (hash <= (max_val - min_val)/step) {
            if (buckets.containsKey(hash)) {
                if (prev == null) prev = buckets.get(hash);
                else {
                    curr = buckets.get(hash);
                    max_gap = Math.max(curr.min-prev.max, max_gap);
                    prev = curr;
                }
            }
            hash++;
        }
        return max_gap;
    }
    
    public class Bucket {
        int min;
        int max;
        public Bucket(int val) {
            this.min = val;
            this.max = val;
        }
        
        public void add(int val) {
            if (val < min) {
                min = val;
            }
            else if (val > max) {
                max = val;
            }
        }
    }
}
