public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null) return 0;
        int M = pages.length;
        if (M <= k) {
            int max_page = 0;
            for (int i = 0; i < M; i++) max_page = Math.max(max_page, pages[i]);
            return max_page;
        }
        int[][] sums = new int[M][M];
        for (int i = 0; i < M; i++) {
            int subsum = 0;
            for (int j = i; j < M; j++) {
                subsum += pages[j];
                sums[i][j] = subsum;
            }
        }
        int[][] min_copy = new int[M][k];
        for (int i = 0; i < M; i++) {
            min_copy[i][0] = sums[0][i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < M; j++) {
                min_copy[j][i] = Integer.MAX_VALUE;
                for (int n = i - 1; n < j; n++) {
                    min_copy[j][i] = Math.min(min_copy[j][i], Math.max(min_copy[n][i-1], sums[n+1][j]));
                }
            }
        }
        return min_copy[M-1][k-1];
    }
}
