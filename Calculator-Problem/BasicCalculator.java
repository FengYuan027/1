class Solution{
  // Assume input is valid
	public int compute(String input) {
		int current = 0, sign = 1, result = 0;
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
		}
		return result + current;
	}
}
