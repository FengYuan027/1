/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        if (n <= 0) return solutions;
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = -1;
        }
        int current = 0;
        while (current >= 0) {
            if (current == n) {
                solutions.add(generateSolution(positions,n));
                current--;
            }
            else {
                positions[current]++;
                while (positions[current] < n && !valid(positions, current)) {
                    positions[current]++;
                }
                if (positions[current] == n) {
                    positions[current] = -1;
                    current--;
                }
                else current++;
            }
        }
        return solutions;
    }
    
    private boolean valid(int[] positions, int bottom) {
        for (int i = 0 ; i < bottom; i++) {
            if (positions[bottom] == positions[i] || bottom - i == Math.abs(positions[bottom] - positions[i])){
                return false;
            }
        }
        return true;
    }
    
    private List<String> generateSolution(int[] positions, int n) {
        List<String> solution = new ArrayList<String>();
        char[] line = new char[n];
        for (int i = 0; i < n; i++) line[i] = '.';
        for (int i = 0; i < n; i++) {
            line[positions[i]] = 'Q';
            solution.add(new String(line));
            line[positions[i]] = '.';
        }
        return solution;
    }
}
