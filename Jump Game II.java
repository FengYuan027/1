public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length < 1) {
            return 0;
        }
        int steps = 0, prev = -1, curr = 0;
        while (curr < A.length) {
            steps++;
            int curr_max = 0;
            for (int i = prev + 1; i <= curr; i++) {
                curr_max = Math.max(curr_max, A[i] + i);
            }
            prev = curr;
            curr = curr_max;
        }
        return steps;
    }
}
