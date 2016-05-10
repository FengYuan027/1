/*
 Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space? 
*/

public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for (int i = 0; i < s.length; i++) {
            int end = i + 1;
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverse(s, i, end-1);
            i = end;
        }
    }
    
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }
}
