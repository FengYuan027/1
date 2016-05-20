/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

public class Solution {
    public int maxProduct(String[] words) {
        int[] map = new int[words.length];
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        });
        for (int i = 0; i < map.length; i++) {
            map[i] = getCode(words[i]);
        }
        int maxProduct = 0;
        for (int i = words.length - 1; i >= 1 && words[i].length() * words[i].length() > maxProduct; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((map[j]&map[i]) == 0) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                    break;
                }
            }
        }
        return maxProduct;
    }
    
    private int getCode(String word) {
        int code = 0;
        for (char c : word.toCharArray()) {
            code |= 1 << (c - 'a');
        }
        return code;
    }
}
