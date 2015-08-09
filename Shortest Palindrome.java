public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        StringBuilder palindrome = new StringBuilder();
        for (int i = s.length()/2 - 1 + s.length()%2; i >= 0; i--) {
            if (scan(s, i, i+1)) {
                palindrome.append(new StringBuilder(s.substring(2*i + 2)).reverse());
                return palindrome.append(s).toString();
            }
            
            if (scan(s, i, i)) {
                palindrome.append(new StringBuilder(s.substring(2*i + 1)).reverse());
                return palindrome.append(s).toString();
            }
        }
        return palindrome.toString();
    }
    
    public boolean scan(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return left < 0;
    }
}
