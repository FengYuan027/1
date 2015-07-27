public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length, N = matrix[0].length;
        int[][] graph = new int[M][N+1];
        for (int i = 0; i < N; i++) {
            int curr = 0;
            for (int j = 0; j < M; j++) {
                if (matrix[j][i] == 1) graph[j][i] = ++curr;
                else curr = 0;
            }
        }
        int max_area = 0;
        for (int i = 0; i < M; i++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0; j <= N; j++) {
                int curr_h = graph[i][j];
                while (!s.empty() && graph[i][s.peek()] > curr_h) {
                    int prev_index = s.pop();
                    int length = Math.min(graph[i][prev_index], s.empty()? j : j - s.peek() - 1);
                    max_area = Math.max(length*length, max_area);
                }
                s.push(j);
            }
        }
        return max_area;
    }
}
