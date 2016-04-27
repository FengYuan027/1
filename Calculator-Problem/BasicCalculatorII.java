public class Solution1 {
	public int calculate(String input) {
		Stack<Integer> s = new Stack<Integer>();
		int current = 0, result = 0, sign = 1;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				current = current * 10 + (c - '0');
			}
			else if (c == '+' || c == '-') {
				result += current * sign;
				current = 0;
				sign = c == '+' ? 1 : -1;
			}
			else if (c == '(') {
				s.push(result);
				s.push(sign);
				result = 0;
				sign = 1;
			}
			else if (c == ')') {
				result += current * sign; // If not do this, will not be able to retrieve the sign before '('
				current = 0;
				result *= s.pop();
				result += s.pop();
				sign = 1;
			}
		}
		return result + current * sign;
	}
}

public class Solution2 {
    public int calculate(String input) {
        int result = 0, current = 0, sign = 1;
        Stack<Integer> s = new Stack<Integer>();
        s.push(sign);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                current = current * 10 + (c - '0');
            }
            else if (c == '+' || c == '-') {
                result += current * sign;
                current = 0;
                sign = s.peek() * (c == '+' ? 1 : -1);
            }
            else if (c == '(') {
                s.push(sign);
            }
            else if (c == ')') {
                s.pop(); // Don't need to compute since the effect to sign is global
            }
        }
        return result + current * sign;
    }
}
