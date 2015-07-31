public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> prevs = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                prevs.push(c);
            }
            else {
                if (prevs.empty()) return false;
                char prev = prevs.pop();
                if (c == ')' && prev != '(' || c == ']' && prev != '[' || c == '}' && prev != '{') {
                    return false;
                }
            }
        }
        return prevs.empty();
    }
}
