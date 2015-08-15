public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int index_a = 0, index_b = 0;
        long min_diff = Integer.MAX_VALUE;
        while (index_a < A.length && index_b < B.length) {
            int a = A[index_a], b = B[index_b], diff;
            if (a >= b) {
                index_b++;
                diff = a - b;
            }
            else {
                index_a++;
                diff = b - a;
            }
            min_diff = Math.min(min_diff, (long) diff);
        }
        return (int)min_diff;
    }
}
