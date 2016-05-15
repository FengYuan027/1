/*
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
*/

public class TicTacToe {
    private int[][] board;
    private int[][] rows, cols;
    private int[] diagonal, antiDiagonal;
    private int length, winner;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        length = n;
        board = new int[n][n];
        rows = new int[2][n];
        cols = new int[2][n];
        diagonal = new int[2];
        antiDiagonal = new int[2];
        winner = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (winner > 0) return winner;
        board[row][col] = player;
        if (++rows[player-1][row] == length || ++cols[player-1][col] == length) {
            winner = player;
            return player;
        }
        if (row == col && ++diagonal[player-1] == length || row == length - col - 1 && ++antiDiagonal[player-1] == length) {
            winner = player;
            return player;
        }
        return 0;
    }
}
