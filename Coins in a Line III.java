public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        int N = values.length;
        if (N == 1) return true;
        int[][] max_diff = new int[N][N];
        for(int i = 0; i < N; i++) {
            max_diff[i][i] = values[i];
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                max_diff[i][j] = Math.max(values[i] - max_diff[i+1][j], values[j] - max_diff[i][j-1]);
            }
        }
        return max_diff[0][N-1] > 0;
    }
}
