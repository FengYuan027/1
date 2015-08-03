public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int count = 1, max_count = 1;
        for (int i = 1; i < A.length; i++) {
            if ((i == 1 && A[i] != A[i-1]) || (A[i] - A[i-1])*(A[i-1] - A[i-2]) > 0) {
                count++;
            }
            else {
                max_count = Math.max(max_count, count);
                if (A[i] == A[i-1]) {
                    count = 1;
                }
                else {
                    count = 2;
                }
            }
        }
        max_count = Math.max(max_count, count);
        return max_count;
    }
}
