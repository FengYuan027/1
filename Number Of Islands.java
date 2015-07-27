public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int M = grid.length, N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        int num = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    visit(grid, i, j, visited);
                    num++;
                }
            }
        }
        return num;
    }
    
    public void visit(boolean[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i - 1 >= 0 && grid[i-1][j] && !visited[i-1][j]) visit(grid, i-1, j, visited);
        if (i + 1 < grid.length && grid[i+1][j] && !visited[i+1][j]) visit(grid, i+1, j, visited);
        if (j - 1 >= 0 && grid[i][j-1] && !visited[i][j-1]) visit(grid, i, j-1, visited);
        if (j + 1 < grid[0].length && grid[i][j+1] && !visited[i][j+1]) visit(grid, i, j+1, visited);
    }
}
