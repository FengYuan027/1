/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> currentLevel = new HashSet<String>(), visited = new HashSet<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<List<String>> paths = new ArrayList<List<String>>();
        currentLevel.add(beginWord);
        visited.add(beginWord);
        boolean found = false;
        int N = beginWord.length();
        while (!currentLevel.isEmpty()) {
            HashSet<String> nextLevel = new HashSet<String>();
            for (String str : currentLevel) {
                char[] current = str.toCharArray();
                for (int i = 0; i < N; i++) {
                    char c = current[i];
                    for (char d = 'a'; d <= 'z'; d++) {
                        if (c != d) {
                            current[i] = d;
                            String next = new String(current);
                            if (next.equals(endWord)) {
                                found = true;
                            }
                            if (!visited.contains(next) && wordList.contains(next)) {
                                nextLevel.add(next);
                                map.computeIfAbsent(next, k -> new ArrayList<String>()).add(str);
                            }
                            current[i] = c;
                        }
                    }
                }
            }
            if (found) {
                dfs(paths, new ArrayList<String>(), map, beginWord, endWord);
                break;
            }
            for (String str : nextLevel) {
                visited.add(str);
            }
            currentLevel = nextLevel;
        }
        return paths;
    }
    
    private void dfs(List<List<String>> paths, ArrayList<String> path,
                        HashMap<String, ArrayList<String>> map, String beginWord, String curr) {
        path.add(curr);
        if (curr.equals(beginWord)) {
            List<String> temp = new ArrayList<String>();
            for (int i = path.size() - 1; i >= 0; i--) {
                temp.add(new String(path.get(i)));
            }
            paths.add(temp);
            path.remove(path.size() - 1);
            return;
        }
        
        for (String parent : map.get(curr)) {
            dfs(paths, path, map, beginWord, parent);
        }
        path.remove(path.size() - 1);
    }
}
