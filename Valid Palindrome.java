public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null) return false;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            int a = s.charAt(start);
            int b = s.charAt(end);
            if (a < '0' || (a > '9' && a < 'A') || (a > 'Z' && a < 'a') || a > 'z') start++;
            else if (b < '0' || (b > '9' && b < 'A') || (b > 'Z' && b < 'a') || b > 'z' || (b < '0' && b > '9')) end--;
            else {
                if (a >= 'A' && a <= 'Z') a = a - 'A' + 'a';
                if (b >= 'A' && b <= 'Z') b = b - 'A' + 'a';
                if (a != b) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
