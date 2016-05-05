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

public class Solution2 {
    public boolean isNumber(String s) {
        int index = 0;
        char[] number = s.toCharArray();
        while (index < number.length && isSpace(number[index])) {
            index++;
        }
        if (index < number.length && isSign(number[index])) {
            index++;
        }
        boolean hasNumber = false;
        while (index < number.length && isDigit(number[index])) {
            hasNumber = true;
            index++;
        }
        if (index < number.length && number[index] == '.') {
            index++;
        }
        while (index < number.length && isDigit(number[index])) {
            hasNumber = true;
            index++;
        }
        if (hasNumber && index < number.length && isE(number[index])) {
            hasNumber = false;
            index++;
            if (index < number.length && isSign(number[index])) {
                index++;
            }
            while (index < number.length && isDigit(number[index])) {
                index++;
                hasNumber = true;
            }
        }
        while (index < number.length && isSpace(number[index])) {
            index++;
        }
        return index == number.length && hasNumber;
    }
    
    private boolean isDigit (char c) { return c >= '0' && c <= '9';}
    
    private boolean isSign(char c) { return c == '-' || c == '+'; }
    
    private boolean isE(char c) { return c == 'e'; }
    
    private boolean isSpace(char c) { return c == ' ';}
}
