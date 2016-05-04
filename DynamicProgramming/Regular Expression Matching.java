/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int M = s.length(), N = p.length();
        boolean[][] match = new boolean[M+1][N+1];
        match[0][0] = true;
        for (int i = 1; i <= M; i++) {
            match[i][0] = false;
        }
        for (int j = 1; j <= N; j++) {
            match[0][j] = j > 1 && p.charAt(j-1) == '*' && match[0][j-2];
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (p.charAt(j-1) != '*') {
                    match[i][j] = match[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
                else {
                    match[i][j] = match[i][j-2] || (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && match[i-1][j];
                }
            }
        }
        return match[M][N];
    }
}
