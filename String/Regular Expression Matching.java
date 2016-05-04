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

public class Solution1 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        if (p.length() <= 1 || p.charAt(1) != '*') {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) return isMatch(s.substring(1), p.substring(1));
            return false;
        }
        else {
            int index = 0;
            while (index < s.length() && (s.charAt(index) == p.charAt(0) || p.charAt(0) == '.')){
                if (isMatch(s.substring(index), p.substring(2))) return true;
                index++;
            }
            return isMatch(s.substring(index), p.substring(2));
        }
    }
}

public class Solution2 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() <= 1 || p.charAt(1) != '*') {
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
        else {
            return isMatch(s, p.substring(2)) || !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
        }
    }
}
