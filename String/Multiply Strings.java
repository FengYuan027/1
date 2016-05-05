public class Solution {
    public String multiply(String num1, String num2) {
        int M = num1.length(), N = num2.length();
        char[] result = new char[M + N];
        int carry = 0;
        for (int current = 0; current < result.length; current++) {
            int total = carry;
            for (int i = 0, j = current; i <= current ; i++, j--) {
                if (i < M && j < N) {
                    total += (num1.charAt(M - i - 1) - '0') * (num2.charAt(N - j - 1) - '0');
                }
            }
            result[M + N - current - 1] = (char)(total%10 + '0');
            carry = total / 10;
        }
        int index = 0;
        while (index < M + N && result[index] == '0') index++;
        if (index == result.length) return "0";
        return new String(result).substring(index);
    }
}
