/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> head = new HashSet<String>(), tail = new HashSet<String>(), visited = new HashSet<String>();
        head.add(beginWord);
        tail.add(endWord);
        int N = beginWord.length(), step = 2;
        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                HashSet<String> t = head;
                head = tail;
                tail = t;
            }
            HashSet<String> nextLevel = new HashSet<String>();
            for (String s: head) {
                char[] current = s.toCharArray();
                for (int i = 0; i < N; i++) {
                    char c = current[i];
                    for (char d = 'a'; d <= 'z'; d++) {
                        if (d != c) {
                            current[i] = d;
                            String next = new String(current);
                            if (tail.contains(next)) return step;
                            if (!visited.contains(next) && wordList.contains(next)) {
                                nextLevel.add(next);
                                visited.add(next);
                            }
                            current[i] = c;
                        }
                    }
                }
            }
            head = nextLevel;
            step++;
        }
        return 0;
    }
}
