/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int M = board.length, N = board[0].length;
        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O') expand(board, i, 0);
            if (board[i][N-1] == 'O') expand(board, i, N-1);
        }
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O') expand(board, 0, j);
            if (board[M-1][j] == 'O') expand(board, M-1, j);
        }
        for (int i = 1; i < M - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
    
    private void expand(char[][] board, int x, int y) {
        board[x][y] = 'Y';
        if (x > 1 && board[x-1][y] == 'O') expand(board, x-1, y);
        if (x < board.length - 2 && board[x+1][y] == 'O') expand(board, x+1, y);
        if (y > 1 && board[x][y-1] == 'O') expand(board, x, y-1);
        if (y < board[0].length - 2 && board[x][y+1] == 'O') expand(board, x, y+1);
    }
}
