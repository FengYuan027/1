public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        return mergeCountSum(sums, lower, upper, 0, sums.length - 1);
    }
    
    private int mergeCountSum(long[] sums, int lower, int upper, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = mergeCountSum(sums, lower, upper, start, mid) + mergeCountSum(sums, lower, upper, mid + 1, end);
        long[] left = new long[mid-start+1], right = new long[end - mid];
        for (int i = 0; i <= mid - start; i++) left[i] = sums[start+i];
        for (int i = 0; i < end - mid; i++) right[i] = sums[mid + 1 + i];
        int leftIndex = 0, rightIndex = 0, m = 0, n = 0, current = start;
        while (leftIndex <= mid - start) {
            while (m < end - mid && right[m] - left[leftIndex] < lower) m++;
            while (n < end - mid && right[n] - left[leftIndex] <= upper) n++;
            count += n - m;
            while (rightIndex < end - mid && right[rightIndex] < left[leftIndex]) sums[current++] = right[rightIndex++];
            sums[current++] = left[leftIndex++];
        }
        while (rightIndex < end - mid) sums[current++] = right[rightIndex++];
        return count;
    }
}
