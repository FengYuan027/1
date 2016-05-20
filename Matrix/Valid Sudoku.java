public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        if (board == null || board.length != N || board[0].length != N) return false;
        boolean[][] rows = new boolean[N][N], cols = new boolean[N][N], blks = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    int blkIndex = i/3 * N/3 + j/3;
                    int number = board[i][j] - '1';
                    if (rows[i][number] || cols[j][number] || blks[blkIndex][number]) return false;
                    rows[i][number] = cols[j][number] = blks[blkIndex][number] = true;
                }
            }
        }
        return true;
    }
}
