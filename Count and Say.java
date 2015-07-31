public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if (n <= 0) return "0";
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        String curr = "";
        int count = 1, index = 1;
        while (index < prev.length()) {
            if (prev.charAt(index) != prev.charAt(index-1)) {
                curr = curr + String.valueOf(count) + prev.charAt(index-1);
                count = 1;
            }
            else count++;
            index++;
        }
        curr = curr + String.valueOf(count) + prev.charAt(index-1);
        return curr;
    }
}
