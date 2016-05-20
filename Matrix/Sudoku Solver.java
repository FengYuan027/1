public class Solution {
    private final int N = 9;
    public void solveSudoku(char[][] board) {
        Stack<int[]> s = new Stack<>(), done = new Stack<>();
        boolean[][] rows = new boolean[N][N], cols = new boolean[N][N], blks = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    s.push(new int[]{i, j});
                    board[i][j] = '0';
                }
                else {
                    int blkIndex = i/3 * N/3 + j/3, number = board[i][j] - '1';
                    rows[i][number] = cols[j][number] = blks[blkIndex][number] = true;
                }
            }
        }
        while (!s.isEmpty()) {
            int[] current = s.pop();
            int x = current[0], y = current[1], z = x/3 * N/3 + y/3, index = board[x][y] - '0';
            if (index - 1 >= 0) {
                rows[x][index-1] = cols[y][index-1] = blks[z][index-1] = false;
            }
            while (index < 9 && (rows[x][index] || cols[y][index] || blks[z][index])) index++;
            if (index == 9) {
                board[x][y] = '0';
                s.push(current);
                s.push(done.pop());
            }
            else {
                rows[x][index] = cols[y][index] = blks[z][index] = true;
                board[x][y] = (char)('0' + index + 1);
                done.push(current);
                
            }
        }
    }
}
