/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
"e10" => false
"1e" => false
"1e1.5" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. 

*/

public class Solution1 {
    public boolean isNumber(String s) {
        char[] num = s.trim().toCharArray();
        boolean hasNumber = false;
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasENumber = true;
        for (int i = 0; i < num.length; i++) {
            char c = num[i];
            if (c >= '0' && c <= '9') {
                if (hasE) hasENumber = true;
                else hasNumber = true;
            }
            else if (c == '.') {
                if (hasDot || hasE) return false;
                hasDot = true;
            }
            else if (c == 'e') {
                if (hasE) return false;
                hasE = true;
                hasENumber = false;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && num[i-1] != 'e') return false;
            }
            else return false;
        }
        return hasNumber && hasENumber;
    }
}
