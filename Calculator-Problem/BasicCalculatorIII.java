public class Solution {
    public int calculate(String s) {
        int result = 0, current = 0, left = 1, sign = 1;
        char op = '*';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                current = current * 10 + (c - '0');
            }
            else if (c == '+' || c == '-') {
                result += op == '*' ? left * current * sign : left / current * sign;
                left = 1;
                current = 0;
                op = '*';
                sign = c == '+' ? 1 : -1;
            }
            else if (c == '*' || c == '/') {
                left = op == '*' ? left * current : left / current;
                op = c;
                current = 0;
            }
        }
        return (op == '*'? left*current*sign: left/current*sign) + result;
    }
}
