public class Solution {
    private int[] directions = {-1, 0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        int M = board.length, N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (search(board, i, j, M, N, word.toCharArray(), 0)) return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int x, int y, int M, int N, char[] word, int index) {
        if (board[x][y] != word[index]) return false;
        if (index == word.length - 1) return true;
        board[x][y] = '-';
        boolean result = false;
        for (int i = 0; i < directions.length - 1 && !result; i++) {
            int _x = x + directions[i], _y = y + directions[i+1];
            if (_x >= 0 && _x < M && _y >= 0 && _y < N) result |= search(board, _x, _y, M, N, word, index+1);
        }
        board[x][y] = word[index];
        return result;
    }
}
