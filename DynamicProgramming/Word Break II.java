/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> solutions = new ArrayList<String>();
        if (!valid(s, wordDict)) return solutions;
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i+1);
            if (wordDict.contains(word)) {
                dfs(s.substring(i+1), solutions, word, wordDict);
            }
        }
        return solutions;
    }
    
    public boolean valid(String s, Set<String> wordDict) {
        int N = s.length();
        boolean[] isMatch = new boolean[N+1];
        isMatch[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; !isMatch[i] && j >= 0; j--) {
                isMatch[i] = isMatch[j] && wordDict.contains(s.substring(j, i));
            }
        }
        return isMatch[N];
    }
    
    private void dfs(String s, List<String> solutions, String solution, Set<String> wordDict) {
        if (s.equals("")) {
            solutions.add(solution);
        }
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i+1);
            if (wordDict.contains(word)) {
                dfs(s.substring(i+1), solutions, solution + " " + word, wordDict);
            }
        }
    }
}
