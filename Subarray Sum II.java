public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if (A == null || A.length < 1 || start > end) {
            return 0;
        }
        int[] sums = new int[A.length+1];
        for (int i = 1; i <= A.length; i++) {
            sums[i] = sums[i-1] + A[i-1];
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j <= A.length; j++) {
                int diff = sums[j] - sums[i];
                if (diff >= start && diff <= end) count++;
            }
        }
        return count;
    }
}
