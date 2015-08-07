public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int max_start = 0, max_length = 1;
        for (int i = 1; i < s.length(); i++) {
            int length = expand(s, i - 1, i);
            if (length > max_length) {
                max_start = i - length / 2;
                max_length = length;
            }
            length = expand(s, i, i);
            if (length > max_length) {
                max_start = i - length / 2;
                max_length = length;
            }
        }
        return s.substring(max_start, max_start + max_length);
    }
    
    public int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
