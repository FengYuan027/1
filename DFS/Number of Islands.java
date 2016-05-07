/*
*/

public class Solution {
    private int[] directions = {-1, 0, 1, 0, -1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int M = grid.length, N = grid[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    expand(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void expand(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < directions.length - 1; i++) {
            int _x = x + directions[i], _y = y + directions[i+1];
            if (_x >= 0 && _x < grid.length && _y >= 0 && _y < grid[0].length && grid[_x][_y] == '1') {
                expand(grid, _x, _y);
            }
        }
    }
}
