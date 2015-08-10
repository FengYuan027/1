public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0) {
            return false;
        }
        HashMap<Long, Long> buckets = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long index = ((long)nums[i] - Integer.MIN_VALUE) / ((long)t + 1);
            if (buckets.containsKey(index) ||
                buckets.containsKey(index-1) && nums[i] - buckets.get(index-1) <= t ||
                buckets.containsKey(index+1) && buckets.get(index+1) - nums[i] <= t) {
                    return true;
                }
            if (i >= k) {
                long old_index = ((long)nums[i-k] - Integer.MIN_VALUE) / ((long)t + 1);
                buckets.remove(old_index);
            }
            buckets.put(index, (long)nums[i]);
        }
        return false;
    }
}
