/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String reversed = reverse(s.trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) != ' ') {
                int end = i + 1;
                while (end < reversed.length() && reversed.charAt(end) != ' ') end++;
                sb.append(reverse(reversed.substring(i, end)));
                if (end < reversed.length()) sb.append(' ');
                i = end - 1;
            }
        }
        return sb.toString();
    }
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
