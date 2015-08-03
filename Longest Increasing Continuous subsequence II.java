public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int M = A.length, N = A[0].length;
        int[][] map = new int[M][N];
        int max_length = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                max_length = Math.max(max_length, visit(A, i, j, map, M, N));
            }
        }
        return max_length;
    }
    
    public int visit(int[][] A, int i, int j, int[][] map, int M, int N) {
        if (map[i][j] > 0) return map[i][j];
        int length = 1;
        if (i + 1 < M && A[i+1][j] > A[i][j]) {
            length = Math.max(1 + visit(A, i+1, j, map, M, N), length);
        }
        if (i - 1 >= 0 && A[i-1][j] > A[i][j]) {
            length = Math.max(1 + visit(A, i-1, j, map, M, N), length);
        }
        if (j + 1 < N && A[i][j+1] > A[i][j]) {
            length = Math.max(1 + visit(A, i, j+1, map, M, N), length);
        }
        if (j - 1 >= 0 && A[i][j-1] > A[i][j]) {
            length = Math.max(1 + visit(A, i, j-1, map, M, N), length);
        }
        map[i][j] = length;
        return length;
    }
}
