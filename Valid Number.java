public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return false;
        }
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            index++;
        }
        boolean hasNumber = false;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            hasNumber = true;
            index++;
        }
        if (index < s.length() && s.charAt(index) == '.') index++;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            hasNumber = true;
            index++;
        }
        if (index < s.length() && s.charAt(index) == 'e' && hasNumber) {
            index++;
            if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) index++;
            hasNumber = false;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                hasNumber = true;
                index++;
            }
        }
        while (index < s.length() && s.charAt(index) == ' ') index++;
        return index == s.length() && hasNumber;
    }
}
